package com.naveen.blind75.arrays;

import java.util.HashSet;
import java.util.Set;

public class Problem217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for (int n : nums) {
            if (!elements.add(n)) {
                return false;
            }
        }
        return true;
    }
}
