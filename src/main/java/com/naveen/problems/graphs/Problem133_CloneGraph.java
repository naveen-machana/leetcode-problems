package com.naveen.problems.graphs;

import java.util.*;

/*
* https://leetcode.com/problems/clone-graph/
* */
public class Problem133_CloneGraph {
    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> clone = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        dfs(node, clone, visited);
        return clone.get(node);
    }

    private void dfs(Node node, Map<Node, Node> clone, Set<Node> visited) {
        visited.add(node);
        clone.put(node, new Node(node.val));
        for (Node adj : node.neighbors) {
            if (!visited.contains(adj))
                dfs(adj, clone, visited);
        }
        Node nodeCloned = clone.get(node);
        for (Node adj : node.neighbors) {
            Node adjCloned = clone.get(adj);
            nodeCloned.neighbors.add(adjCloned);
        }
    }
}
