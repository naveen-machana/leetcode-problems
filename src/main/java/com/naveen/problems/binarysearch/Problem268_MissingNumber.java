package com.naveen.problems.binarysearch;

/*
* https://leetcode.com/problems/missing-number/
* Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range
* that is missing from the array.
*
* Input: nums = [3,0,1]
* Output: 2
* Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the
* missing number in the range since it does not appear in nums.
* */
public class Problem268_MissingNumber {
    public int missingNumber(int[] nums) {
        int xor = 0, n = nums.length;
        for (int i = 0; i <= n; i++) xor ^= i;
        for (int i = 0; i < n; i++) xor ^= nums[i];
        return xor;
    }

    public int missingNumber2(int[] nums) {
        int l = 0, r = nums.length;
        int res = 0;
        while (l <= r) {
            int m = (l + r)/2;
            int count = 0;
            for (int i = 0; i < nums.length; i++)
                if (nums[i] < m) count++;
            if (count < m)
                r = m - 1;
            else {
                res = m;
                l = m + 1;
            }
        }
        return res;
    }
}
