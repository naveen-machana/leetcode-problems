package com.naveen.problems.arrays;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Problem496_NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek())
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int j = 0; j < nums1.length; j++)
            res[j] = map.getOrDefault(nums1[j], -1);
        return res;
    }
}