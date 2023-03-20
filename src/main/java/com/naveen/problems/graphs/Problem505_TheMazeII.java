package com.naveen.problems.graphs;
import java.util.Arrays;
import java.util.PriorityQueue;
// https://leetcode.ca/all/505.html
public class Problem505_TheMazeII {
    private int[][] moves = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
    private static class Node implements Comparable<Node> {
        int st, end, steps;
        public Node(int st, int end, int steps) {
            this.st = st; this.end = end; this.steps = steps;
        }
        public int compareTo(Node o) {
            return steps - o.steps;
        }
    }

    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(distance[i], Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start[0], start[1], 0));
        distance[start[0]][start[1]] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.st, y = cur.end;
            if (visited[x][y]) continue;
            visited[x][y] = true;

            for (int[] move : moves) {
                int count = 0;
                int i = move[0], j = move[1];
                while (x + i >= 0 && x + i < m && y + j >= 0 && y + j < n && maze[x + i][y + j] == 0) {
                    x += i; y += j; count++;
                }
                if (!visited[x][y]) {
                    distance[x][y] = Math.min(distance[x][y], cur.steps + count);
                    pq.offer(new Node(x, y, distance[x][y]));
                }
            }
        }
        return distance[dest[0]][dest[1]] != Integer.MAX_VALUE ? distance[dest[0]][dest[1]] : -1;
    }
}
