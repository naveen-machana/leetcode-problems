package com.naveen.problems.strings;

public class Problem157_Read4 {

    private int read4(char[] buf) {
        return 4;
    }

    public int read(char[] buf, int n) {
        int ind = 0;
        while (ind < n) {
            char[] cache = new char[4];
            int cn = read4(cache);

            int i = 0;
            while (cn > 0 && ind < n) {
                buf[ind++] = cache[i++];
                cn --;
            }
        }
        return ind;
    }
}
