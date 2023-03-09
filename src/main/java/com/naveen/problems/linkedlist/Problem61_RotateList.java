package com.naveen.problems.linkedlist;

import com.naveen.problems.linkedlist.ListNode;

// https://leetcode.com/problems/rotate-list/description/
public class Problem61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int count = 1;
        ListNode fast = head;
        for(; fast.next != null; count++, fast = fast.next);
        ListNode slow = head;
        for (int i = count - k % count; i > 1; i--) slow = slow.next;

        ListNode newhead = slow.next;
        slow.next = null;
        fast.next = head;
        head = newhead;
        return head;
    }
}
