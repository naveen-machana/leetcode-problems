package com.naveen.problems.linkedlist;

import com.naveen.problems.linkedlist.ListNode;

// https://leetcode.com/problems/linked-list-cycle/
// Given head, the head of a linked list, determine if the linked list has a cycle in it.
//
// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
// following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
// is connected to. Note that pos is not passed as a parameter.
//
// Return true if there is a cycle in the linked list. Otherwise, return false.
public class Problem141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode f = head, s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;

            if (f == s) return true;
        }
        return false;
    }
}
