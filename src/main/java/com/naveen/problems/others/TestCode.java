package com.naveen.problems.others;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCode {
    public String largestNumber(int[] nums) {
        Comparator<String> cmp = (one, two) -> {
            String oneTwo = one + two;
            String twoOne = two + one;
            return twoOne.compareTo(oneTwo);
        };
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, cmp);
        if (strs[0].charAt(0) == '0') return "0";
        return Stream.of(strs).collect(Collectors.joining());
    }

}
