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
package test

import de.hybris.platform.core.Registry
import de.hybris.platform.core.model.user.TitleModel
import de.hybris.platform.scripting.events.TestScriptingEvent
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener

class MyScriptingEventListener extends AbstractEventListener<TestScriptingEvent> {

    @Override
    void onEvent(TestScriptingEvent event) {
        println 'processing event: ' + event
        def modelService = Registry.getApplicationContext().getBean("modelService")
        def title = modelService.create(TitleModel.class)
        title.code = ((TestScriptingEvent) event).getEventName()
        modelService.save(title)
        println 'hello groovy! ' + new Date();
    }
}

new MyScriptingEventListener();