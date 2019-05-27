<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="orderApprovalData" required="true" type="de.hybris.platform.b2bacceleratorfacades.order.data.B2BOrderApprovalData"%>
<%@ attribute name="orderApprovalDecisionForm" required="true" type="de.hybris.platform.b2bacceleratoraddon.forms.OrderApprovalDecisionForm"%>
<%@ attribute name="orderApprovalDecisionURL" required="true" type="java.lang.String"%>
<%@ attribute name="decision" required="true" type="java.lang.String"%>
<%@ attribute name="actionButtonLabel" required="true" type="java.lang.String"%>
<%@ attribute name="actionButtonClass" required="true" type="java.lang.String"%>
<%@ attribute name="modalPopupClass" required="true" type="java.lang.String"%>
<%@ attribute name="commentLabel" required="true" type="java.lang.String"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<c:set var="commentMaxChars" value="255" />

<div>
    <form:form method="post" cssClass="orderApprovalDecisionForm" commandName="orderApprovalDecisionForm"
        action="${orderApprovalDecisionURL}">
        <c:choose>
            <c:when test="${orderApprovalData.approvalDecisionRequired}">
                <div>
                    <form:input type="hidden" name="workflowActionCode" path="workFlowActionCode" value="${orderApprovalData.workflowActionModelCode}" />
                    <form:input type="hidden" name="approverSelectedDecision" path="approverSelectedDecision" id="approverSelectedDecision" />

                    <button class="${fn:escapeXml(actionButtonClass)}" type="button">
                        <spring:theme code="${actionButtonLabel}" />
                    </button>
                </div>
                <div style="display: none">
                    <div class="${fn:escapeXml(modalPopupClass)} comment-modal">
                        <div class="headline">
                            <spring:theme code="${commentLabel}" />
                        </div>
                        <form:textarea path="comments" maxlength="255"></form:textarea>
                        <div class="form-actions clearfix" style="clear: both;">
                            <div class="help-block">
                                <spring:theme code="responsive.checkout.summary.requestApproval.maxchars" arguments="${commentMaxChars}" />
                            </div>

                            <div class="form-actions clearfix row" style="clear:both;">
                                <div class="col-sm-6">
                                    <button type="button" class="btn btn-default btn-block cancelOrderApprovalCommentButton">
                                        <spring:theme code="checkout.summary.requestApproval.cancel" />
                                    </button>
                                </div>
                                <div class="col-sm-6">
                                    <button type="button" class="btn btn-primary btn-block approverDecisionButton col-md-4 pull-right" data-decision="${fn:escapeXml(decision)}">
                                        <spring:theme code="${actionButtonLabel}" />
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:when>
        </c:choose>
    </form:form>
</div>