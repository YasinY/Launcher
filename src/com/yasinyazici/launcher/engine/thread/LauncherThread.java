package com.yasinyazici.launcher.engine.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by Yasin on 10/06/2016.
 */
public abstract class LauncherThread extends Thread  {

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

    private boolean hasStopped;

    @Override
    public abstract void run();

    public ScheduledExecutorService getScheduledExecutorService() {
        return scheduledExecutorService;
    }

}
