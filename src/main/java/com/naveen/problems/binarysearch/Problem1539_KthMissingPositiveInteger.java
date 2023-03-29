package com.naveen.problems.binarysearch;

/*
* https://leetcode.com/problems/kth-missing-positive-number
* Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
* Return the kth positive integer that is missing from this array.
*
Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
*                  a = [2,3,4,7,11]
* a[i] - (i + 1) = b = [1,1,1,3, 6]
* */
public class Problem1539_KthMissingPositiveInteger {
    public static void main(String[] args) {
        Problem1539_KthMissingPositiveInteger sol = new Problem1539_KthMissingPositiveInteger();
        int[] a = {2,3,4,7,11};
        System.out.println(sol.findKthPositive(a, 5));
    }
    public int findKthPositive(int[] a, int k) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r)/2;
            int x = a[m] - (m + 1);
            if (x >= k) r = m;
            else l = m + 1;
        }
        return l + k;
    }
}
