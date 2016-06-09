package com.TW.AndroidTDD;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NodeTest {

    @Test
    public void aNodeIsConnectedToSelf() {
        Node node = new Node("A");
        boolean isConnected = node.isConnected(node);
        assertEquals(true, isConnected);
    }

    @Test
    public void aNodeIsNotConnectedByDefault() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");

        boolean isConnected = nodeA.isConnected(nodeB);
        assertEquals(false, isConnected);
    }

    @Test
    public void aNodeShouldBeAbleToConnectToAnother() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");

        nodeA.connectTo(nodeB);

        boolean isConnected = nodeA.isConnected(nodeB);
        assertEquals(true, isConnected);
    }

    @Test
    public void aNodeShouldBeAbleToConnectToMoreThanOneNode() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");

        nodeA.connectTo(nodeB);
        nodeA.connectTo(nodeC);

        boolean isAConnectedToB = nodeA.isConnected(nodeB);
        boolean isAConnectedToC = nodeA.isConnected(nodeC);

        assertEquals(true, isAConnectedToC);
        assertEquals(true, isAConnectedToB);
    }

    @Test
    public void aChildsChildNodeIsAlsoItsChildNode() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");

        nodeA.connectTo(nodeB);
        nodeB.connectTo(nodeC);
        nodeA.connectTo(nodeD);

        boolean isAConnectedToC = nodeA.isConnected(nodeC);
        boolean isDConnectedToC = nodeD.isConnected(nodeC);

        assertEquals(isAConnectedToC,true);
        assertEquals(isDConnectedToC,false);
    }

    @Test
    public void aMultiLevelNodeGraph() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.connectTo(nodeB);
        nodeB.connectTo(nodeD);
        nodeD.connectTo(nodeF);

        nodeA.connectTo(nodeC);
        nodeC.connectTo(nodeE);

        boolean isAConnectedToD = nodeA.isConnected(nodeD);
        boolean isAConnectedToF = nodeA.isConnected(nodeF);

        boolean isAConnectedToE = nodeA.isConnected(nodeE);

        boolean isEConnectedToF = nodeE.isConnected(nodeF);

        assertEquals(isAConnectedToD,true);
        assertEquals(isAConnectedToF,true);
        assertEquals(isAConnectedToE,true);
        assertEquals(isEConnectedToF,false);
    }
}