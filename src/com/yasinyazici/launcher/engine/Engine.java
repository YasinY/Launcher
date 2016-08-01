package com.yasinyazici.launcher.engine;

import com.yasinyazici.launcher.config.Directories;
import com.yasinyazici.launcher.config.Files;
import com.yasinyazici.launcher.taskmanagement.TaskHandler;

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
     * Initializes the engine by creating essential data
     * and submitting essential tasks, initialising the task executor to process these
     */
    public void init() {
        initRawData();
        initTask();
    }

    /**
     * Initializes raw data like essential directories
     */
    private void initRawData() {
        new Directories().initDirectories();
        new Files().initFiles();
    }

    /**
     * Initializes the tasks.
     */
    private void initTask() {
        taskHandler.initialiseTasks();
        taskHandler.getTaskExecutor().init();
    }

    public TaskHandler getTaskHandler() {
        return taskHandler;
    }
}
