package com.naveen.problems.linkedlist;

// https://leetcode.com/problems/reverse-linked-list/description/
// 206. Reverse Linked List
// Given the head of a singly linked list, reverse the list, and return the reversed list.
class Problem206_ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode res = null;

        while (temp != null) {
            ListNode next = temp.next;
            temp.next = res;
            res = temp;
            temp = next;
        }
        return res;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
