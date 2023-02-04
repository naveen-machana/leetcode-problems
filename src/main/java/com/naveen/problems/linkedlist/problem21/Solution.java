package com.naveen.problems.linkedlist.problem21;

// https://leetcode.com/problems/merge-two-sorted-lists/
// 21. Merge Two Sorted Lists
// You are given the heads of two sorted linked lists list1 and list2.
//
// Merge the two lists in a one sorted list. The list should be made by splicing together
// the nodes of the first two lists.
//
// Return the head of the merged linked list.
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode();
        ListNode start = temp;
        ListNode a = list1, b = list2;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                ListNode anext = a.next;
                temp.next = a;
                temp = a;
                a = anext;
            }
            else {
                ListNode bnext = b.next;
                temp.next = b;
                temp = b;
                b = bnext;
            }
        }

        if (a != null) temp.next = a;
        if (b != null) temp.next = b;
        return start.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
