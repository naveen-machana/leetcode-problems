package com.naveen.problems.graphs;

import java.util.PriorityQueue;

public class Problem1584_MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((one, two) -> one[0] - two[0]);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                pq.offer(new int[]{findDist(points[i], points[j]), i, j});
            }
        }
        UnionFind unionFind = new UnionFind(points.length);
        int cost = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (unionFind.union(cur[1], cur[2])) cost += cur[0];
        }
        return cost;
    }

    private int findDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    private static class UnionFind {
        int[] rep;

        public UnionFind(int n) {
            rep = new int[n];
            for (int i = 0; i < n; i++) rep[i] = i;
        }

        public int find(int a) {
            if (a == rep[a]) return a;
            rep[a] = find(rep[a]);
            return rep[a];
        }

        public boolean union(int a, int b) {
            int repa = find(a);
            int repb = find(b);
            if (repa == repb) return false;
            rep[repa] = rep[repb];
            return true;
        }
    }
}
