package com.yasinyazici.launcher.taskmanager;

import com.yasinyazici.launcher.taskmanager.tasks.engine.EngineUpdateTask;
import com.yasinyazici.launcher.taskmanager.tasks.engine.TaskTerminationTask;

/**
 * Created by Yasin on 03/06/2016.
 *
 */
public class TaskHandler {

    private TaskExecutor taskExecutor = new TaskExecutor();

    public void initialiseTasks() {
        submitRegularTasks();
    }

    private void submitRegularTasks() {
        TaskQueue.submitTasksToQueue(new EngineUpdateTask("engine_update"), new TaskTerminationTask("task_termination_task"));
    }

    public TaskExecutor getTaskExecutor() {
        return taskExecutor;
    }
}
