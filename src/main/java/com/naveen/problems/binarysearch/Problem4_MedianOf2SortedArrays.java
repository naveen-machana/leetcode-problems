package com.naveen.problems.binarysearch;

public class Problem4_MedianOf2SortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length, y = nums2.length;
        if (x > y) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int l = 0, h = x;
        while (l <= h) {
            int partitionx = (l + h)/2;
            int partitiony = (x + y + 1)/2 - partitionx;

            int maxx = partitionx == 0 ? Integer.MIN_VALUE : nums1[partitionx - 1];
            int minx = partitionx == x ? Integer.MAX_VALUE : nums1[partitionx];
            int maxy = partitiony == 0 ? Integer.MIN_VALUE : nums2[partitiony - 1];
            int miny = partitiony == y ? Integer.MAX_VALUE : nums2[partitiony];

            if (maxx <= miny && maxy <= minx) {
                if ((x + y) % 2 == 0) {
                    return ((double)(Math.max(maxx, maxy) + Math.min(minx, miny)))/2;
                }
                else {
                    return ((double)Math.max(maxx, maxy));
                }
            }
            else if (maxx > miny) {
                h = partitionx - 1;
            }
            else {
                l = partitionx + 1;
            }
        }

        throw new IllegalArgumentException("arrays are not sorted");
    }
}
