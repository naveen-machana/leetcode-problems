package com.naveen.problems.problem12;

public class IntegerToRoman {
    public static String[] BELOW_TENS = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    public static String[] TENS = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    public static String[] HUNDREDS = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    public static String[] THOUSANDS = {"", "M", "MM", "MMM"};

    public static String intToRoman(int num) {
        if (num == 0) return "";
        return convert(num);
    }

    public static String convert(int num) {
        if (num == 0) return "";
        if (num < 10) return BELOW_TENS[num];
        if (num < 100) return TENS[num / 10] + convert(num % 10);
        if (num < 1000) return HUNDREDS[num / 100] + convert(num % 100);
        if (num < 4000) return THOUSANDS[num / 1000] + convert(num % 1000);
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        System.out.println(convert(3999));
    }
}
