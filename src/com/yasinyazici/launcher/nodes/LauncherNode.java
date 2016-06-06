package com.yasinyazici.launcher.nodes;

import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by digital on 02.06.16.
 */
public abstract class LauncherNode {


    public List<Node> registeredNodes = new ArrayList<>();


    private Node node;

    public LauncherNode(Node node) {
        this.node = node;
    }

    public abstract NodeStage nodeStage();

    public abstract void onClick();


    public List<Node> getRegisteredNodes() {
        return registeredNodes;
    }

    public Node getNode() {
        return node;
    }

}
