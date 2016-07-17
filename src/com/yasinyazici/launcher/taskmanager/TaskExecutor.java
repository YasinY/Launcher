package com.yasinyazici.launcher.taskmanager;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yasin on 03/06/2016.
 * Yet only scheduled executors will be supported unless others are needed.
 */
public class TaskExecutor {

    private ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(8);

    /**
     * Initializes the whole task executor. See {@code execute} as reference
     */
     public void init() {
        execute();
    }

    /**
     * Checks the arraylist located at in the {@link TaskQueue} class for possible tasks to start executing
     * Returns a lazy list, finding the first element of a task (if any and if applicable), starting
     * the task
     */
    private void execute() {
        scheduledExecutor.scheduleAtFixedRate(() -> {
            Task task = TaskQueue.taskQueue.poll();
            if(task != null) {
                task.initializeTask();
                task.run();
                ActiveTasksHandler.submitTask(task);
                System.out.println(task.getTaskName() + " executed and has been added to active tasks!");
            }
        }, 0, 100, TimeUnit.MILLISECONDS);
    }


    public ScheduledExecutorService getScheduledExecutor() {
        return scheduledExecutor;
    }
}
