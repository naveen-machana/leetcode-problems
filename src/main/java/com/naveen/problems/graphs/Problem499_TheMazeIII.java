package com.naveen.problems.graphs;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.ca/all/499.html
public class Problem499_TheMazeIII {
    private static class Node implements Comparable<Node> {
        int st, end, steps;
        String path;
        public Node(int st, int end, int steps, String path) {
            this.st = st; this.end = end; this.steps = steps; this.path = path;
        }
        public int compareTo(Node o) {
            if (steps != o.steps) return steps - o.steps;
            return path.compareTo(o.path);
        }
    }
    static Map<String, int[]> moves = new LinkedHashMap<>();
    static {
        moves.put("d", new int[]{1, 0});
        moves.put("l", new int[]{0, -1});
        moves.put("r", new int[]{0, 1});
        moves.put("u", new int[]{-1, 0});
    }

    public String shortestDistancePath(int[][] maze, int[] start, int[] dest) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        String[][] path = new String[m][n];
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(distance[i], Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int i = start[0], j = start[1];
        pq.offer(new Node(i, j, 0, ""));
        distance[i][j] = 0;
        path[i][j] = "";

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.st, y = cur.end, curdist = cur.steps;
            if (dest[0] == x && dest[1] == y) return cur.path;

            if (visited[x][y]) continue;
            visited[x][y] = true;

            for (Map.Entry<String, int[]> move : moves.entrySet()) {
                int count = 0; String pathnew = cur.path + move.getKey();
                i = move.getValue()[0]; j = move.getValue()[1];

                while (x + i >= 0 && x + i < m && y + j >= 0 && y + j < n
                        && maze[x + i][y + j] != 1
                        && !isSame(x + i, x + j, dest)) {
                    x += i; y += i;
                    count++;
                }

                if (!visited[x][y] || pathnew.compareTo(path[x][y]) <= 0) {
                    distance[x][y] = curdist + count;
                    path[x][y] = pathnew;
                    pq.offer(new Node(x, y, count + curdist, path[x][y]));
                }
            }
        }

        return "Impossible";
    }

    private boolean isSame(int i, int j, int[] dest) {
        return i == dest[0] && j == dest[1];
    }
}
