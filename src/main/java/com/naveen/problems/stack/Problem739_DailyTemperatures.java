package com.naveen.problems.stack;

import java.util.LinkedList;

/*
* https://leetcode.com/problems/daily-temperatures/
* Given an array of integers temperatures represents the daily temperatures, return an array answer such that
* answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
* If there is no future day for which this is possible, keep answer[i] == 0 instead.
*
* Input: temperatures = [73,74,75,71,69,72,76,73]
* Output: [1,1,4,2,1,1,0,0]
* */
public class Problem739_DailyTemperatures {
    public int[] dailyTemperatures(int[] a) {
        LinkedList<Integer> stack = new LinkedList<>();
        int n = a.length;
        int[] res = new int[n];
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && a[stack.peek()] <= a[i]) stack.pop();
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
