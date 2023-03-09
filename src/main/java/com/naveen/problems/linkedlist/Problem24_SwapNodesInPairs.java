package com.naveen.problems.linkedlist;

/*
* https://leetcode.com/problems/swap-nodes-in-pairs/
* Given a linked list, swap every two adjacent nodes and return its head.
* You must solve the problem without modifying the values in the list's nodes
* (i.e., only nodes themselves may be changed.)
* Input: head = [1,2,3,4]
* Output: [2,1,4,3]
* */
public class Problem24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        int k = 2;
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        dummy.next = head;

        while (temp != null) {
            for ()
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode temp = node;
        ListNode head = null;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = head;
            head = temp;
            temp = next;
        }
        return head;
    }
}
