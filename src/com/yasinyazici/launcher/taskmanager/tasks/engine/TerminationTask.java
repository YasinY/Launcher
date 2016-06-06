package com.yasinyazici.launcher.taskmanager.tasks.engine;

import com.yasinyazici.launcher.taskmanager.ActiveTasks;
import com.yasinyazici.launcher.taskmanager.Task;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by digital on 06.06.16.
 * This class will never destroy itself, so why not make it a task to kill tasks other than itself!
 */
public class TerminationTask extends Task {

    /**
     * Creates a new {@link Task} instance
     *
     * @param taskName The taskname to assign the task for
     */
    public TerminationTask(String taskName) {
        super(taskName);
    }

    @Override
    public Future<?> scheduledFuture() {
        return getScheduledExecutor().scheduleAtFixedRate(() -> {
            ActiveTasks.activeTasks.stream().filter(task -> task.destroyable()).forEach(task -> {
                System.out.println("Destroyed task " + task.getTaskName());
                ActiveTasks.activeTasks.remove(task);
                task.getScheduledExecutor().shutdownNow();
            });
        }, 0, 100, TimeUnit.MILLISECONDS);
    }

    @Override
    public boolean destroyable() {
        return false;
    }
}
