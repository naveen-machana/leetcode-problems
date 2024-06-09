package com.naveen.problems.arrays;

import java.util.*;

public class Problem1496_PathCrossing {
    public boolean isPathCrossing(String path) {
        Map<Character, List<Integer>> dir = new HashMap<>();
        dir.put('N', List.of(1, 0));
        dir.put('E', List.of(0, 1));
        dir.put('S', List.of(-1, 0));
        dir.put('W', List.of(0, -1));

        Set<List<Integer>> set = new HashSet<>();
        set.add(List.of(0, 0));
        int x = 0, y = 0;
        for (char c : path.toCharArray()) {
            List<Integer> add = dir.get(c);
            x += add.get(0);
            y += add.get(1);
            List<Integer> next = List.of(x, y);
            if (set.contains(next)) return true;
            set.add(next);
        }
        return false;
    }
}
