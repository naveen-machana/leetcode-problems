package com.naveen.problems.strings;

import java.util.Arrays;

// https://leetcode.com/problems/interleaving-string/
// Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
//
// An interleaving of two strings s and t is a configuration where s and t are divided into n and m
//substrings
// respectively, such that:
//
// s = s1 + s2 + ... + sn
// t = t1 + t2 + ... + tm
// |n - m| <= 1
// The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
// Note: a + b is the concatenation of strings a and b.
// Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
// Output: true
// Explanation: One way to obtain s3 is:
// Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
// Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
// Since s3 can be obtained by interleaving s1 and s2, we return true.
public class Problem97_InterleavingStrings {
    public static void main(String[] args) {
        Problem97_InterleavingStrings sol = new Problem97_InterleavingStrings();
        System.out.println(sol.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }


    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int[][] mem = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) Arrays.fill(mem[i], -1);
        return isInterleave(s1, 0, s2, 0, s3, 0, mem);
    }

    public boolean isInterleave(String s1, int i, String s2, int j, String s3, int k, int[][] mem) {
        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(k));
        }

        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        }

        if (mem[i][j] >= 0) return mem[i][j] == 1 ? true : false;
        boolean res = false;

        if ((s1.charAt(i) == s3.charAt(k) && isInterleave(s1, i + 1, s2, j, s3, k + 1, mem))
            || (s2.charAt(j) == s3.charAt(k) && isInterleave(s1, i, s2, j + 1, s3, k + 1, mem))) {
            res = true;
        }
        mem[i][j] = res ? 1 : 0;
        return res;
    }

    public boolean isInterleave3(String s1, String s2, String s3) {
        int l = s1.length(), m = s2.length(), n = s3.length();
        if (l + m != n) return false;
        boolean[][] dp = new boolean[l + 1][m + 1];
        for (int i = 0; i <= l; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) dp[i][j] = true;
                else if (i == 0) dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                else if (j == 0) dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                else {
                    dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) ||
                            (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[l][m];
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        return isInterleave2(s1, s2, s3, 0, "", 0);
    }

    public boolean isInterleave2(String s1, String s2, String s3, int is1, String cur, int is2) {
        if (cur.length() == s3.length() && is1 == s1.length() && is2 == s2.length()) {
            return cur.equals(s3);
        }

        boolean res = false;
        if (is1 < s1.length()) {
            res |= isInterleave2(s1, s2, s3, is1 + 1, cur + s1.charAt(is1), is2);

        }
        if (is2 < s2.length()) {
            res |= isInterleave2(s1, s2, s3, is1, cur + s2.charAt(is2), is2 + 1);
        }

        return res;
    }


}
