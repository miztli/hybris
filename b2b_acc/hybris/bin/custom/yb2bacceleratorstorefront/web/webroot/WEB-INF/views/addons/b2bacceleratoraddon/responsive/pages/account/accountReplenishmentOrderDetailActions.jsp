<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<spring:htmlEscape defaultHtmlEscape="true"/>

<div class="accountActions-link">
    <div class="row">
        <c:if test="${orderData.active}">
            <div class="col-sm-12 disable-link">
                <ycommerce:testId code="replenishment_orderDetails_backToOrderHistory_button">
                    <a class="js-replenishment-cancel-button" href="#"
                       data-job-code="<c:out value='${orderData.jobCode}'/>"
                       data-popup-title="<spring:theme code='text.account.replenishment.remove.confirmation.title'/>">
                        <spring:theme code="text.account.replenishment.cancel.button"/>
                    </a>
                </ycommerce:testId>
            </div>

            <div class="hidden">
                <div id="popup_confirm_replenishment_order_cancellation_${fn:escapeXml(orderData.jobCode)}"
                     class="replenishment-order-cancel-modal">
                    <p class="replenishment-order-cancel-modal-content">
                        <spring:theme code="text.account.replenishment.confirm.cancel" arguments="${orderData.jobCode}"/>
                    </p>

                    <div class="modal-actions">
                        <form:form action="detail/cancel/${ycommerce:encodeUrl(orderData.jobCode)}">
                            <div class="row">
                                <div class="col-xs-12 col-sm-6 col-sm-push-6">
                                    <button type="submit" class="btn btn-primary btn-block">
                                        <spring:theme code="text.account.yes.button"/>
                                    </button>
                                </div>
                                <div class="col-xs-12 col-sm-6 col-sm-pull-6">
                                    <button type="button" class="btn btn-default btn-block js-replenishment-order-cancel-modal-cancel-button">
                                        <spring:theme code="text.account.no.button"/>
                                    </button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </c:if>
    </div>
</div>