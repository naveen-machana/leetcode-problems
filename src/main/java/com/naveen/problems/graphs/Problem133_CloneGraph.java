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
        Map<Node, Node> cloned = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        dfs(node, visited, cloned);
        return cloned.get(node);
    }

    private void dfs(Node node, Set<Node> visited, Map<Node, Node> cloned) {
        visited.add(node);
        cloned.put(node, new Node(node.val));

        for (Node adj : node.neighbors) {
            if (!visited.contains(adj))
                dfs(adj, visited, cloned);
        }

        for (Node adj : node.neighbors) {
            Node newAdj = cloned.get(adj);
            cloned.get(node).neighbors.add(newAdj);
        }
    }
}
