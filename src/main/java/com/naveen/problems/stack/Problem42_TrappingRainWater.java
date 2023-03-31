package com.naveen.problems.stack;

import java.util.ArrayDeque;

// https://leetcode.com/problems/trapping-rain-water/
// 42. Trapping Rain Water
// Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it can trap after raining.
public class Problem42_TrappingRainWater {
    public int trap1(int[] a) {
        int n = a.length;
        int[] left = new int[n], right = new int[n];
        int res = 0;

        left[0] = a[0]; right[n - 1] = a[n - 1];
        for (int i = 1; i < n; i++)  left[i] = Math.max(left[i - 1], a[i]);
        for (int j = n - 2; j >= 0; j--) right[j] = Math.max(right[j + 1], a[j]);

        for (int i = 0; i < n; i++) {
            res += Math.min(left[i], right[i]) - a[i];
        }

        return res;
    }

    public int trap(int[] a) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            int bar = a[i];
            if (stack.isEmpty() || a[stack.peek()] > bar) stack.push(i);
            else {
                while (!stack.isEmpty() && a[stack.peek()] <= bar) {
                    int topIndex = stack.pop();
                    int h = stack.isEmpty() ? i : Math.min(bar, a[stack.peek()]) - a[topIndex];
                    int w = stack.isEmpty() ? 0 : i - stack.peek() - 1;
                    sum += h * w;
                }
                stack.push(i);
            }
        }
        return sum;
    }
}
