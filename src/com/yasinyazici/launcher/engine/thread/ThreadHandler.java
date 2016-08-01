package com.yasinyazici.launcher.engine.thread;

import com.yasinyazici.launcher.engine.thread.impl.EngineUpdateThread;
import com.yasinyazici.launcher.engine.thread.impl.NetworkThread;

/**
 * Created by Yasin on 10/06/2016.
 */
public class ThreadHandler {

    private EngineUpdateThread engineUpdateThread = new EngineUpdateThread();

    private NetworkThread networkThread = new NetworkThread();

    public void init() {
        engineUpdateThread.start();
        networkThread.start();

    }


}
