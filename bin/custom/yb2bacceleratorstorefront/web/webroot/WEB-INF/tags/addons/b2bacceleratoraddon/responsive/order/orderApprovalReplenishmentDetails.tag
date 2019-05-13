<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="triggerData" required="true" type="de.hybris.platform.b2bacceleratorfacades.order.data.TriggerData" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="account-orderdetail well well-tertiary">
    <div class="well-headline">
        <spring:theme code="text.account.replenishment.details" />
    </div>
    <div class="well-content">
        <div class="row">
            <div class="col-sm-12 col-md-9">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="label-order">
                            <spring:theme code="text.account.replenishment.frequency" />
                        </div>
                        <div class="value-order">
                            <c:out value="${triggerData.displayTimeTable}" />
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="label-order">
                            <spring:theme code="text.account.replenishment.startDate" />
                        </div>
                        <div class="value-order">
                            <fmt:formatDate value="${triggerData.activationTime}" dateStyle="medium" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>