package com.naveen.problems.graphs;

import java.util.HashSet;
import java.util.Set;

public class Problem323_NumberOfConnectedComponentsInAnUndirectedGraph {
    public static void main(String[] args) {
        int[][] a = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        Problem323_NumberOfConnectedComponentsInAnUndirectedGraph sol = new Problem323_NumberOfConnectedComponentsInAnUndirectedGraph();
        int res = sol.totalConnectedComp(a, a.length);
        System.out.println(res);
    }
    public int totalConnectedComp(int[][] a, int n) {
        int[] rep = new int[n];
        for (int i = 0; i < n; i++) rep[i] = i;
        int count = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1 && union(i, j, rep)) count--;
            }
        }
        return count;
    }

    private int find(int a, int[] rep) {
        if (a == rep[a]) return a;
        return find(rep[a], rep);
    }

    private boolean union(int a, int b, int[] rep) {
        int ra = find(a, rep);
        int rb = find(b, rep);
        if (ra == rb) return false;
        rep[rb] = ra;
        return true;
    }
}
