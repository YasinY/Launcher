package com.launcher.yasinyazici.taskmanager;

import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yasin on 03/06/2016.
 */
public class TaskExecutor {

    private TaskQueue taskQueue = new TaskQueue();

    private ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);

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
            if (tasks.size() == 0)
                return;
            Optional<Task> task = taskQueue.getTaskQueue().stream().findFirst();
            if (task.isPresent()) {
                task.get().run();
            } else {
                System.out.println("DEBUG: Task is not present!");
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    public TaskQueue getTaskQueue() {
        return taskQueue;
    }

}
