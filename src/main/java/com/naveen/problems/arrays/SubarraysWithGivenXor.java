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
        int xor = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            xor = xor ^ a[i];
            if (map.containsKey(xor ^ b)) {
                count += map.get(xor ^ b);
            }
            if (xor == b) count++;
            map.merge(xor, 1, (ov, nv) -> ov + nv);
        }

        return count;
    }
}
