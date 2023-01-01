package com.naveen.problems.problem1323;

public class Solution {
    public int maximum69Number (int num) {
        return Integer.valueOf(("" + num).replaceFirst("6", "9"));
    }
}
