package com.yasinyazici.launcher;

import com.yasinyazici.launcher.engine.Engine;
import com.yasinyazici.launcher.nodes.LauncherNode;
import com.yasinyazici.launcher.nodes.impl.HandleButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.image.ImageView;

/**
 * Created by digital on 02.06.16.
 */
public class LauncherController {
    @FXML
    private Pagination pagination;

    @FXML
    private Button loginButton;

    @FXML
    private Button registrationButton;

    /**
     * It is used within the startup
     */
    public void initialize() {
        addImages();
        Engine engine = new Engine();
        engine.init();
    }

    @FXML
    public void handleButton() {
        LauncherNode launcherNode = new HandleButton(loginButton);
        launcherNode.onClick();
        System.out.println("Triggered Click");
    }

    /**
     * Adds images to each seperate page
     */
    public void addImages() {
        System.out.println("Initialized Images based on pagination");
        //pagination.setPageFactory((index) -> new ImageView("./data/images/icon" + index +".png"));
    }
}
