package com.yasinyazici.launcher.nodes.impl;

import com.yasinyazici.launcher.nodes.LauncherNode;
import com.yasinyazici.launcher.nodes.NodeStage;
import javafx.scene.Node;

/**
 * Created by digital on 02.06.16.
 */
public class RegistrationButton extends LauncherNode {


    public RegistrationButton(Node node) {
        super(node);
    }

    @Override
    public NodeStage nodeStage() {
        return NodeStage.NOT_STARTED;
    }

    @Override
    public void onClick() {
        System.out.println("Onclick => registration");
    }
}
