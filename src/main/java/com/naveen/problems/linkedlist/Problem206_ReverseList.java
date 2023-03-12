package com.naveen.problems.linkedlist;

// https://leetcode.com/problems/reverse-linked-list/description/
// 206. Reverse Linked List
// Given the head of a singly linked list, reverse the list, and return the reversed list.
class Problem206_ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode tail = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = tail;
            tail = temp;
            temp = next;
        }
        return tail;
    }

}
