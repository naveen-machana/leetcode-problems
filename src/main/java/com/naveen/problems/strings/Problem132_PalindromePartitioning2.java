package com.naveen.problems.strings;

import java.util.HashMap;
import java.util.Map;

public class Problem132_PalindromePartitioning2 {
    public int minCut(String s) {
        Map<String, Integer> mem = new HashMap<>();
        return minCuts(s, s.length(), mem);
    }


    private int minCuts(String s, int end, Map<String, Integer> mem) {
        if (s.length() <= 1) return 0;
        if (mem.containsKey(s)) return mem.get(s);
        if (isPalindrome(s, 0, end - 1)) {
            mem.put(s, 0);
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int st = 1; st <= end; st++ ) {
            if (isPalindrome(s, 0, st - 1)) {
                String temp = s.substring(st);
                res = Math.min(res, 1 + minCuts(temp, temp.length(), mem));
            }
        }
        mem.put(s, res);
        return res;
    }

    private boolean isPalindrome(String s, int st, int end) {
        while (st < end) {
            if (s.charAt(st++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
