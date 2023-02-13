package com.naveen.problems.strings;

// https://leetcode.com/problems/isomorphic-strings/
// 205. Isomorphic Strings
// Given two strings s and t, determine if they are isomorphic.
//
// Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//
// All occurrences of a character must be replaced with another character while preserving the order of characters.
// No two characters may map to the same character, but a character may map to itself.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        if (s.length() != t.length()) return false;
        int[] sToTMap = new int[256];
        Arrays.fill(sToTMap, -1);
        int[] tToSMap = new int[256];
        Arrays.fill(tToSMap, -1);

        for (int i = 0; i < n; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sToTMap[sChar] == -1 && tToSMap[tChar] == -1) {
                sToTMap[sChar] = tChar;
                tToSMap[tChar] = sChar;
            }
            else if (!(sToTMap[sChar] == tChar && tToSMap[tChar] == sChar)) {
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        int n = s.length();
        if (s.length() != t.length()) return false;
        return transform(s).equals(transform(t));
    }

    private String transform(String s) {
        int n = s.length();
        Map<Character, Integer> indexMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (!indexMap.containsKey(s.charAt(i))) {
                indexMap.put(s.charAt(i), i);
            }
            sb.append(indexMap.get(s.charAt(i)));
            sb.append(" ");
        }

        return sb.toString();
    }
}
