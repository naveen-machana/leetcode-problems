package com.naveen.problems.linkedlist;

// https://leetcode.com/problems/merge-two-sorted-lists/
// 21. Merge Two Sorted Lists
// You are given the heads of two sorted linked lists list1 and list2.
//
// Merge the two lists in a one sorted list. The list should be made by splicing together
// the nodes of the first two lists.
//
// Return the head of the merged linked list.
public class Problem21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
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
