package com.naveen.problems.dp;

/*
* https://leetcode.com/problems/matrix-block-sum/
* Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements
* mat[r][c] for:
i - k <= r <= i + k,
j - k <= c <= j + k, and
(r, c) is a valid position in the matrix.
*
* Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
* Output: [[12,21,16],[27,45,33],[24,39,28]]
* */
public class Problem1314_MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] pre = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                pre[i][j] = mat[i - 1][j - 1] + pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];

        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - k), c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k), c2 = Math.min(n - 1, j + k);
                r1++; r2++; c1++; c2++;
                res[i][j] = pre[r2][c2] - pre[r2][c1 - 1] - pre[r1 - 1][c2] + pre[r1 - 1][c1 - 1];
            }
        }
        return res;
    }
}
