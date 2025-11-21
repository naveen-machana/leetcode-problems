package com.naveen.blind75.arrays;

import java.util.*;

public class Problem49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            char[] chars = new char[26];
            for (char ch : s.toCharArray()) {
                chars[ch - 'a'] += 1;
            }
            groups.computeIfAbsent(new String(chars), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(groups.values());
    }
}
