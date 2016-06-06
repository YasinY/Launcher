package com.yasinyazici.launcher.taskmanager.impl;

import com.yasinyazici.launcher.taskmanager.Task;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yasin on 03/06/2016.
 */
public class EngineUpdateTask extends Task {


    /**
     * Creates a new {@link EngineUpdateTask} instance
     * @param taskName The task name to give the task to
     */
    public EngineUpdateTask(String taskName) {
        super(taskName);
    }

    @Override
    public Future<?> scheduledFuture() {
        return getScheduledExecutor().scheduleAtFixedRate(() -> {

        }, 0, 1, TimeUnit.MINUTES);
    }


}
