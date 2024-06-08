package com.naveen.problems.arrays;

import java.util.*;

/*
https://leetcode.com/problems/next-greater-element-i/
The next greater element of some element x in an array is the first greater element that is to the right of x
in the same array. You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater
element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.

* */
public class Problem496_NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) indexes.put(nums1[i], i);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                res[indexes.get(stack.pop())] = nums2[i];
            }
            if (indexes.containsKey(nums2[i])) {
                stack.push(nums2[i]);
            }
        }
        return res;
    }
}