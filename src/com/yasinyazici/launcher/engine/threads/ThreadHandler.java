package com.yasinyazici.launcher.engine.threads;

import com.yasinyazici.launcher.engine.threads.impl.EngineUpdateThread;

/**
 * Created by Yasin on 10/06/2016.
 */
public class ThreadHandler {

    private EngineUpdateThread engineUpdateThread = new EngineUpdateThread();

    public void init() {
        engineUpdateThread.start();
    }

    public void getText() {

    }
}
