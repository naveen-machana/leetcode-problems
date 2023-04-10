package com.naveen.problems.backtracking;

import java.util.*;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number
// could represent. Return the answer in any order.
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
public class Problem17_LetterCombinationsOfAPhoneNumber {
    private static Map<Character, Set<Character>> map = new HashMap<>();
    static {
        map.put('2', Set.of('a', 'b', 'c'));
        map.put('3', Set.of('d', 'e', 'f'));
        map.put('4', Set.of('g', 'h', 'i'));
        map.put('5', Set.of('j', 'k', 'l'));
        map.put('6', Set.of('m', 'n', 'o'));
        map.put('7', Set.of('p', 'q', 'r', 's'));
        map.put('8', Set.of('t', 'u', 'v'));
        map.put('9', Set.of('w', 'x', 'y', 'z'));
    }

    public List<String>  letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        combinations(digits, res, 0, "");
        return res;
    }

    private void combinations(String digits, List<String> res, int cindex, String cur) {
        if (cindex == digits.length()) { res.add(cur); return; }
        for (char c : map.get(digits.charAt(cindex))) {
            combinations(digits, res, cindex + 1, cur + c);
        }
    }
}
