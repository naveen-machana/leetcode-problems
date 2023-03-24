package com.naveen.problems.dp;

public class Problem304_RangeSumQuery2DImmutable {
    class NumMatrix {
        int[][] sum;

        public NumMatrix(int[][] a) {
            int m = a.length, n = a[0].length;
            sum = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    sum[i][j] = a[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int r1, int c1, int r2, int c2) {
            return sum[r2 + 1][c2 + 1] - sum[r1][c2 + 1] - sum[r2 + 1][c1] + sum[r1][c1];
        }
    }
}
