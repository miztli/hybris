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
import de.hybris.platform.task.TaskModel
import de.hybris.platform.task.TaskRunner
import de.hybris.platform.task.TaskService

class MyScriptRunner implements TaskRunner<TaskModel> {

    @Override
    void run(TaskService taskService, TaskModel task) {
        println 'hello groovy! ' + new Date();
        def modelService = Registry.getApplicationContext().getBean("modelService")
        def title = modelService.create(TitleModel.class)
        title.code = "CorrectGroovyTitle"
        modelService.save(title)
    }

    @Override
    void handleError(TaskService taskService, TaskModel task, Throwable error) {
        println 'my script has errors'
        def modelService = Registry.getApplicationContext().getBean("modelService")
        def title = modelService.create(TitleModel.class)
        title.code = "ErrorGroovyTitle"
        modelService.save(title)
    }

}

new MyScriptRunner();