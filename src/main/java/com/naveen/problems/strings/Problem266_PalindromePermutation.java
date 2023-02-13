package com.naveen.problems.strings;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.ca/2016-08-22-266-Palindrome-Permutation/
// 266 - Palindrome Permutation
//  Given a string, determine if a permutation of the string could form a palindrome.
//
// For example,
// "code" -> False, "aab" -> True, "carerac" -> True.
public class Problem266_PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) set.remove(c);
            else set.add(c);
        }
        return set.size() < 2;
    }
}
