package com.naveen.problems.dp;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/integer-break
* Given an integer n, break it into the sum of k positive integers, where k >= 2,
* and maximize the product of those integers. Return the maximum product you can get.
* Input: n = 2
* Output: 1
* Explanation: 2 = 1 + 1, 1 × 1 = 1.
* */
public class Problem343_IntegerBreak {
    public static void main(String[] args) {
        Problem343_IntegerBreak sol = new Problem343_IntegerBreak();
        System.out.println(sol.integerBreak(3));
    }
    public int integerBreak(int n) {
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 1) return 1;
        int res = 0;
        for (int i = 1; i < n; i++) {
            int subres = dfs(i) * dfs(n - i);
            res = Math.max(res, subres);
        }
        return res;
    }
}
