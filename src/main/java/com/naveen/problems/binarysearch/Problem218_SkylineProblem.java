package com.naveen.problems.binarysearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/the-skyline-problem/description/
A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a
distance. Given the locations and heights of all the buildings, return the skyline formed by these buildings
collectively.

The geometric information of each building is given in the array buildings where
buildings[i] = [lefti, righti, heighti]:

lefti is the x coordinate of the left edge of the ith building.
righti is the x coordinate of the right edge of the ith building.
heighti is the height of the ith building.
You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form
 [[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal segment in the skyline except the last
 point in the list, which always has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost
  building ends. Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.

Note: There must be no consecutive horizontal lines of equal height in the output skyline. For instance,
[...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable; the three lines of height 5 should be merged into one in
the final output as such: [...,[2 3],[4 5],[12 7],...]
* */
public class Problem218_SkylineProblem {
    public static void main(String[] args) {
        Problem218_SkylineProblem sol = new Problem218_SkylineProblem();
        int[][] b = {{2, 9, 10},
                {3, 7, 15}};
        System.out.println(sol.getSkyline(b));

    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        LinkedList<int[]> res = skyline(buildings, 0, buildings.length - 1);
        List<List<Integer>> fres = new ArrayList<>();
        for (int[] e : res) fres.add(List.of(e[0], e[1]));
        return fres;
    }

    public LinkedList<int[]> skyline(int[][] b, int st, int end) {
        LinkedList<int[]> res = new LinkedList<>();
        if (st > end) return res;
        if (st == end) {
            res.add(new int[] {b[st][0], b[st][2]} );
            res.add(new int[] {b[st][1], 0});
            return res;
        }
        int m = (st + end)/2;
        LinkedList<int[]> left = skyline(b, st, m);
        LinkedList<int[]> right = skyline(b, m + 1, end);
        int h1 = 0, h2 = 0;
        while (!left.isEmpty() || !right.isEmpty()) {
            int x1 = 0, x2 = 0;
            x1 = left.isEmpty() ? Integer.MAX_VALUE : left.peekFirst()[0];
            x2 = right.isEmpty() ? Integer.MAX_VALUE : right.peekFirst()[0];
            int x = 0;
            if (x1 < x2) {
                x = x1;
                h1 = left.pollFirst()[1];
            }
            else if (x1 > x2) {
                x = x2;
                h2 = right.pollFirst()[1];
            }
            else {
                x = x1;
                h1 = left.isEmpty() ? Integer.MIN_VALUE : left.pollFirst()[1];
                h2 = right.isEmpty() ? Integer.MIN_VALUE : right.pollFirst()[1];
            }

            int h = Math.max(h1, h2);
            if (res.isEmpty() || res.peekLast()[1] != h) {
                res.add(new int[]{x, h});
            }
        }
        return res;
    }
}
