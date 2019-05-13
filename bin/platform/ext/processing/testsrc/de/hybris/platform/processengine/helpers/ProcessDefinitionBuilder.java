/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.processengine.helpers;

import de.hybris.platform.processengine.enums.ProcessState;
import de.hybris.platform.scripting.enums.ScriptType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class ProcessDefinitionBuilder
{
	private Optional<ProcessDefinitionBuilder> parent = Optional.empty();
	private String header;
	private String footer;
	private List<String> endNodes = new ArrayList<>();
	private List<String> nodes = new ArrayList<>();

	private ProcessDefinitionBuilder(){
		//
	}

	private ProcessDefinitionBuilder(String header, String footer) {
		this.setHeader(header);
		this.setFooter(footer);
	}

	private ProcessDefinitionBuilder addNode(String node, List<String> endNodes) {
		this.nodes.add(node);
		if(!endNodes.isEmpty())
			this.endNodes.addAll(endNodes);
		return this;
	}

	private String composeWithBody() {
		return this.getBody(new StringBuilder(this.getHeader())).append(this.getFooter()).toString();
	}

	private ProcessDefinitionBuilder saveNode() {
		return this.parent.map(p -> p.addNode(this.composeWithBody(), this.getEndNodes())).orElse(this);
	}

	protected StringBuilder getBody(StringBuilder sb){
		this.nodes.forEach(sb::append);
		this.endNodes.forEach(sb::append);
		return sb;
	}

	public String build() {
		return this.saveNode().composeWithBody();
	}

	public static ProcessDefinitionBuilder builder(String procName, String startNode) {
		return new ProcessDefinitionBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
				+ "<process xmlns=\"http://www.hybris.de/xsd/processdefinition\" name=\""+procName+"\" start=\""+startNode+"\">\n",
				"</process>");
	}

	public ActionNodeBuilder withActionNode(String id, String beanName) {
		return new ActionNodeBuilder(this.saveNode(), id, beanName);
	}

	public WaitNodeBuilder withWaitNode(String id, String then) {
		return new WaitNodeBuilder(this.saveNode(), id, then, Optional.empty());
	}
	public WaitNodeBuilder withWaitNode(String id, String then, Boolean prependProcessCode) {
		return new WaitNodeBuilder(this.saveNode(), id, then, Optional.of(prependProcessCode));
	}

	public ScriptActionNodeBuilder withScriptActionNode(String id) {
		return new ScriptActionNodeBuilder(this.saveNode(), id);
	}

	public final ProcessDefinitionBuilder addEndNode(String id, ProcessState state, String message) {
		this.endNodes.add("\t<end id=\""+id+"\" state=\""+state.getCode()+"\">"+message+"</end>\n");
		return this;
	}

	public Optional<ProcessDefinitionBuilder> getParent()
	{
		return parent;
	}

	public void setParent(Optional<ProcessDefinitionBuilder> parent)
	{
		this.parent = parent;
	}

	public String getHeader()
	{
		return header;
	}

	public void setHeader(String header)
	{
		this.header = header;
	}

	public String getFooter()
	{
		return footer;
	}

	public void setFooter(String footer)
	{
		this.footer = footer;
	}

	public List<String> getEndNodes()
	{
		return endNodes;
	}

	public static class ActionNodeBuilder extends ProcessDefinitionBuilder {
		private Map<String, String> parameters = new HashMap<>();
		private Map<String, String> transitions = new HashMap<>();
		private ActionNodeBuilder(){}
		private ActionNodeBuilder(ProcessDefinitionBuilder parent, String name, String beanName) {
			super("\t<action id=\""+name+"\" bean=\""+beanName+"\" >\n", "\t</action>\n");
			this.setParent(Optional.of(parent));
		}

		public ActionNodeBuilder withTransition(String name, String to) {
			transitions.put(name, to);
			return this;
		}

		public ActionNodeBuilder withParameter(String name, String val) {
			parameters.put(name, val);
			return this;
		}

		@Override
		protected StringBuilder getBody(StringBuilder sb) {
			this.parameters.forEach((k,v) -> sb.append("\t\t<parameter name=\"").append(k).append("\" value=\"").append(v).append("\"/>\n"));
			this.transitions.forEach((k,v) -> sb.append("\t\t<transition name=\"").append(k).append("\" to=\"").append(v).append("\"/>\n"));
			return sb;
		}
	}

	public static class WaitNodeBuilder extends ProcessDefinitionBuilder {
		private String event;
		private List<String> choice = new ArrayList<>();
		private Optional<String> timeout = Optional.empty();

		private WaitNodeBuilder(ProcessDefinitionBuilder parent, String id, String then, Optional<Boolean> prependProcessCode) {
			super("\t<wait id=\""+id+"\" then=\""+then+""+prependProcessCode.map(b -> "\" prependProcessCode=\""+b).orElse("")+"\">\n", "\t</wait>\n");
			this.setParent(Optional.of(parent));
		}

		public WaitNodeBuilder withEvent(String event)
		{
			this.event = event;
			return this;
		}

		public WaitNodeBuilder withChoice(String id, String then) {
			this.choice.add("\t\t\t<choice id='"+id+"' then='"+then+"'/>");
			return this;
		}

		public WaitNodeBuilder withTimeout(String delay, String then) {
			this.timeout = Optional.of("<timeout delay='"+delay+"' then='"+then+"' />");
			return this;
		}

		@Override
		protected StringBuilder getBody(StringBuilder sb)
		{
			if(this.choice.isEmpty())
			{
				sb.append("\t\t<event>").append(event).append("</event>\n");
			}
			else
			{
				sb.append("\t\t<case event='").append(event).append("'>");
				choice.forEach(sb::append);
				sb.append("\t\t</case>");
			}
			return timeout.map(sb::append).orElse(sb);
		}
	}

	public static class ScriptActionNodeBuilder extends ActionNodeBuilder {
		private String script = "";
		private ScriptActionNodeBuilder(ProcessDefinitionBuilder parent, String id){
			this.setParent(Optional.of(parent));
			this.setHeader("\t<scriptAction id='"+id+"'>\n");
			this.setFooter("\t</scriptAction>\n");
		}

		public ScriptActionNodeBuilder withScript(ScriptType scriptType, String script) {
			this.script = "\t\t<script type='" + scriptType.getCode().toLowerCase() + "'>" + script + "</script>\n";
			return this;
		}

		@Override
		protected StringBuilder getBody(StringBuilder sb)
		{
			return super.getBody(sb.append(script));
		}
	}



}
