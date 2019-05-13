<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="b2b-order" tagdir="/WEB-INF/tags/addons/b2bacceleratoraddon/responsive/order"%>

<spring:url value="${url}" var="orderApprovalDecisionURL" htmlEscape="false" />

<b2b-order:orderApprovalDecisionPopup orderApprovalDecisionForm="${orderApprovalDecisionForm}" orderApprovalData="${orderApprovalData}" 
    orderApprovalDecisionURL="${orderApprovalDecisionURL}" 
    decision="APPROVE"
    actionButtonLabel="text.account.orderApproval.approveButton.displayName"
    actionButtonClass="btn btn-primary btn-block approverDecisionApprovalButton"
    modalPopupClass="orderApprovalApproveCommentModal"
    commentLabel="text.account.orderApproval.approve.reason" />
