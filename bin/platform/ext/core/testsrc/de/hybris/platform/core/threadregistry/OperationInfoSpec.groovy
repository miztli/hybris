/*
 * [y] hybris Platform
 *
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.core.threadregistry

import de.hybris.bootstrap.annotations.UnitTest
import org.junit.Test
import spock.lang.Specification
import spock.lang.Unroll

@UnitTest
class OperationInfoSpec extends Specification {

    @Test
    @Unroll
    def "check relation between suspendable and can handle db failures"(final boolean canBeSuspended,
                                                                        final boolean canHandleDbFailures, final OperationInfo operationInfo) {
        expect:
        operationInfo.canBeSuspended() == canBeSuspended
        operationInfo.canHandleDbFailures() == canHandleDbFailures

        where:
        canBeSuspended | canHandleDbFailures | operationInfo
        true           | false               | OperationInfo.builder().asSuspendableOperation().build()
        true           | true                | OperationInfo.builder().asSuspendableOperation(true).build()
        true           | false               | OperationInfo.builder().asSuspendableOperation(false).build()
        false          | false               | OperationInfo.builder().asNotSuspendableOperation().build()
        true           | false               | OperationInfo.builder().asNotSuspendableOperation().asSuspendableOperation().build()
        true           | true                | OperationInfo.builder().asNotSuspendableOperation().asSuspendableOperation(true).build()
        true           | true                | OperationInfo.builder().asSuspendableOperation().asSuspendableOperation(true).build()
        true           | false               | OperationInfo.builder().asSuspendableOperation(true).asSuspendableOperation().build()
        false          | false               | OperationInfo.builder().asSuspendableOperation(true).asNotSuspendableOperation().build()

    }
}
