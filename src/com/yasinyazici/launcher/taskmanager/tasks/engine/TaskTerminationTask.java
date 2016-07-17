package com.yasinyazici.launcher.taskmanager.tasks.engine;

import com.yasinyazici.launcher.taskmanager.ActiveTasksHandler;
import com.yasinyazici.launcher.taskmanager.Task;
import com.yasinyazici.launcher.taskmanager.TaskHandler;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yasin on 17/07/2016.
 */
public class TaskTerminationTask extends Task {
    /**
     * Creates a new {@link Task} instance
     *
     * @param taskName The taskname to assign the task for
     */
    public TaskTerminationTask(String taskName) {
        super(taskName);
    }

    @Override
    public void initializeTask() {
        this.setDestroyable(false);
        this.setTaskName("task_terminator_init");
    }

    @Override
    public Future<?> future() {
        return this.getScheduledExecutor().scheduleAtFixedRate(() -> ActiveTasksHandler.activeTasks.stream().filter(Task::isDestroyable).forEach(task -> {
            if (task.isDestroyable()) {
                task.onDestroy();
                task.getScheduledExecutor().shutdown();
                ActiveTasksHandler.removeActiveTask(task.getTaskName());
            }
        }), 0, 1, TimeUnit.SECONDS);
    }
}
