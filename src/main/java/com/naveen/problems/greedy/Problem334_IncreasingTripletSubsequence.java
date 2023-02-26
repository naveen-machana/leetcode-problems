package com.naveen.problems.greedy;

import java.util.PriorityQueue;

/*
[1,0,2,0,-1,3]
* */
public class Problem334_IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] a) {
        int big = Integer.MAX_VALUE, small = Integer.MAX_VALUE;
        for (int n : a) {
            if (n <= small) small = n;
            else if (n <= big) big = n;
            else return true;
        }
        return false;
    }
}
