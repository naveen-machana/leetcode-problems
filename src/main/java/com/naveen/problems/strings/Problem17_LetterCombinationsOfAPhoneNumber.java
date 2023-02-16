package com.naveen.problems.strings;

import java.util.*;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number
// could represent. Return the answer in any order.
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
public class Problem17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Problem17_LetterCombinationsOfAPhoneNumber s = new Problem17_LetterCombinationsOfAPhoneNumber();
        System.out.println(s.letterCombinations("234"));
    }
    public List<String>  letterCombinations(String digits) {

        Map<Character, Set<Character>> map = new HashMap<>();
        map.put('2', Set.of('a', 'b', 'c'));
        map.put('3', Set.of('d', 'e', 'f'));
        map.put('4', Set.of('g', 'h', 'i'));
        map.put('5', Set.of('j', 'k', 'l'));
        map.put('6', Set.of('m', 'n', 'o'));
        map.put('7', Set.of('p', 'q', 'r', 's'));
        map.put('8', Set.of('t', 'u', 'v'));
        map.put('9', Set.of('w', 'x', 'y', 'z'));
        List<String> res = new ArrayList<>();
        int n = digits.length();
        if (n < 1) return res;
        char[] chars = digits.toCharArray();
        combinations(chars, 0, n, res, map, "");
        return res;
    }

    private void combinations(char[] chars, int index, int n, List<String> res, Map<Character, Set<Character>> map, String cur) {

        if (index == n) {
            res.add(cur);
            return;
        }

        for (char c : map.get(chars[index])) {
            combinations(chars, index + 1, n, res, map, cur + c);
        }
    }
}
