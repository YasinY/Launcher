package com.yasinyazici.launcher.engine;

import com.yasinyazici.launcher.taskmanager.TaskHandler;

/**
 * Created by Yasin on 03/06/2016.
 */
public class Engine {

    private TaskHandler taskHandler;

    private EngineUpdateThread engineUpdateThread;

    /**
     * Creates a new {@link Engine} instance
     */
    public Engine() {
        this.taskHandler = new TaskHandler();
        this.engineUpdateThread = new EngineUpdateThread();
    }

    public void init() {
        taskHandler.submitTasks();
        initializeThreads();
    }

    private void initializeThreads() {
        new EngineUpdateThread();
    }

    public TaskHandler getTaskHandler() {
        return taskHandler;
    }

    public EngineUpdateThread getEngineUpdateThread() {
        return engineUpdateThread;
    }
}
