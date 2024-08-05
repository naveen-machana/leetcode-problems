package com.naveen.problems.twopointer;

import java.util.Arrays;

public class Problem455_AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, res = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i ++;
                j ++;
                res ++;
            }
            else j++;
        }
        return res;
    }
}
