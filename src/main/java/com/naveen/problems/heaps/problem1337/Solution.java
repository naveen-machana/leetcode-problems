package com.naveen.problems.heaps.problem1337;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Counter> countsList = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            countsList.add(new Counter(i));
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) break;
                countsList.get(i).count++;
            }
        }

        Collections.sort(countsList);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = countsList.get(i).rowIndex;
        }

        return res;
    }

    private static class Counter implements Comparable<Counter> {
        int count;
        int rowIndex;
        public Counter(int rowIndex) {
            this.rowIndex = rowIndex;
        }

        @Override
        public int compareTo(Counter o) {
            if (this.count != o.count) {
                return count - o.count;
            }
            return rowIndex - o.rowIndex;
        }
    }
}
