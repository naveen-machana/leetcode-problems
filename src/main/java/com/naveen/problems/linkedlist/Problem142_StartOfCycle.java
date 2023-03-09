package com.naveen.problems.linkedlist;

import com.naveen.problems.linkedlist.ListNode;

// https://leetcode.com/problems/linked-list-cycle-ii/
// 142. Linked List Cycle II
// Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
// following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is
// connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
//
// Do not modify the linked list.
public class Problem142_StartOfCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode f = head, s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;

            if (f == s) {
                s = head;
                while (s != f) {
                    f = f.next;
                    s = s.next;
                }
                return s;
            }
        }
        return null;
    }
}
