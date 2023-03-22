package com.naveen.problems.dp;

import java.util.ArrayList;
import java.util.List;

/*
* https://leetcode.com/problems/triangle
* Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally,
*  if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
* */
public class Problem120_Triangle {
    public int minimumTotal(List<List<Integer>> a) {
        int m = a.size();
        List<Integer> prev = new ArrayList<>();
        for (int n : a.get(m - 1)) prev.add(n);

        for (int i = m - 2; i >= 0; i--) {
            List<Integer> cur = a.get(i);
            List<Integer> minCurList = new ArrayList<>();
            for (int j = 0; j < cur.size(); j++) {
                int one = prev.get(j);
                int two = j < prev.size() - 1 ? prev.get(j + 1) : Integer.MAX_VALUE;
                int curMin = cur.get(j) + Math.min(one, two);
                minCurList.add(curMin);
            }
            prev = minCurList;
        }
        return prev.get(0);
    }
}
