package com.naveen.problems.linkedlist;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * Given the head of a singly linked list, return true if it is a palindromeor false otherwise.
 */
class Problem234_Palindrome {

    public boolean isPalindrome(ListNode head) {
        ListNode f = head, s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        if (f != null) s = s.next;

        ListNode two = reversed(s);
        ListNode one = head;
        while (one != null && two != null) {
            if (one.val != two.val) return false;
            else {
                one = one.next;
                two = two.next;
            }
        }

        return true;
    }

    ListNode reversed(ListNode head) {
        ListNode temp = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }
}