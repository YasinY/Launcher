package com.yasinyazici.launcher.taskmanager;

import com.yasinyazici.launcher.taskmanager.impl.EngineUpdateTask;
import com.yasinyazici.launcher.taskmanager.impl.TerminationTask;


/**
 * Created by Yasin on 03/06/2016.
 *
 * //TODO FIND A WAY OUT TO ADD AN ELEMENT TO A GENERIC LIST / SET
 */
public class TaskHandler {

    private TaskExecutor taskExecutor;

    /**
     * Creates a new {@link TaskHandler} instance
     */
    public TaskHandler() {
        this.taskExecutor = new TaskExecutor();
    }

    public void submitTasks() {
        taskExecutor.getTaskQueue().submitTask(new TerminationTask(("task_terminator")));
        taskExecutor.getTaskQueue().submitTask(new EngineUpdateTask("engine_update"));
    }

    public TaskExecutor getTaskExecutor() {
        return taskExecutor;
    }
}
