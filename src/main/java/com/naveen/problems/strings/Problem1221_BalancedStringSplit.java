package com.naveen.problems.strings;

public class Problem1221_BalancedStringSplit {
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
