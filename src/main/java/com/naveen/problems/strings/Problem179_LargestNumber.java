package com.naveen.problems.strings;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://leetcode.com/problems/largest-number/
// Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
//
// Since the result may be very large, so you need to return a string instead of an integer.
// Input: nums = [3,30,34,5,9]
// Output: "9534330"
public class Problem179_LargestNumber {
    public String largestNumber(int[] nums) {
        String[] numsStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) numsStrings[i] = String.valueOf(nums[i]);
        Arrays.sort(numsStrings, (o, t) -> {
            String osts = o + t;
            String tsos = t + o;
            return tsos.compareTo(osts);
        });
        if (numsStrings[0].charAt(0) == '0') return "0";
        return Stream.of(numsStrings).collect(Collectors.joining());
    }
}
