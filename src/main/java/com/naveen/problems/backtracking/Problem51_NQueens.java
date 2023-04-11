package com.naveen.problems.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* https://leetcode.com/problems/n-queens/
* The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
* queen and an empty space, respectively.
* */
public class Problem51_NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        solve(0, n, res, board);
        return res;
    }

    private void solve(int i, int n, List<List<String>> res, boolean[][] board) {
        if (i == n) {
            addToRes(res, board, n);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isValid(i, j, n, board)) {
                board[i][j] = true;
                solve(i + 1, n, res, board);
                board[i][j] = false;
            }
        }
    }

    private static final int[][] MOVES = {{-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
    private boolean isValid(int x, int y, int n, boolean[][] board) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        Set<String> rc = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]) {
                    row.add(i);
                    col.add(j);
                    rc.add(i + "#" + j);
                }
            }
        }

        if (row.contains(x)) return false;
        if (col.contains(y)) return false;
        for (int i = 0; i < n; i++) {
            for (int[] move : MOVES) {
                if (rc.contains((x + i * move[0]) + "#" + (y + i * move[1])))
                    return false;
            }
        }
        return true;
    }

    private void addToRes(List<List<String>> res, boolean[][] board, int n) {
        ArrayList<String> cur = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++)
                sb.append(board[i][j] ? "Q" : ".");
            cur.add(sb.toString());
        }
        res.add(cur);
    }
}
