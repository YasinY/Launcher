package com.yasinyazici.launcher.taskmanager;

import com.yasinyazici.launcher.taskmanager.tasks.engine.EngineUpdateTask;
import com.yasinyazici.launcher.taskmanager.tasks.engine.TerminationTask;
import javafx.scene.Node;


/**
 * Created by Yasin on 03/06/2016.
 *
 * //TODO FIND A WAY OUT TO ADD AN ELEMENT TO A GENERIC LIST / SET
 */
public class TaskHandler {

    private TaskExecutor taskExecutor;

    /**
     * Creates a new {@link TaskHandler} instance
     */
    public TaskHandler() {
        this.taskExecutor = new TaskExecutor();
    }

    public void initialiseTasks() {
        submitRegularTasks();
        submitNodeTasks();
    }
    private void submitRegularTasks() {
        taskExecutor.getTaskQueue().submitTask(new TerminationTask(("task_terminator")));
        taskExecutor.getTaskQueue().submitTask(new EngineUpdateTask("engine_update"));
    }

    private void submitNodeTasks() {
        taskExecutor.getTaskQueue().submitTask();
    }

    public TaskExecutor getTaskExecutor() {
        return taskExecutor;
    }
}
