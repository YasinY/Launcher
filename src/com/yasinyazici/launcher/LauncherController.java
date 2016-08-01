package com.yasinyazici.launcher;

import com.yasinyazici.launcher.nodes.impl.LoginButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Yasin on 02.06.16.
 */
public class LauncherController {

    @FXML
    private Button loginButton;

    /**
     * It is used within the startup
     */
    public void initialize() {
        addImages();
    }

    @FXML
    public void handleLogin() {
        new LoginButton(loginButton).onClick();
    }




    /**
     * Adds images to each seperate page
     */
    public void addImages() {
        System.out.println("Initialized Images based on pagination");
        //pagination.setPageFactory((index) -> new ImageView("./data/images/icon" + index +".png"));
    }
}
