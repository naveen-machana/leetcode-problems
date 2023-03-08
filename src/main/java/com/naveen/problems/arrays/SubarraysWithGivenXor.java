package com.naveen.problems.arrays;

import java.util.HashMap;
import java.util.Map;

// https://takeuforward.org/data-structure/count-the-number-of-subarrays-with-given-xor-k/
// Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all
// elements equal to B.
// runxor = y ^ k
// runxor ^ k = y
// prefixsum = previous_prefixsum + a[i]
//
public class SubarraysWithGivenXor {
    public int solve(int[] a, int b) {
        Map<Integer, Integer> map = new HashMap<>();

        int xor = 0, res = 0, n = a.length;
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            xor ^= a[i];
            if (map.containsKey(xor ^ b)) res += map.get(xor ^ b);
            int count = map.getOrDefault(xor, 0);
            map.put(xor, count + 1);
        }
        return res;
    }
}
