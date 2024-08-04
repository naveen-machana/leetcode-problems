package com.naveen.problems.twopointer;

public class Problem125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int st = 0, end = chars.length - 1;

        while (st < end) {
            while (st < end && !Character.isLetterOrDigit(chars[st])) st++;
            while (st < end && !Character.isLetterOrDigit(chars[end])) end--;
            if (st < end && Character.toLowerCase(chars[st]) != Character.toLowerCase(chars[end])) {
                return false;
            }
            st++; end--;
        }
        return true;
    }
}
