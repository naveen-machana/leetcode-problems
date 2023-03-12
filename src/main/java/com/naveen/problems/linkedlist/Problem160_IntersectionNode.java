package com.naveen.problems.linkedlist;

// https://leetcode.com/problems/intersection-of-two-linked-lists/
// 160. Intersection of Two Linked Lists
// Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
// If the two linked lists have no intersection at all, return null.
//
// For example, the following two linked lists begin to intersect at node c1:
public class Problem160_IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int sizea = size(headA);
        int sizeb = size(headB);
        int diff = Math.abs(sizea - sizeb);
        if (sizea > sizeb)
            return intersectionNode(headA, headB, diff);
        else
            return intersectionNode(headB, headA, diff);
    }

    ListNode intersectionNode(ListNode one, ListNode two, int diff) {
        while (diff > 0) {
            one = one.next; diff--;
        }
        while (one != null && one != two) {
            one = one.next;
            two = two.next;
        }

        return one != null && one == two ? one : null;
    }

    int size(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
