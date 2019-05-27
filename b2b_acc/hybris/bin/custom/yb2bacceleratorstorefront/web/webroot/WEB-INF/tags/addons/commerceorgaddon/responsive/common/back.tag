<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="cancelUrl" required="true" type="java.lang.String"%>
<%@ attribute name="displayTextMsgKey" required="true" type="java.lang.String"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<a class="back_button" href="${fn:escapeXml(cancelUrl)}">
    <button id="backButton" class="form btn-default btn btn-block" type="button">
        <spring:theme code="${displayTextMsgKey}"/>
    </button>
</a>
