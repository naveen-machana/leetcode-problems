package com.naveen.problems.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-anagrams/
// Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
// typically using all the original letters exactly once..
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
public class Problem49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] count = new char[26];
            for (char c : str.toCharArray()) count[c - 'a']++;
            map.computeIfAbsent(new String(count), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
