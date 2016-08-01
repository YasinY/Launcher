package com.yasinyazici.launcher.taskmanagement;

import com.yasinyazici.launcher.tasks.Task;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

/**
 * Created by Yasin on 03/06/2016.
 */
public class TaskQueue {

    public static Queue<Task> taskQueue = new LinkedBlockingQueue<>();

    /**
     * Submits multiple tasks to the {@code tasks} ArrayList, allowing {@link TaskExecutor} to run the tasks
     *
     * @param tasks the tasks to submit to the queue
     */
    public static void submitTasksToQueue(Task... tasks) {
        Stream.of(tasks).filter(Objects::nonNull).forEach(task -> {
            System.out.println("Submitted task to queue " + task.getTaskName());
            taskQueue.add(task);
        });
    }

    /**
     * Gets the queue in which all tasks are located in
     *
     * @return taskQueue the task queue being returned.
     */
    public Queue<Task> getTaskQueue() {
        return taskQueue;
    }

}
