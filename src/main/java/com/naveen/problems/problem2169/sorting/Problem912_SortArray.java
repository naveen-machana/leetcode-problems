package com.naveen.problems.problem2169.sorting;

/*
* https://leetcode.com/problems/sort-an-array/
* */
public class Problem912_SortArray {
    public static void main(String[] args) {
        Problem912_SortArray sol = new Problem912_SortArray();
        int[] a = {5,2,3,1};
        sol.sortArray(a);
    }
    public int[] sortArray(int[] nums) {
        qsort(nums, 0, nums.length - 1);
        return nums;
    }

    private void qsort(int[] a, int st, int end) {
        if (st >= end) return;
        int p = partition(a, st, end);
        qsort(a, st, p - 1);
        qsort(a, p + 1, end);
    }

    private int partition(int[] a, int st, int end) {
        int pivot = end, i = st - 1, j = st;
        for (; j < end; j++) {
            if (a[j] < a[pivot]) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, end);
        return i + 1;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
