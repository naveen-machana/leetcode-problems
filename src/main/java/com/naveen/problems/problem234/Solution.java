package com.naveen.problems.problem234;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // if list length is odd, then let first half contain one extra node
        if (fast != null) slow = slow.next;
        slow = reverse(slow);

        ListNode temp = head;
        while (temp != null && slow != null) {
            if (temp.val != slow.val) return false;
            temp = temp.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode temp = head, reversed = null;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = reversed;
            reversed = temp;
            temp = next;
        }
        return reversed;
    }
}