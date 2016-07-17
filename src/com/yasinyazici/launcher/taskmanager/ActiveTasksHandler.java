package com.yasinyazici.launcher.taskmanager;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by digital on 06.06.16.
 */
public class ActiveTasksHandler {

    public static Set<Task> activeTasks = new HashSet<>();

    /**
     * Submits multiple tasks to the {@code tasks} ArrayList, allowing {@link TaskExecutor} to run the tasks
     *
     * @param tasks the tasks to submit to the queue
     */
    public static void submitTask(Task... tasks) {
        Stream.of(tasks).forEach(task -> activeTasks.add(task));
    }

    /**
     * Removes a task through the given parameter from the queue.
     *
     * @param taskName The task to delete, identified through the task name
     */
    public static void removeActiveTask(String taskName) {
        Iterator<Task> taskIterator = activeTasks.iterator();
        while (taskIterator.hasNext()) {
                if(taskIterator.next().getTaskName().equalsIgnoreCase(taskName)) {
                    taskIterator.remove();
                    System.out.println("Removed " + taskName);
                }
        }
    }
}
