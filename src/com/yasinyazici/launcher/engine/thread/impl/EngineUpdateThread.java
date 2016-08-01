package com.yasinyazici.launcher.engine.thread.impl;

import com.yasinyazici.launcher.engine.Engine;
import com.yasinyazici.launcher.engine.thread.LauncherThread;


/**
 * Created by Yasin on 03/06/2016.
 */
public class EngineUpdateThread extends LauncherThread {

    private Engine engine = new Engine();

    @Override
    public void run() {
        System.out.println("Engine Update thread initialized!");
        engine.init();
    }

}
