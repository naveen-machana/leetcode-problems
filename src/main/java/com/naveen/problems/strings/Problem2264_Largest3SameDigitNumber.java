package com.naveen.problems.strings;

public class Problem2264_Largest3SameDigitNumber {
    public String largestGoodInteger(String num) {
        String res = "";
        char[] numChars = num.toCharArray();
        for (int i = 1; i < num.length() - 1; i++) {
            String cur = "";
            if (numChars[i] == numChars[i - 1] && numChars[i] == numChars[i + 1])
                cur = "" + numChars[i] + numChars[i] + numChars[i];
            if (res.compareTo(cur) < 0) res = cur;
        }
        return res;
    }
}
