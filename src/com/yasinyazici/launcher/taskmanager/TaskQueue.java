package com.yasinyazici.launcher.taskmanager;

import com.google.common.base.Preconditions;

import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

/**
 * Created by Yasin on 03/06/2016.
 */
public class TaskQueue {

    private Queue<Task> taskQueue = new LinkedBlockingQueue<>();


    /**
     * Submits a task to the {@code tasks} ArrayList, allowing {@link TaskExecutor} to run the task
     *
     * @param task The task to submit to the queue
     */
    public void submitTask(Task task) {
        System.out.println("Added task " + task.getTaskName());
       // Preconditions.checkState(task.getTaskName().equalsIgnoreCase(""), "Please set a name for the task upon constructing.");
        taskQueue.add(task);
    }

    /**
     * Submits multiple tasks to the {@code tasks} ArrayList, allowing {@link TaskExecutor} to run the tasks
     *
     * @param tasks the tasks to submit to the queue
     */
    public void submitTask(Task... tasks) {
        Stream.of(tasks).filter(Objects::nonNull).forEach(task -> taskQueue.add(task));
    }

    /**
     * Removes a task through the given parameter from the queue.
     *
     * @param taskName The task to delete, identified through the task name
     */
    public void removeTask(String taskName) {
        Iterator<Task> taskIterator = taskQueue.stream().filter(p -> p.getTaskName().equalsIgnoreCase(taskName)).iterator();
        while (taskIterator.hasNext()) {
            taskIterator.remove();
        }
    }

    /**
     * Gets
     *
     * @return
     */
    public Queue<Task> getTaskQueue() {
        return taskQueue;
    }
}
