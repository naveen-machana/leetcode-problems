package com.naveen.problems.twopointer;

import java.util.HashMap;
import java.util.Map;

/*
* Given a string s, find the length of the longest substring without repeating characters.
* Input: s = "abcabcbb"
* Output: 3
* Explanation: The answer is "abc", with the length of 3.
* */
public class Problem3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Problem3_LongestSubstringWithoutRepeatingCharacters sol = new Problem3_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(sol.lengthOfLongestSubstring("abba"));
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int st = 0, end = 0, max = 0, counter = 0;
        while (end < s.length()) {
            char c = s.charAt(end++);
            int prev = map.getOrDefault(c, 0);
            if (prev > 0) counter++;
            map.put(c, prev + 1);
            while (counter > 0) {
                char c2 = s.charAt(st++);
                int pc2 = map.get(c2);
                map.put(c2, pc2 - 1);
                if (map.get(c2) == 1) counter--;
            }
            max = Math.max(max, end - st);
        }
        return max;
    }
}
