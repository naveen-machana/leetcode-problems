package com.naveen.problems.problem1971;

public class UnionFind {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] union = new int[n];
        for (int i = 0; i < n; i++) union[i] = i;

        for (int[] e : edges) {
            union(e[0], e[1], union);
        }
        return areConnected(source, destination, union);
    }

    private boolean areConnected(int s, int d, int[] union) {
        return find(s, union) == find(d, union);
    }

    private void union(int s, int d, int[] union) {
        int reps = find(s, union);
        int repd = find(d, union);
        if (reps == repd) return;
        union[reps] = repd;
    }

    private int find(int s, int[] union) {
        if (union[s] == s) return s;
        union[s] = find(union[s], union);
        return union[s];
    }
}
