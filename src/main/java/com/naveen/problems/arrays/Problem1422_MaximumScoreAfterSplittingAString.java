package com.naveen.problems.arrays;

public class Problem1422_MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {
        char[] chars = s.toCharArray();
        int zero = 0, one = 0, res = 0;
        for (char c : chars) one += c - '0';
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '0') zero += 1;
            else one -= 1;
            res = Math.max(res, zero + one);
        }
        return res;
    }
}
