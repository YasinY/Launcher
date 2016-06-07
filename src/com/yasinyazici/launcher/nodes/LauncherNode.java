package com.yasinyazici.launcher.nodes;

import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by digital on 02.06.16.
 */
public abstract class LauncherNode {




    private Node node;

    public LauncherNode(Node node) {
        this.node = node;
    }

    public abstract void onClick();


    public Node getNode() {
        return node;
    }
}
