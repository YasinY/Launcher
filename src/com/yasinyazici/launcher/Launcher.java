package com.yasinyazici.launcher;

import com.yasinyazici.launcher.engine.threads.impl.EngineUpdateThread;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by digital on 02.06.16.
 */
public class Launcher extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("launcher.fxml"));
        primaryStage.setScene(new Scene(parent));
        primaryStage.centerOnScreen();
        primaryStage.show();
        initializeThreads();
    }

    /**
     * The threads to initialize upon start up, see {@link com.yasinyazici.launcher.engine} as reference
     */
    private void initializeThreads() {
        new EngineUpdateThread().start();
    }




}
