package com.naveen.problems.matrices;

// https://leetcode.com/problems/spiral-matrix/

/*
* Given an m x n matrix, return all elements of the matrix in spiral order.
* */
import java.util.ArrayList;
import java.util.List;

public class Problem54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int rBegin = 0, rEnd = matrix.length - 1, cBegin = 0, cEnd = matrix[0].length - 1;
        while (rBegin <= rEnd && cBegin <= cEnd) {
            for (int j = cBegin; j <= cEnd && list.size() < m * n; j++) list.add(matrix[rBegin][j]);
            rBegin++;
            for (int j = rBegin; j <= rEnd && list.size() < m * n; j++) list.add(matrix[j][cEnd]);
            cEnd--;
            for (int j = cEnd; j >= cBegin && list.size() < m * n; j--) list.add(matrix[rEnd][j]);
            rEnd--;
            for (int j = rEnd; j >= rBegin && list.size() < m * n; j--) list.add(matrix[j][cBegin]);
            cBegin++;
        }
        return list;
    }
}
