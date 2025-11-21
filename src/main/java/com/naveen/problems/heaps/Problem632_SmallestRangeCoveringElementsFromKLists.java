package com.naveen.problems.heaps;

import java.util.ArrayList;
import java.util.List;

public class Problem632_SmallestRangeCoveringElementsFromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        Element[] pointers = new Element[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            pointers[i] = new Element(nums.get(i).get(0), i, 0);
        }

        int res = []
    }

    private List<Element> findMinMax(Element[] pointers) {
        List<Element> minMax = new ArrayList<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        
        for (Element element : pointers) {
            if (element.value < min) {
                min = element.value;
                minIndex = element.arrayIndex;
            }
            else if(element.value > max) {
                max =
            }
        }
    }

    private static class Element {
        int arrayIndex;
        int subArrayIndex;
        int value;
        public Element(int value, int arrayIndex, int subArrayIndex) {
            this.arrayIndex = arrayIndex;
            this.value = value;
            this.subArrayIndex = subArrayIndex;
        }
    }
}
