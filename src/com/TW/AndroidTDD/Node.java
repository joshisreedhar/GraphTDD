package com.TW.AndroidTDD;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private List<Node> childNodes;

    public Node(String name) {
        this.name = name;
        childNodes = new ArrayList<>();
    }

    public boolean isConnected(Node node) {
        if (this.equals(node) || childNodes.contains(node)) {
            return true;
        }

        boolean isIndirectChild = false;
        for (Node childNode : childNodes) {
            isIndirectChild = isIndirectChild || childNode.isConnected(node);
        }
        return isIndirectChild;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return ((Node) obj).name == this.name;
    }

    public void connectTo(Node childNode) throws OperationNotSupportedException {
        if(childNode.isConnected(this)){
            throw new OperationNotSupportedException("Will add cyclic reference");
        }
        this.childNodes.add(childNode);
    }
}
