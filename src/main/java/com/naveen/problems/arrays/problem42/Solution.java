package com.naveen.problems.arrays.problem42;

import java.util.ArrayDeque;

// https://leetcode.com/problems/trapping-rain-water/
// 42. Trapping Rain Water
// Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it can trap after raining.
public class Solution {
    public int trap1(int[] a) {
        int n = a.length;
        int[] left = new int[n], right = new int[n];

        left[0] = a[0]; right[n - 1] = a[n - 1];
        for (int i = 1; i < n; i++) left[i] = Math.max(left[i - 1], a[i]);
        for (int i = n - 2; i >= 0; i--) right[i] = Math.max(a[i], right[i + 1]);

        int res = 0;
        for (int i = 0; i < n; i++)
            res += Math.min(left[i], right[i]) - a[i];

        return res;
    }

    public int trap(int[] a) {
        int n = a.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int i = 0, maxWater = 0, maxBotWater;
        while (i < n) {
            if (stack.isEmpty() || a[stack.peek()] <= a[i]) {
                stack.push(i++);
            }
            else {
                int bot = stack.pop();
                maxBotWater = stack.isEmpty() ? 0
                        : (Math.min(a[stack.peek()], a[i]) - a[bot])
                          * (i - stack.peek() - 1);
                maxWater += maxBotWater;
            }
        }
        return maxWater;
    }
}
