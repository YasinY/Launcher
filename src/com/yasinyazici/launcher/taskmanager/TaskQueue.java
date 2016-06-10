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

    private ActiveTasksHandler activeTasksHandler = new ActiveTasksHandler();

    /**
     * Submits multiple tasks to the {@code tasks} ArrayList, allowing {@link TaskExecutor} to run the tasks
     *
     * @param tasks the tasks to submit to the queue
     */
    public void submitTasks(Task... tasks) {

        Preconditions.checkNotNull(tasks);
        Stream.of(tasks).filter(Objects::nonNull).forEach(task -> {
            System.out.println("Submitted task to queue " + task.getTaskName());
            taskQueue.add(task);
        });
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
     * Gets the queue in which all tasks are located in
     *
     * @return taskQueue the task queue being returned.
     */
    public Queue<Task> getTaskQueue() {
        return taskQueue;
    }

    public ActiveTasksHandler getActiveTasksHandler() {
        return activeTasksHandler;
    }
}
