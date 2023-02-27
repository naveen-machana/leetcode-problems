package com.naveen.problems.arrays;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/powx-n/
// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
public class Problem50_PowerXN {
    public double myPow(double x, int n) {

        long nn = n < 0 ? -n : n;
        double res = power(x, nn);
        return n < 0 ? 1/res : res;
    }

    double power(double x, long nn) {
        if (nn == 0) return 1.0;
        if (nn % 2 == 1) return x * power(x, nn - 1);
        else return power(x, nn / 2) * power(x, nn / 2);
    }

    double power2(double x, long nn) {
        Map<Long, Double> map = new HashMap<>();
        map.put(0l, 1.0);
        for (long i = 1; i <= nn; i++) {
            double res = 0;
            if (i % 2 == 1) {
                res = x * map.get(i - 1);
            }
            else {
                res = map.get(i / 2) * map.get(i / 2);
            }
            map.put(i, res);
        }
        return map.get(nn);
    }
}
