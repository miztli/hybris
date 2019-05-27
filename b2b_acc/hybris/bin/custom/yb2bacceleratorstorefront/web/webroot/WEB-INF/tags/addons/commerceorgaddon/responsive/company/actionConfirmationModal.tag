<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ attribute name="id" required="true" type="java.lang.String" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="targetUrl" required="true" type="java.lang.String" %>
<%@ attribute name="messageKey" required="true" type="java.lang.String" %>
<%@ attribute name="messageArguments" required="false" type="java.lang.String"%>
<%@ attribute name="buttonsVisible" required="false" type="java.lang.Boolean"%>
<%@ attribute name="actionButtonLabelKey" required="false" type="java.lang.String"%>
<%@ attribute name="actionButtonCSSClass" required="false" type="java.lang.String"%>
<%@ attribute name="actionButtonAsLink" required="false" type="java.lang.Boolean"%>
<%@ attribute name="useSourceElementUrl" required="false" type="java.lang.Boolean"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<c:set var="displayButtons" value="${(empty buttonsVisible) ? true : buttonsVisible}"/>
<c:set var="mainButtonLabelKey" value="${(empty actionButtonLabelKey) ? 'text.company.disable.button' : actionButtonLabelKey}"/>
<c:set var="mainButtonCSSClass" value="${(empty actionButtonCSSClass) ? 'confirm' : actionButtonCSSClass}"/>
<c:set var="dataUseSourceElementUrl" value="${(empty useSourceElementUrl) ? false : useSourceElementUrl}"/>
<c:set var="useLinkForMainAction" value="${(empty actionButtonAsLink) ? false : actionButtonAsLink}"/>

<div style="display:none">
    <div id="js-action-confirmation-modal-content-${fn:escapeXml(id)}" data-use-source-element-url="${fn:escapeXml(dataUseSourceElementUrl)}">
        <div class="row">
            <div class="description col-sm-12">
                <spring:theme code="${messageKey}" arguments="${messageArguments}"/>
            </div>
        </div>

        <c:if test="${displayButtons}">
            <div class="modal-actions">
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-sm-push-6">
                        <c:choose>
                            <c:when test="${useLinkForMainAction}">
                                <a href="${fn:escapeXml((empty targetUrl) ? '#' : targetUrl)}" class="url-holder">
                                    <button type="button" class="${fn:escapeXml(mainButtonCSSClass)} btn btn-block btn-primary">
                                        <spring:theme code="${mainButtonLabelKey}"/>
                                    </button>
                                </a>
                            </c:when>
                            <c:otherwise>
                                <form:form action="${targetUrl}" class="url-holder">
                                    <button type="submit" class="${fn:escapeXml(mainButtonCSSClass)} btn btn-block btn-primary">
                                        <spring:theme code="${mainButtonLabelKey}"/>
                                    </button>
                                </form:form>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <a href="#" class="js-action-confirmation-modal-cancel col-xs-12 col-sm-6 col-sm-pull-6">
                        <button id="backButton" class="btn-default btn btn-block">
                            <spring:theme code="text.company.cancel.button"/>
                        </button>
                    </a>
                </div>
            </div>
        </c:if>
    </div>
</div>