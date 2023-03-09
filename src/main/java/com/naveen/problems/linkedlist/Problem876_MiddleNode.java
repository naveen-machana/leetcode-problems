package com.naveen.problems.linkedlist;

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
