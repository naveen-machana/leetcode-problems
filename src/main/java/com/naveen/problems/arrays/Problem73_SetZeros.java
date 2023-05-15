package com.naveen.problems.arrays;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/set-matrix-zeroes/
// 73. Set Matrix Zeroes
// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
//
// You must do it in place.
public class Problem73_SetZeros {
    public void setZeroes(int[][] matrix) {
        Set<Integer> zr = new HashSet<>();
        Set<Integer> zc = new HashSet<>();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (matrix[i][j] == 0) {
                    zr.add(i); zc.add(j);
                }

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (zr.contains(i) || zc.contains(j))
                    matrix[i][j] = 0;
    }
}
