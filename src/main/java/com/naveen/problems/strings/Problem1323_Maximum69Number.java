package com.naveen.problems.strings;

public class Problem1323_Maximum69Number {
    public int maximum69Number (int num) {
        return Integer.valueOf(("" + num).replaceFirst("6", "9"));
    }
}
