package com.yasinyazici.launcher.taskmanager;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by digital on 06.06.16.
 */
public class ActiveTasksHandler {

    private Set<Task> activeTasks = new HashSet<>(); //So it's accessible for every class,


    /**
     * Submits multiple tasks to the {@code tasks} ArrayList, allowing {@link TaskExecutor} to run the tasks
     *
     * @param tasks the tasks to submit to the queue
     */
    public void submitTask(Task... tasks) {
        Stream.of(tasks).filter(Objects::nonNull).forEach(task -> {
            activeTasks.add(task);
            System.out.println("Submitted active task " + task.getTaskName());
        });
    }

    /**
     * Removes a task through the given parameter from the queue.
     *
     * @param taskName The task to delete, identified through the task name
     */
    public void removeTask(String taskName) {
        Iterator<Task> taskIterator = activeTasks.iterator();
        while (taskIterator.hasNext()) {
                if(taskIterator.next().getTaskName().equalsIgnoreCase(taskName)) {
                    taskIterator.remove();
                    System.out.println("Removed " + taskName);
                }
        }
    }



    public Set<Task> getActiveTasks() {
        return activeTasks;
    }
}
