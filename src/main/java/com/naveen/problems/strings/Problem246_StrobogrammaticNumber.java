package com.naveen.problems.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// https://leetcode.ca/all/246.html
// 246. Strobogrammatic Number
// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
// 69 - true, 88 - true, 962 - false
public class Problem246_StrobogrammaticNumber {
    public boolean isStrobogrammaticNumber(String number) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');

        int st = 0, end = number.length() - 1;
        while (st <= end) {
            char stc = number.charAt(st);
            if (map.containsKey(stc) && map.get(stc) == number.charAt(end)) {
                st++; end--;
            }
            else
                return false;
        }

        return true;
    }
}
