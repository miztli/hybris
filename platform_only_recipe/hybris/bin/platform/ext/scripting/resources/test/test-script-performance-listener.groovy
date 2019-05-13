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
import de.hybris.platform.scripting.events.TestPerformanceEvent
import de.hybris.platform.servicelayer.event.events.AbstractEvent
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener

class MyScriptingEventListener extends AbstractEventListener<AbstractEvent> {

    @Override
    void onEvent(AbstractEvent event) {
        if (event instanceof TestPerformanceEvent) {
            def modelService = Registry.getApplicationContext().getBean("modelService")
            for (i in 0..event.itemsToSaveCount - 1) {
                def title = modelService.create(TitleModel.class)
                title.code = 'testTitle' + i
                modelService.save(title)
            }
        } else {
            Math.random();
        }
    }
}

new MyScriptingEventListener();