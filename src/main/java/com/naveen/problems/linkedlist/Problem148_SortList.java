package com.naveen.problems.linkedlist;

/*
* https://leetcode.com/problems/sort-list/
* Given the head of a linked list, return the list after sorting it in ascending order.
* */
public class Problem148_SortList {
    public static void main(String[] args) {
        ListNode four = new ListNode(4);
        ListNode two = new ListNode(2);
        ListNode one = new ListNode(1);
        ListNode three = new ListNode(3);
        four.next = two;
        two.next = one;
        one.next = three;
        Problem148_SortList sol = new Problem148_SortList();
        sol.sortList(four);
    }
    public ListNode sortList(ListNode head) {
        return sort(head);
    }

    private ListNode sort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head, slow = head, temp = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            temp = slow;
            slow = slow.next;
        }

        temp.next = null;
        ListNode left = sort(head);
        ListNode right = sort(slow);
        return merge(left, right);
    }

    private ListNode merge(ListNode one, ListNode two) {
        if (one == null) return two;
        if (two == null) return one;
        ListNode dummyStart = new ListNode();
        ListNode dummyTail = dummyStart;
        while (one != null && two != null) {
            if (one.val <= two.val) {
                dummyTail.next = one;
                one = one.next;
            }
            else {
                dummyTail.next = two;
                two = two.next;
            }
            dummyTail = dummyTail.next;
        }

        if (one != null) dummyTail.next = one;
        if (two != null) dummyTail.next = two;
        return dummyStart.next;
    }
}
