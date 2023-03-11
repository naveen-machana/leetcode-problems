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
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        ListNode cur = head, prev = dummy;
        while (cur != null && cur.next != null) {
            prev.next = cur.next;
            cur.next = prev.next.next;
            prev.next.next = cur;
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
