package com.naveen.problems.arrays;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/
// 118. Pascal's Triangle
// Given an integer numRows, return the first numRows of Pascal's triangle.
//
// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
public class Problem118_PascalsTriangle {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> cur = new ArrayList<>();

            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i)
                    cur.add(1);
                else {
                    cur.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
                }
            }
            res.add(cur);
        }
        return res;
    }
}
