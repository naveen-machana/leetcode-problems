package com.naveen.problems.problem133;

import java.util.*;

class Node {
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

public class Solution {
    public Node cloneGraph(Node node) {

        if (node == null) return null;

        Queue<Node> q = new ArrayDeque<>();

        Map<Integer, Node> map = new HashMap<>();
        Node newNode = new Node(node.val);
        map.put(node.val, newNode);

        q.offer(node);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (Node adj : cur.neighbors) {
                if (!map.containsKey(adj.val)) {
                    map.put(adj.val, new Node(adj.val));
                    q.offer(adj);
                }
                map.get(cur.val).neighbors.add(map.get(adj.val));
            }
        }

        return newNode;

    }
}
