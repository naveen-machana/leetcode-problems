package com.naveen.problems.linkedlist;

/*
* https://leetcode.com/problems/middle-of-the-linked-list/
* Given the head of a singly linked list, return the middle node of the linked list.
* If there are two middle nodes, return the second middle node.
* */
public class Problem876_MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode f = head, s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        return s;
    }
}
