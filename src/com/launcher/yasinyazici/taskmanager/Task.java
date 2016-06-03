package com.launcher.yasinyazici.taskmanager;


/**
 * Created by Yasin on 03/06/2016.
 */
public abstract class Task implements Runnable {

    private String taskName;

    /**
     * Creates a new {@link Task} instance
     *
     * @param taskName The taskname to assign the task for
     */
    public Task(String taskName) {
        this.taskName = taskName;
    }

    /**
     * The literal task code
     */
    @Override
    public void run() {

    }


    /**
     * Gets the name of the task used as identification for management
     *
     * @return taskName the task name
     */
    public String getTaskName() {
        return taskName;
    }

}
