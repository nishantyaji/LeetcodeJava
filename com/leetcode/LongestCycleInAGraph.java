package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// Leet code problem 2360
public class LongestCycleInAGraph {
    public static void main(String[] args) {
        LongestCycleInAGraph l = new LongestCycleInAGraph();
        System.out.println(l.longestCycle(new int[]{3, 3, 4, 2, 3}));
        System.out.println(l.longestCycle(new int[]{2, -1, 3, 1}));
//        System.out.println(l.longestCycle(new int [] {}));
    }

    public int longestCycle(int[] edges) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] != -1) {
                Node parentNode = getNode(nodeMap, edges[i]);
                Node thisNode = getNode(nodeMap, i);
                parentNode.addChild(thisNode);
            }
        }

        Set<Integer> parents = Arrays.stream(edges).filter(i -> i != -1).boxed().collect(Collectors.toSet());
        Set<Integer> allCovered = new HashSet<>();

        int max = -1;
        for (Integer parent : parents) {
            int thisMax = calculateLength(parent, nodeMap, allCovered);
            max = Math.max(max, thisMax);
        }
        return max;
    }

    private int calculateLength(int val, Map<Integer, Node> nodeMap, Set<Integer> allCovered) {
        if (allCovered.contains(val)) {
            return -1;
        }

        Node node = getNode(nodeMap, val);
        Map<Integer, Integer> thisMap = new HashMap<>();
        List<Integer> paths = new ArrayList<>();

        Deque<NodeAndLength> dq = new LinkedList<>();
        dq.add(new NodeAndLength(node, 0));


        while (!dq.isEmpty()) {
            NodeAndLength present = dq.pop();
            allCovered.add(present.node.ordinal);
            if (thisMap.containsKey(present.node.ordinal)) {
                paths.add(present.length - thisMap.get(present.node.ordinal));
            } else {
                thisMap.put(present.node.ordinal, present.length);
                present.node.getChildren().forEach(n -> dq.add(new NodeAndLength(n, present.length + 1)));
            }
        }

        if (paths.isEmpty()) {
            return -1;
        }
        return paths.stream().max(Integer::compare).get();
    }

    private Node getNode(Map<Integer, Node> nodeMap, int val) {
        if (!nodeMap.containsKey(val)) {
            Node node = new Node();
            node.ordinal = val;
            nodeMap.put(val, node);
        }
        return nodeMap.get(val);
    }


    public static class NodeAndLength {
        Node node;
        int length;

        NodeAndLength(Node node, int length) {
            this.node = node;
            this.length = length;
        }
    }

    public static class Node {
        int ordinal;
        private List<Node> children = new ArrayList<>();

        public List<Node> getChildren() {
            return this.children;
        }

        public void addChild(Node node) {
            this.children.add(node);
        }
    }
}
