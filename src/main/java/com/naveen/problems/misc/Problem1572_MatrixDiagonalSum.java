package com.naveen.problems.misc;

/*
* https://leetcode.com/problems/matrix-diagonal-sum/description/
* Given a square matrix mat, return the sum of the matrix diagonals.

* Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal
* that are not part of the primary diagonal.
Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.
* */
public class Problem1572_MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int sum = 0, n = mat.length;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            if (i != n - 1 - i)  sum += mat[i][n - 1 - i];
        }
        return sum;
    }
}
