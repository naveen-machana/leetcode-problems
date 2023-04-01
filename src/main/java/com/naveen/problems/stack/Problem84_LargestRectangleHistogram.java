package com.naveen.problems.stack;

import java.util.LinkedList;

/*
* https://leetcode.com/problems/largest-rectangle-in-histogram/
* Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
* return the area of the largest rectangle in the histogram.
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
* */
public class Problem84_LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        LinkedList<int[]> stack = new LinkedList<>();
        int max = 0, n = heights.length;
        for (int i = 0; i < n; i++) {
            int nexti = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                int h = top[1], w = i - top[0];
                max = Math.max(max, w * h);
                nexti = top[0];
            }
            stack.push(new int[]{nexti, heights[i]});
        }

        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int h = top[1], w = n - top[0];
            max = Math.max(max, w * h);
        }
        return max;
    }
}
