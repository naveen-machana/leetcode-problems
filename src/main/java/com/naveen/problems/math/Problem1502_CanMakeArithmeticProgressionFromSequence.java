package com.naveen.problems.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
/*
* A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
* Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.
* Input: arr = [3,5,1]
Output: true
Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
* */
public class Problem1502_CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression2(int[] a) {
        Arrays.sort(a);
        for (int i = 2; i < a.length; i++)
            if (a[i] - a[i - 1] != a[i - 1] - a[i - 2])
                return false;
        return true;
    }
    public boolean canMakeArithmeticProgression(int[] a) {
        Set<Integer> seen = new HashSet<>();
        int min = a[0], max = a[0], n = a.length;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
            seen.add(a[i]);
        }
        int count = n - 1; // n - 1 because in an array of 3 elements there will be 2 differences, 4 -> 3, etc
        if ((max - min) % count != 0) return false;
        int diff = (max - min) / count;
        while ( count >= 0) {
            if (!seen.contains(min)) return false;
            min += diff;
            count--;
        }
        return true;
    }
}
