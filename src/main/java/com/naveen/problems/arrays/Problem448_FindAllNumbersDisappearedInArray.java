package com.naveen.problems.arrays;

import java.util.ArrayList;
import java.util.List;

/*
* https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
* Given an array nums of n integers where nums[i] is in the range [1, n],
* return an array of all the integers in the range [1, n] that do not appear in nums.
*
* Input: nums = [4,3,2,7,8,2,3,1]
0,1,2,3,4,5,6,7
7,3,2,4,8,2,3,1
3,3,2,4,8,2,7,1
2,3,3,4,8,2,7,1
3,2,3,4,8,2,7,1
3,2,3,4,1,2,7,8
1,2,3,4,3,2,7,8


Output: [5,6]
*
* */
public class Problem448_FindAllNumbersDisappearedInArray {
    public static void main(String[] args) {
        Problem448_FindAllNumbersDisappearedInArray sol = new Problem448_FindAllNumbersDisappearedInArray();
        sol.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }
    public List<Integer> findDisappearedNumbers(int[] a) {
        for (int i = 0; i < a.length; i++) {
            while (i != a[i] - 1 && a[i] != a[a[i] - 1]) {
                swap(a, i, a[i] - 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            if (i != a[i] - 1) list.add(i + 1);
        return list;
    }
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
