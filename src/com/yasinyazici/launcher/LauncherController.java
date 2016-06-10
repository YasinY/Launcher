package com.yasinyazici.launcher;

import com.yasinyazici.launcher.engine.Engine;
import com.yasinyazici.launcher.nodes.LauncherNode;
import com.yasinyazici.launcher.nodes.impl.LoginButton;
import com.yasinyazici.launcher.nodes.impl.RegisterButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;

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
    }

    @FXML
    public void handleLogin() {
        LauncherNode launcherNode = new LoginButton(loginButton);
        launcherNode.onClick();
        System.out.println("Triggered login");
    }

    @FXML
    public void handleRegister() {
        LauncherNode launcherNode = new RegisterButton(registrationButton);
        launcherNode.onClick();
        System.out.println("Triggered register");
    }



    /**
     * Adds images to each seperate page
     */
    public void addImages() {
        System.out.println("Initialized Images based on pagination");
        //pagination.setPageFactory((index) -> new ImageView("./data/images/icon" + index +".png"));
    }
}
