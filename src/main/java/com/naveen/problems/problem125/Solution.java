package com.naveen.problems.problem125;

public class Solution {
    public static boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        int st = 0, end = c.length - 1;

        while (st <= end) {
            if (!Character.isLetterOrDigit(c[st])) st++;
            else if (!Character.isLetterOrDigit(c[end])) end--;
            else if (Character.toLowerCase(c[st]) == Character.toLowerCase(c[end])) {
                st++;
                end--;
            }
            else return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("ab2a"));
    }
}
