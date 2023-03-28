package com.naveen.problems.math;

public class Problem7_ReverseInteger {
    public static void main(String[] args) {
        Problem7_ReverseInteger sol = new Problem7_ReverseInteger();
        System.out.println(sol.reverse(123));
    }
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            int newRes = res * 10 + temp;
            if ((newRes - temp)/10 != res) return 0;
            res = newRes;
            x = x/10;
        }
        return res;
    }
}
