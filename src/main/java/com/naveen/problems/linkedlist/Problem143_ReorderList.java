package com.naveen.problems.linkedlist;

/*
* https://leetcode.com/problems/reorder-list/
* You are given the head of a singly linked-list. The list can be represented as:
* L0 → L1 → … → Ln - 1 → Ln
* Reorder the list to be on the following form: L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
* You may not modify the values in the list's nodes. Only nodes themselves may be changed.
* Input: head = [1,2,3,4,5] Output: [1,5,2,4,3]
* */
public class Problem143_ReorderList {
    public void reorderList(ListNode head) {
        ListNode f = head, s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        ListNode prev = null, rev = s.next;
        s.next = null;
        while (rev != null) {
            ListNode temp = rev.next;
            rev.next = prev;
            prev = rev;
            rev = temp;
        }
        ListNode dummy = new ListNode(), tail = dummy;
        ListNode h1 = head, h2 = prev;
        while (h1 != null && h2 != null) {
            tail.next = h1;
            h1 = h1.next;
            tail = tail.next;

            tail.next = h2;
            h2 = h2.next;
            tail = tail.next;
        }
        if (h1 != null) tail.next = h1;
        if (h2 != null) tail.next = h2;
    }
}
