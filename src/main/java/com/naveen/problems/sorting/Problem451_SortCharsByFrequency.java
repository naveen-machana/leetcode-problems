package com.naveen.problems.sorting;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem451_SortCharsByFrequency {
    public String frequencySort(String s) {
        var chars = s.toCharArray();
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : chars) {
            freq.merge(c, 1, (ov, nv) -> ov + nv);
        }
        List<Character> charsList = new ArrayList<>(freq.keySet());
        Collections.sort(charsList, (a, b) -> freq.get(b) - freq.get(a));
        StringBuilder res = new StringBuilder();
        for (var c : charsList) {
            for (int i = 0; i < freq.get(c); i++) {
                res.append(c);
            }
        }
        return res.toString();
    }
}
