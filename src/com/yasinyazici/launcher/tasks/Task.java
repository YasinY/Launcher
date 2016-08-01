package com.yasinyazici.launcher.tasks;


import com.yasinyazici.launcher.taskmanagement.TaskExecutor;

import java.util.concurrent.Future;

/**
 * Created by Yasin on 03/06/2016.
 * //TODO check javadoc due to the design pattern because of the modifiers
 */
public abstract class Task extends TaskExecutor implements Runnable {


    private String taskName; //The name to identify the task with

    private boolean destroyable;
    private boolean destroyed;

    public abstract Future<?> future(); //The task to execute


    /**
     * Creates a new {@link Task} instance
     *
     * @param taskName The taskname to assign the task for
     */
    public Task(String taskName) {
        this.taskName = taskName;
    }

    /**
     * Destroys a task if boolean {@code destroyable} equals true, throws exception otherwise.
     */
    public void onDestroy() {

    }

    /**
     * Initializement method
     * Used to initialise steps before the actual task is being executed
     */
    public void initializeTask() {

    }
    /**
     * The literal task code
     * Either we keep it abstract and force the run to appear or we just leave it with no abstract modifier
     * and leave the call of this method with an Override
     */
    @Override
    public void run() {
        future();
    }



    /**
     * Gets the name of the task used as identification for management
     *
     * @return taskName the task name
     */
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isDestroyable() {
        return destroyable;
    }

    public void setDestroyable(boolean destroyable) {
        this.destroyable = destroyable;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
}
