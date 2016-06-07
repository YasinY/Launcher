package com.yasinyazici.launcher.engine;

import com.yasinyazici.launcher.taskmanager.TaskHandler;

/**
 * Created by Yasin on 03/06/2016.
 */
public class Engine {

    private TaskHandler taskHandler;

    /**
     * Creates a new {@link Engine} instance
     */
    public Engine() {
        this.taskHandler = new TaskHandler();
    }

    /**
     * Initializes the engine by submitting essential tasks, initialising the task executor to process these and at last
     * initializing the threads for the application
     */
    public void init() {
        taskHandler.initialiseTasks();
        taskHandler.getTaskExecutor().init();
        initializeThreads();
    }

    /**
     * The threads to initialize upon start up, see {@link com.yasinyazici.launcher.engine} as reference
     */
    private void initializeThreads() {
        new EngineUpdateThread().start();
    }

    public TaskHandler getTaskHandler() {
        return taskHandler;
    }
}
