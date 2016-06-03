package com.yasinyazici.launcher.taskmanager;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yasin on 03/06/2016.
 */
public class TaskExecutor {

    private TaskQueue taskQueue = new TaskQueue();

    private ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(8);

    private ExecutorService executorService = Executors.newFixedThreadPool(8);

    /**
     * Creates a new {@link TaskExecutor} instance
     */
    public TaskExecutor() {

    }

    /**
     * Initializes the whole task executor. See {@code execute} as reference
     */
     public void init() {
        execute();
    }

    /**
     * Checks the arraylist located at in the {@code TaskQueue} class for possible tasks to start executing
     * Returns a lazy list, finding the first element of a task (if any and if applicable), starting
     * the task
     */
    private void execute() {
        Queue<Task> tasks = taskQueue.getTaskQueue();
        scheduledExecutor.scheduleAtFixedRate(() -> {
            if (tasks.size() == 0) {
                System.out.println("Queue is empty!");
                return;
            }
            Task task = taskQueue.getTaskQueue().peek();

            System.out.println("Task has been found!" + task.getTaskName());
            task.run();
        }, 0, 100, TimeUnit.MILLISECONDS);
    }

    public TaskQueue getTaskQueue() {
        return taskQueue;
    }

    public ScheduledExecutorService getScheduledExecutor() {
        return scheduledExecutor;
    }
    public ExecutorService getExecutor() {
        return executorService;
    }
}
