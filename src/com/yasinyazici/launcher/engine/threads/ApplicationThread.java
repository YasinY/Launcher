package com.yasinyazici.launcher.engine.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by Yasin on 10/06/2016.
 */
public abstract class ApplicationThread extends Thread  {

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

    private boolean hasStopped;

    @Override
    public abstract void run();

    public ScheduledExecutorService getScheduledExecutorService() {
        return scheduledExecutorService;
    }

    public boolean isHasStopped() {
        return hasStopped;
    }

    public void setHasStopped(boolean hasStopped) {
        this.hasStopped = hasStopped;
    }
}
