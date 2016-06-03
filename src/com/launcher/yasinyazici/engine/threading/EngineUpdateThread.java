package com.launcher.yasinyazici.engine.threading;

import com.launcher.yasinyazici.engine.Engine;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by Yasin on 03/06/2016.
 */
public class EngineUpdateThread extends Thread implements Runnable{

    private Engine engine = new Engine();

    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    @Override
    public void run() {
        engine.getTaskHandler().getTaskExecutor().init();
        //Run the Task system here
        //Visualization would also be here (rendering anims)
    }

}
