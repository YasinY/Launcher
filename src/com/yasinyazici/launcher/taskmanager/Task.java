package com.yasinyazici.launcher.taskmanager;


import java.util.concurrent.Future;

/**
 * Created by Yasin on 03/06/2016.
 * //TODO check javadoc due to the design pattern because of the modifiers
 */
public abstract class Task extends TaskExecutor implements Runnable {


    private String taskName;

    public abstract Future<?> scheduledFuture();

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
     * Either we keep it abstract and force the run to appear or we just leave it with no abstract modifier
     * and leave the call of this method with an Override
     */
    @Override
    public void run() {
        scheduledFuture();
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
