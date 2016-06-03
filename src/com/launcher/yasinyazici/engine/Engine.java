package com.launcher.yasinyazici.engine;

import com.launcher.yasinyazici.taskmanager.TaskHandler;

/**
 * Created by Yasin on 03/06/2016.
 */
public class Engine {

    private TaskHandler taskHandler;

    public Engine() {
        this.taskHandler = new TaskHandler();
    }

    public TaskHandler getTaskHandler() {
        return taskHandler;
    }
}
