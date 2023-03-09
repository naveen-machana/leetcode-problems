package com.naveen.problems.dp;

/*
* https://leetcode.com/problems/climbing-stairs/
* You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
* */
public class Problem70_ClimbingStars {
    public static void main(String[] args) {
        Problem70_ClimbingStars sol = new Problem70_ClimbingStars();
        System.out.println(sol.climbStairs(4));
    }
    public int climbStairs(int n) {
        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
