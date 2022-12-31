package com.naveen.problems.problem125;

public class Solution {
    public static boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        int st = 0, end = c.length - 1;

        while (st < end) {
            while (st < end && !Character.isAlphabetic(c[st]) && !Character.isDigit(c[st])) st++;
            while (st < end && !Character.isAlphabetic(c[end]) && !Character.isDigit(c[end])) end--;
            if (st <= end && Character.toLowerCase(c[st]) == Character.toLowerCase(c[end])) {
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
