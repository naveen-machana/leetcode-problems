package com.naveen.problems.problem1221;

public class Solution {
    public int balancedStringSplit(String s) {
        int res = 0, cnt = 0;
        char[] carr = s.toCharArray();
        for (char c : carr) {
            cnt += c == 'L' ? 1 : -1;
            res += cnt == 0 ? 1 : 0;
        }
        return res;
    }
}
