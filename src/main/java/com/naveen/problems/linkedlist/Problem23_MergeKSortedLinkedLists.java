package com.naveen.problems.linkedlist;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/merge-k-sorted-lists/
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
* */
public class Problem23_MergeKSortedLinkedLists {
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode start = new ListNode();
        ListNode tail = start;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++)
            if (lists[i] != null)
                pq.offer(lists[i]);
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            tail.next = temp;
            tail = tail.next;
            if (temp.next != null) pq.offer(temp.next);
        }
        return  start.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int st, int end) {
        if (st > end) return null;
        if (st == end) return lists[st];
        int m = (st + end)/2;
        ListNode left = mergeSort(lists, st, m);
        ListNode right = mergeSort(lists, m + 1, end);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode start = new ListNode();
        ListNode tail = start;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            }
            else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if (a != null) tail.next = a;
        if (b != null) tail.next = b;
        return start.next;
    }
}
