package com.naveen.problems.strings;

import java.util.HashMap;
import java.util.Map;

public class Problem13_RomanToInteger {
    static Map<Character, Integer> charToInt = new HashMap<>();
    static {
        charToInt.put('I', 1);
        charToInt.put('V', 5);
        charToInt.put('X', 10);
        charToInt.put('L', 50);
        charToInt.put('C', 100);
        charToInt.put('D', 500);
        charToInt.put('M', 1000);
    }
    public static int romanToInt(String s) {
        s = s.replace("IV", "IIII")
                .replace("IX", "VIIII")
                .replace("XL", "XXXX")
                .replace("XC", "LXXXX")
                .replace("CD", "CCCC")
                .replace("CM", "DCCCC");

        int res = 0;
        for (char c : s.toCharArray()) {
            res += charToInt.get(c);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
}
