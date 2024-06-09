package com.naveen.problems.others;

import java.util.*;

public class TestCode {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> fwd = new HashMap<>();
        Map<String, Character> rev = new HashMap<>();
        char[] chars = pattern.toCharArray();
        String[] strs = s.split(" ");
        if (chars.length != strs.length) return false;
        for (int i = 0; i < chars.length; i++) {
            if ((fwd.containsKey(chars[i]) && !fwd.get(chars[i]).equals(strs[i]))
                    || (rev.containsKey(strs[i]) && !rev.get(strs[i]).equals(chars[i]))) {
                return false;
            }
            fwd.put(chars[i], strs[i]);
            rev.put(strs[i], chars[i]);
        }
        return true;
    }
}
