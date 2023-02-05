package com.naveen.problems.linkedlist.problem25;

import com.naveen.problems.linkedlist.ListNode;

// https://leetcode.com/problems/reverse-nodes-in-k-group/
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode reversed = head;
        while (reversed != null && count < k) {
            reversed = reversed.next;
            count++;
        }

        if (count == k) {
            reversed = reverseKGroup(reversed, k);

            while (count-- > 0) {
                ListNode next = head.next;
                head.next = reversed;
                reversed = head;
                head = next;
            }
            head = reversed;
        }

        return head;
    }
}
