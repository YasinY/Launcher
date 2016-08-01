package com.yasinyazici.launcher.config;

import java.io.File;
import java.util.stream.Stream;

/**
 * Created by digital on 06.06.16.
 */
public class Directories {

    public static String USER_PATH = System.getProperty("user.home");
    public final static File LAUNCHER_DIRECTORY = new File(USER_PATH + "/.gamelauncher");
    public final static File IMAGES_PATH = new File(LAUNCHER_DIRECTORY + "/images");
    public final static File COPYRIGHT_PATH = new File(LAUNCHER_DIRECTORY + "/copyright");

    public final static File[] directories = {LAUNCHER_DIRECTORY, IMAGES_PATH, COPYRIGHT_PATH};

    public void initDirectories() {
        Stream.of(directories).filter(directory -> !directory.exists()).forEach(File::mkdir);
        System.out.println("Initialized directories!");
    }
}
