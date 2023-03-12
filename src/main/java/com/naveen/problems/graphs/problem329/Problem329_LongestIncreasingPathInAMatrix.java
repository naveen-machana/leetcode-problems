package com.naveen.problems.graphs.problem329;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
// Given an m x n integers matrix, return the length of the longest increasing path in matrix.
//
//From each cell, you can either move in four directions: left, right, up, or down.
// You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
// backtracking solution
public class Problem329_LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Problem329_LongestIncreasingPathInAMatrix s = new Problem329_LongestIncreasingPathInAMatrix();
        int[][] m = {{3,4,5},{3,2,6},{2,2,1}};
        System.out.println(s.longestIncreasingPath(m));
    }
    public int longestIncreasingPath(int[][] matrix) {

        return path(matrix, matrix.length, matrix[0].length);
    }

    private static class Result {
        int maxSize = 0;
    }
    private int path(int[][] mat, int m, int n) {
        Result res = new Result();
        boolean[][] visited = new boolean[m][n];
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                path.add(mat[i][j]);
                path(mat, i, j, m, n, path, res, visited);
                path.remove((int)(path.size() - 1));
            }
        }
        return res.maxSize;
    }
    private static int[][] adj = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    private void path(int[][] mat, int s, int d, int m, int n, List<Integer> path, Result res, boolean[][] visited) {

        if (path.size() > res.maxSize) res.maxSize = path.size();

        visited[s][d] = true;
        for (int[] move : adj) {
            int x = s + move[0], y = d + move[1];
            if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && mat[s][d] < mat[x][y]) {
                path.add(mat[x][y]);
                path(mat, x, y, m, n, path, res, visited);
                path.remove((int)(path.size() - 1));
            }
        }

        visited[s][d] = false;

    }
}
