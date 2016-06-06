package com.yasinyazici.launcher.taskmanager;

import org.omg.PortableInterceptor.ACTIVE;

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

    private ActiveTasks activeTasks = new ActiveTasks();

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
        scheduledExecutor.scheduleAtFixedRate(() -> {
            Queue<Task> tasks = taskQueue.getTaskQueue();
            if (tasks.size() == 0) {
                System.out.println("Queue is empty");
                return;
            }
            Task task = taskQueue.getTaskQueue().peek();
            System.out.println("Running task " + task.getTaskName() + " now");
            task.run();
            taskQueue.removeTask(task.getTaskName());
            activeTasks.submitTask(task);
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
