package com.naveen.problems.twopointer;

public class Problem680_ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            if (chars[i] != chars[j]) {
                if (isPalindrome(chars, i + 1, j) || isPalindrome(chars, i, j - 1)) return true;
                else return false;
            }
            i++; j--;
        }
        return true;
    }

    private boolean isPalindrome(char[] chars, int st, int end) {
        while (st <= end) {
            if (chars[st] != chars[end]) return false;
            st++; end --;
        }
        return true;
    }
}
