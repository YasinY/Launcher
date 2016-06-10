package com.yasinyazici.launcher.config;


import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * Created by digital on 06.06.16.
 */
public class Files {

    public static File[] REGISTERED_FILES = {new File("version.txt")};

    /**
     * Poor
     */
    public void initFiles() {
            Stream.of(REGISTERED_FILES).filter(registeredFile -> !registeredFile.exists()).forEach(registeredFile -> {
                try {
                    registeredFile.createNewFile();
                } catch (IOException e) {
                    //TODO fix printstacktraces
                    e.printStackTrace();
                }
            });

    }
}
