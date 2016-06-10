package com.yasinyazici.launcher.taskmanager.tasks.engine;

import com.yasinyazici.launcher.taskmanager.ActiveTasksHandler;
import com.yasinyazici.launcher.taskmanager.Task;

import java.util.Set;
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
    public Future<?> future() {
        return getScheduledExecutor().scheduleAtFixedRate(() -> {
            getTaskQueue().getActiveTasksHandler().getActiveTasks().stream().filter(task -> task.destroyable()).forEach(task -> {
                task.onDestroy();
                task.getScheduledExecutor().shutdownNow();
                getTaskQueue().getActiveTasksHandler().removeTask(getTaskName());
                System.out.println("Successfully destroyed task!");
            });
        }, 0, 100, TimeUnit.MILLISECONDS);
    }

    @Override
    public boolean destroyable() {
        return false;
    }
}
