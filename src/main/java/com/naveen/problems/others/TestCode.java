package com.naveen.problems.others;

import java.util.*;

public class TestCode {
    public int maxNumberOfBalloons(String text) {
        int res = Integer.MAX_VALUE;
        String balloon = "balloon";
        Map<Character, Integer> bCounter = new HashMap<>();
        for (char c : balloon.toCharArray()) {
            bCounter.compute(c, (k, v) -> v != null ? v + 1 : 1);
        }
        Map<Character, Integer> txtCounter = new HashMap<>();
        for (char c : text.toCharArray()) {
            txtCounter.compute(c, (k, v) -> v != null ? v + 1 : 1);
        }
        for (char c : balloon.toCharArray()) {
            res = Math.min(res, txtCounter.get(c)/bCounter.get(c));
        }
        return res;
    }
}
