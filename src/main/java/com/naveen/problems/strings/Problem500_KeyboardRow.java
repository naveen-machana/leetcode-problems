package com.naveen.problems.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem500_KeyboardRow {
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        int[] rowMap = {1, 2, 2, 1, 3, 1, 1, 1, 3, 1, 1, 1, 2, 2, 3, 3, 3, 3, 1, 3, 3, 2, 3, 2, 3, 2};
        for (String cur : words) {
            Set<Integer> rowsSeen = new HashSet<>();
            for (char c : cur.toCharArray()) {
                int rowIndex = -1;
                if (c >= 'a' && c <= 'z') rowIndex = c - 'a';
                else if (c >= 'A' && c <= 'Z') rowIndex = c - 'A';
                rowsSeen.add(rowMap[rowIndex]);
            }
            if (rowsSeen.size() == 1) res.add(cur);
        }
        return res.toArray(new String[0]);
    }
}
