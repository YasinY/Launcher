package com.yasinyazici.launcher;

import com.yasinyazici.launcher.engine.thread.ThreadHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Yasin on 28.07.2016.
 */
public class Launcher extends Application {

    private ThreadHandler threadHandler = new ThreadHandler();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initLookAndFeel(primaryStage);
        initializeThreads();
        setOnClose(primaryStage);
    }

    private void initLookAndFeel(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("launcher.fxml"));
        primaryStage.setScene(new Scene(parent));
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    private void setOnClose(Stage stage) {
        stage.setOnCloseRequest((x) -> System.exit(0)); //TODO might aswell clear things out here upon finishing
    }

    private void initializeThreads() {
        threadHandler.init();
    }
}
