package com.naveen.problems.stack;

import java.util.LinkedList;

public class Problem860_LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fivec = 0, tenc = 0;
        for (int x : bills) {
            if (x == 5) fivec++;
            else if (x == 10)  { fivec--; tenc++; }
            else if (tenc > 0) { fivec--; tenc--; }
            else fivec -= 3;
            if (fivec < 0) return false;
        }
        return true;
    }
}
