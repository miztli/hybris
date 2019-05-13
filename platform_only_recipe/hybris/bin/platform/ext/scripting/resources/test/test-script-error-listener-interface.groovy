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
import de.hybris.platform.core.Registry
import de.hybris.platform.core.model.user.TitleModel
import de.hybris.platform.scripting.events.TestScriptingEvent
import de.hybris.platform.servicelayer.event.events.AbstractEvent
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener

class MyScriptingEventListener extends AbstractEventListener<AbstractEvent> {

    @Override
    void onEvent(AbstractEvent event) {
        if (event instanceof TestScriptingEvent) {
            println 'hello groovy! ' + new Date();
            def modelService = Registry.getApplicationContext().getBean("modelService")
            def title = modelService.create(TitleModel.class)
            title.code = ((TestScriptingEvent) event).getEventName()
            title.pk.longValue //this should throw NullPointerException, which is expected here!
            modelService.save(title)

        } else {
            println 'another event published '
            println event
        }
    }
}

new MyScriptingEventListener();