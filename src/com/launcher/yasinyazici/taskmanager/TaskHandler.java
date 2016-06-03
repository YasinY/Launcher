package com.launcher.yasinyazici.taskmanager;

import com.launcher.yasinyazici.taskmanager.impl.EngineUpdateTask;

/**
 * Created by Yasin on 03/06/2016.
 */
public class TaskHandler {

    private TaskExecutor taskExecutor;


    public TaskHandler() {
        this.taskExecutor = new TaskExecutor();
    }

    public void submitTasks() {
        taskExecutor.getTaskQueue().submitTask(new EngineUpdateTask("engine_update"));
    }

    public TaskExecutor getTaskExecutor() {
        return taskExecutor;
    }
}
