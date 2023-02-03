package com.naveen.problems.arrays.problem56;

import java.util.*;

// https://leetcode.com/problems/merge-intervals/
// 56. Merge Intervals
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
// and return an array of the non-overlapping intervals that cover all the intervals in the input.
public class Solution {
    public static void main(String[] args) {
        int[][] a = {{1,3},{2,6},{8,10},{15,18}};
        Solution s = new Solution();
        s.merge(a);
    }
    public int[][] merge(int[][] a) {
        Arrays.sort(a, (one, two) -> one[0] - two[0]);
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : a) {
            if (merged.isEmpty() || interval[0] > merged.getLast()[1]) {
                merged.add(interval);
            }
            else {
                merged.getLast()[1] = Math.max(interval[1], merged.getLast()[1]);
            }
        }

        return merged.toArray(new int[merged.size()][1]);
    }
}
