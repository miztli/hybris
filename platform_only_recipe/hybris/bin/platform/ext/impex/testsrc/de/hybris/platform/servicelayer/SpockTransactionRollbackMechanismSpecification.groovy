/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.servicelayer

import de.hybris.bootstrap.annotations.IntegrationTest
import de.hybris.platform.directpersistence.DirectPersistenceUtils
import de.hybris.platform.jalo.user.Title
import de.hybris.platform.persistence.property.JDBCValueMappings
import org.junit.Test
import org.springframework.jdbc.core.JdbcTemplate

import javax.annotation.Resource
import java.text.MessageFormat
import java.time.Instant

import static de.hybris.platform.persistence.property.JDBCValueMappings.getJDBCValueWriter

@IntegrationTest
class SpockTransactionRollbackMechanismSpecification extends ServicelayerTransactionalSpockSpecification {

    @Resource
    JdbcTemplate jdbcTemplate

    @Test
    def "check transaction is rolled back by inserting the same object two times -first"()
    {
        when:
        insertTitle()

        then:
        noExceptionThrown()
    }

    @Test
    def "check transaction is rolled back by inserting the same object two times -second"()
    {
        when:
        insertTitle()

        then:
        noExceptionThrown()
    }

    private void insertTitle()
    {
        JDBCValueMappings.ValueWriter<Date, ?> dateWriter = getJDBCValueWriter(Date.class)
        def titleTableName = DirectPersistenceUtils.getInfoMapForType(Title.getSimpleName()).getItemTableName()
        def sql = MessageFormat.format("INSERT INTO {0} (PK,p_code, createdTS) VALUES (?,?,?)", titleTableName)
        jdbcTemplate.update(sql, { preparedStatement ->
            preparedStatement.setInt(1, 1357908642)
            preparedStatement.setString(2, "test1357908642")
            dateWriter.setValue(preparedStatement, 3, Date.from(Instant.now()));
        })
    }
}
