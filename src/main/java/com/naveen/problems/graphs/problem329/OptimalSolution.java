package com.naveen.problems.graphs.problem329;

import java.util.*;
// Accepted
// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/solutions/288520/longest-path-in-dag/?orderBy=most_votes
public class OptimalSolution {
    public static void main(String[] args) {
        OptimalSolution s = new OptimalSolution();
        int[][] m = {{1}};
        System.out.println(s.longestIncreasingPath(m));
    }
    private static int[][] POSSIBLE_MOVES = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Map<Pair, List<Pair>> map = new HashMap<>();
        Map<Pair, Integer> indegree = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Pair src = new Pair(i, j);
                indegree.putIfAbsent(src, 0);
                for (int[] move : POSSIBLE_MOVES) {
                    int x = i + move[0], y = j + move[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && matrix[i][j] < matrix[x][y]) {
                        Pair dst = new Pair(x, y);
                        map.computeIfAbsent(src, k -> new ArrayList<>()).add(dst);
                        indegree.merge(dst, 1, (ov, nv) -> ov + nv);
                    }
                }
            }
        }

        Queue<Pair> q = new LinkedList<>();
        for (Pair p : indegree.keySet()) {
            if (indegree.get(p) == 0) {
                p.steps = 1;
                q.offer(p);
            }
        }

        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            max = Math.max(max, cur.steps);
            List<Pair> adj = map.getOrDefault(cur, Collections.EMPTY_LIST);
            for (Pair a : adj) {
                int in = indegree.get(a);
                indegree.put(a, in - 1);
                if (indegree.get(a) == 0) {
                    a.steps = cur.steps + 1;
                    q.offer(a);
                }
            }
        }

        return max;
    }
    private static class Pair {
        int src, dst, steps;
        public Pair(int src, int dst) { this.src = src; this.dst = dst; }
        public int hashCode() { return 31 * src + dst;}
        public boolean equals(Object o) {
            Pair other = (Pair)o;
            return this.src == other.src && this.dst == other.dst;
        }
        public String toString() { return "[" + src + " -> " + dst + ", " + steps + "]";}
    }
}
