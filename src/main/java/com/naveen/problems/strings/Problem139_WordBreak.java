package com.naveen.problems.strings;

import java.util.*;

// https://leetcode.com/problems/word-break/
// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
// sequence of one or more dictionary words.
//
// Note that the same word in the dictionary may be reused multiple times in the segmentation.
// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".
public class Problem139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        if (wordDict.contains(s)) return true;
        return possible(s, dict, 0, new Boolean[s.length()]);
    }

    private boolean possible (String s, Set<String> dict, int st, Boolean[] seen) {
        if (st >= s.length()) return true;

        if (seen[st] != null) return seen[st];

        for (int end = st; end < s.length(); end++) {
            String temp = s.substring(st, end + 1);
            if (dict.contains(temp) && possible(s, dict, end + 1, seen)) {
                seen[st] = true;
                return true;
            }
        }
        return seen[st] = false;
    }

    private boolean possible2(String s, Set<String> dict) {
        int len = s.length();
        if (len == 0) return true;

        for (int i = 1; i <= len; i++) {
            if (dict.contains(s.substring(0, i)) && possible2(s.substring(i), dict)) {
                return true;
            }
        }

        return false;
    }


    public boolean workBreak2(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>(wordDict);
        if (dictionary.contains(s)) return true;
        boolean[] visited = new boolean[s.length()];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while (!q.isEmpty()) {
            int st = q.poll();
            if (visited[st]) continue;

            for (int end = st + 1; end <= s.length(); end++) {
                if (dictionary.contains(s.substring(st, end))) {
                    q.offer(end);
                    if (end == s.length()) {
                        return true;
                    }
                }
            }
            visited[st] = true;
        }

        return false;
    }
}
