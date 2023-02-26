package com.naveen.problems.stack;

import java.util.ArrayDeque;

/*
* https://leetcode.com/problems/container-with-most-water/
* You are given an integer array height of length n. There are n vertical lines drawn such that the two
* endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.
* */
public class Problem11_ContainerWithMostWater {
    public static void main(String[] args) {
        Problem11_ContainerWithMostWater sol = new Problem11_ContainerWithMostWater();
        int[] a = {1,8,6,2,5,4,8,3,7};
        sol.maxArea(a);
    }
    public int maxArea(int[] a) {
        int l = 0, r = a.length - 1;
        int max = 0;
        while (l < r) {
            int w = (r - l);
            int h = Math.min(a[l], a[r]);
            max = Math.max(max, w * h);
            if (a[l] < a[r]) l++;
            else r--;
        }
        return max;
    }
}
