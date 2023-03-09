package com.naveen.problems.linkedlist;

// https://leetcode.com/problems/add-two-numbers/
// 2. Add Two Numbers
// You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order, and each of their nodes contains a single digit.
// Add the two numbers and return the sum as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
public class Problem2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode temp = new ListNode();
        ListNode start = temp;
        while (l1 != null || l2 != null || sum != 0) {
            sum += l1 == null ? 0 : l1.val;
            sum += l2 == null ? 0 : l2.val;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            sum = sum / 10;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }

        return start.next;
    }
}
