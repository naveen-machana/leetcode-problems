package com.naveen.problems.binarysearch;

import java.util.Arrays;

/*
* https://leetcode.com/problems/find-the-distance-value-between-two-arrays
* Given two integer arrays arr1 and arr2, and the integer d, return the distance value between the two arrays.
* The distance value is defined as the number of elements arr1[i] such that there is not any
* element arr2[j] where |arr1[i]-arr2[j]| <= d.
Input: arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
Output: 2
Explanation:
For arr1[0]=4 we have:
|4-10|=6 > d=2
|4-9|=5 > d=2
|4-1|=3 > d=2
|4-8|=4 > d=2
For arr1[1]=5 we have:
|5-10|=5 > d=2
|5-9|=4 > d=2
|5-1|=4 > d=2
|5-8|=3 > d=2
For arr1[2]=8 we have:
|8-10|=2 <= d=2
|8-9|=1 <= d=2
|8-1|=7 > d=2
|8-8|=0 <= d=2
* */
public class Problem1385_DistanceValueBetweenTwoArrays {
    public static void main(String[] args) {
        Problem1385_DistanceValueBetweenTwoArrays sol = new Problem1385_DistanceValueBetweenTwoArrays();
        int[] a = {4,5,8}, b = {10,9,1,8};
        System.out.println(sol.findTheDistanceValue(a, b, 2));
    }
    public int findTheDistanceValue(int[] a, int[] b, int d) {
        Arrays.sort(b);
        int res = 0;
        for (int v : a) {
            if (notInRange(b, v - d, v + d))
                res++;
        }
        return res;
    }

    private boolean notInRange(int[] a, int from, int to) {
        int l = 0, h = a.length - 1;
        while (l <= h) {
            int m = (l + h)/2;
            if (a[m] >= from && a[m] <= to) return false;
            else if (a[m] < from) l = m + 1;
            else h = m - 1;
        }
        return true;
    }
}
