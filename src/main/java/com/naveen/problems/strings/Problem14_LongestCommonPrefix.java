package com.naveen.problems.strings;

// https://leetcode.com/problems/longest-common-prefix/
// 14. Longest Common Prefix
// Write a function to find the longest common prefix string amongst an array of strings.
//
// If there is no common prefix, return an empty string "".
// Input: strs = ["flower","flow","flight"]
// Output: "fl"
public class Problem14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        return lcs(strs, 0, strs.length - 1);
    }

    public String lcs(String[] strs, int l, int h) {
        if (l > h) return "";
        if (l == h) return strs[l];
        int m = (l + h) / 2;
        String left = lcs(strs, l , m);
        String right = lcs(strs, m + 1, h);
        return commonPrefix(left, right);
    }

    private String commonPrefix(String left, String right) {
        int n1 = left.length();
        int n2 = right.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(n1, n2); i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return sb.toString();
            }
            sb.append(left.charAt(i));
        }

        return sb.toString();
    }

}
