package com.naveen.problems.arrays;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/majority-element-ii/
/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
Example 1:
Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
* */
public class Problem229_MajorityElementII {
    public static void main(String[] args) {
        Problem229_MajorityElementII s = new Problem229_MajorityElementII();
        int[] a = {2,1,1,3,1,4,5,6};
        s.majorityElement(a);
    }
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int candidate1 = nums[0], candidate2 = nums[0];

        for (int n : nums) {
            if (candidate1 == n) {
                count1++;
            }
            else if (candidate2 == n) {
                count2++;
            }
            else if (count1 == 0) {
                candidate1 = n; count1++;
            }
            else if (count2 == 0) {
                candidate2 = n; count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0; count2 = 0;
        for (int n : nums) {
            if (n == candidate1) count1++;
            else if (n == candidate2) count2++;
        }

        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3) res.add(candidate1);
        if (count2 > nums.length / 3) res.add(candidate2);
        return res;
    }
}
