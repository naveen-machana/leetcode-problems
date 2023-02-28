package com.naveen.problems.arrays;

import java.util.ArrayList;
import java.util.List;

/*
* https://leetcode.com/problems/pascals-triangle-ii/
* Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
*
* Input: rowIndex = 3
Output: [1,3,3,1]
* Input: rowIndex = 1
Output: [1,1]
*
* */
public class Problem119_PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        int[] rs = new int[rowIndex + 1];
        rs[0] = 1;
        for (int i = 1; i < rowIndex + 1; i++) {
            for (int j = i; j > 0; j--) {
                rs[j] += rs[j - 1];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int j : rs) res.add(j);
        return res;
    }
}
