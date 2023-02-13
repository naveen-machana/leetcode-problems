package com.naveen.problems.strings;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/word-pattern/
// 290. Word Pattern
// Given a pattern and a string s, find if s follows the same pattern.
//
// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
// Input: pattern = "abba", s = "dog cat cat dog"
// Output: true
public class Problem290_WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        return transformPattern(pattern).equals(transformWords(words));
    }

    private static String transformPattern(String pattern) {
        Map<Character, Integer> indexMap = new HashMap<>();
        StringBuilder indexPath = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!indexMap.containsKey(c)) {
                indexMap.put(c, i);
            }
            indexPath.append(indexMap.get(c));
            indexPath.append(" ");
        }
        return indexPath.toString();
    }

    private static String transformWords(String[] words) {
        Map<String, Integer> indexMap = new HashMap<>();
        StringBuilder indexPath = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String c = words[i];
            if (!indexMap.containsKey(c)) {
                indexMap.put(c, i);
            }
            indexPath.append(indexMap.get(c));
            indexPath.append(" ");
        }
        return indexPath.toString();
    }
}
