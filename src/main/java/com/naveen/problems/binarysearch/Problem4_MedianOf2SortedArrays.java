package com.naveen.problems.binarysearch;

public class Problem4_MedianOf2SortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length, y = nums2.length;
        if (x > y) return findMedianSortedArrays(nums2, nums1);
        int l = 0, r = x;
        while (l <= r) {
            int px = (l + r)/2;
            int py = (x + y + 1)/2 - px;
            int maxx = px == 0 ? Integer.MIN_VALUE : nums1[px - 1];
            int minx = px == x ? Integer.MAX_VALUE : nums1[px];
            int maxy = py == 0 ? Integer.MIN_VALUE : nums2[py - 1];
            int miny = py == y ? Integer.MAX_VALUE : nums2[py];
            if (maxx <= miny && maxy <= minx) {
                if ((x + y) % 2 == 0) return ((double)(Math.max(maxx, maxy) + Math.min(minx, miny)))/2;
                else return Math.max(maxx, maxy);
            }
            else if (maxx > miny) r = px - 1;
            else l = px + 1;
        }
        throw new IllegalArgumentException("not sorted");
    }
}
