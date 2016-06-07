package com.yasinyazici.launcher.config;

import java.io.File;

/**
 * Created by digital on 06.06.16.
 */
public class Directories {

    public static String USER_PATH = System.getProperty("user.home");
    public final static String LAUNCHER_PATH = USER_PATH + "/.gamelauncher/";
    public final static String IMAGES_PATH = LAUNCHER_PATH + "/images/";
    public final static String COPYRIGHT_PATH = LAUNCHER_PATH + "/copyright/";
    public final static String[] REGISTERED_DIRECTORIES = {"images", "copyright"};
}
