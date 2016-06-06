package com.yasinyazici.launcher.taskmanager.impl;

import com.yasinyazici.launcher.taskmanager.Task;

import java.util.concurrent.Future;

/**
 * Created by Yasin on 03/06/2016.
 */
public class NetworkUpdateTask extends Task {


    /**
     * Creates a new {@link NetworkUpdateTask} instance
     * @param taskName The task name to give the task to
     */
    public NetworkUpdateTask(String taskName) {
        super(taskName);
    }

    @Override
    public Future<?> scheduledFuture() {
        return null;
    }

}
