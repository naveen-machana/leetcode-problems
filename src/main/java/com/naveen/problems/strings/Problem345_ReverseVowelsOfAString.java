package com.naveen.problems.strings;

import java.util.Set;

// https://leetcode.com/problems/reverse-vowels-of-a-string/
// Given a string s, reverse only all the vowels in the string and return it.
//
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once
// Input: s = "hello"
// Output: "holle"
// Input: s = "leetcode"
// Output: "leotcede"
public class Problem345_ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] chars = s.toCharArray();
        int st = 0, end = s.length() - 1;
        while (st < end) {
            if (!vowels.contains(chars[st])) st++;
            else if (!vowels.contains(chars[end])) end--;
            else {
                char t = chars[st];
                chars[st] = chars[end];
                chars[end] = t;
                st++; end--;
            }
        }
        return new String(chars);
    }
}
