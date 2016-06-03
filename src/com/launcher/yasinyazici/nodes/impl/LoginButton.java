package com.launcher.yasinyazici.nodes.impl;

import com.launcher.yasinyazici.nodes.LauncherNode;
import com.launcher.yasinyazici.nodes.NodeStage;
import javafx.scene.Node;

/**
 * Created by digital on 02.06.16.
 */
public class LoginButton extends LauncherNode {


    public LoginButton(Node node) {
        super(node);
    }

    @Override
    public NodeStage nodeStage() {
        return NodeStage.NOT_STARTED;
    }

    @Override
    public void onClick() {
        System.out.println("Onlick => Login!");
    }
}
