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

//username password host given
//result is response

def url = "http://${host}/rest/management/dashboards".toURL()

result = [:]
result.host = host
result.dashboards = [:]

def con = url.openConnection()
String userpassword = username + ":" + password
con.setRequestProperty("Authorization", "Basic "+ userpassword.bytes.encodeBase64().toString())
 
def dashboards = new XmlSlurper().parse(con.inputStream)

dashboards.dashboard.each { dashboard ->
	println "${dashboard.@id} -> ${dashboard.@href}"
	result.dashboards[dashboard.@id.toString()] = [href:dashboard.@href.toString(), jnlp:dashboard.@jnlp.toString() ,desc:dashboard.@description.toString() ]
}

 
if (con != null)
	con.disconnect()
	
