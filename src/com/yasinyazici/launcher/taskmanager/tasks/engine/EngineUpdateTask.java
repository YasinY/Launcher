package com.yasinyazici.launcher.taskmanager.tasks.engine;

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
    public void initializeTask() {
        setDestroyable(true);
        setTaskName("engine_update_task_init");
    }
    @Override
    public Future<?> future() {
        return getScheduledExecutor().scheduleAtFixedRate(() -> {

                System.out.println("update");
        }, 0, 1, TimeUnit.SECONDS);
    }

    @Override
    public void onDestroy() {
        System.out.println("Clearing by task defined things..");
    }




}
