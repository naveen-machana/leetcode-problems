package com.naveen.problems.problem273;

import java.util.HashMap;
import java.util.Map;

public class IntegerToWord {
    static Map<Long, String> BELOW_TEN = new HashMap<>();
    static Map<Long, String> BELOW_TWENTY = new HashMap<>();
    static Map<Long, String> TENS = new HashMap<>();
    static {
        BELOW_TEN.put(0l, "");
        BELOW_TEN.put(1l, "One");
        BELOW_TEN.put(2l, "Two");
        BELOW_TEN.put(3l, "Three");
        BELOW_TEN.put(4l, "Four");
        BELOW_TEN.put(5l, "Five");
        BELOW_TEN.put(6l, "Six");
        BELOW_TEN.put(7l, "Seven");
        BELOW_TEN.put(8l, "Eight");
        BELOW_TEN.put(9l, "Nine");

        BELOW_TWENTY.put(10l, "Ten");
        BELOW_TWENTY.put(11l, "Eleven");
        BELOW_TWENTY.put(12l, "Twelve");
        BELOW_TWENTY.put(13l, "Thirteen");
        BELOW_TWENTY.put(14l, "Fourteen");
        BELOW_TWENTY.put(15l, "Fifteen");
        BELOW_TWENTY.put(16l, "Sixteen");
        BELOW_TWENTY.put(17l, "Seventeen");
        BELOW_TWENTY.put(18l, "Eighteen");
        BELOW_TWENTY.put(19l, "Nineteen");

        TENS.put(20l, "Twenty");
        TENS.put(30l, "Thirty");
        TENS.put(40l, "Forty");
        TENS.put(50l, "Fifty");
        TENS.put(60l, "Sixty");
        TENS.put(70l, "Seventy");
        TENS.put(80l, "Eighty");
        TENS.put(90l, "Ninety");
    }
    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        return convert(num).trim();
    }

    public static String convert(long num) {
        if (num == 0) return "";
        if (num < 10) return BELOW_TEN.get(num);
        if (num < 20) return BELOW_TWENTY.get(num);
        if (num < 100) return (TENS.get(num - num % 10) + " " + convert(num % 10)).trim();
        if (num < 1000) return (BELOW_TEN.get(num / 100) + " Hundred " + convert(num % 100)).trim();
        if (num < 1000_000) return (convert(num / 1000) + " Thousand " + convert(num % 1000)).trim();
        if (num < 1000_000_000) return (convert(num / 1000_000) + " Million " + convert(num % 1000_000)).trim();
        if (num < 1000_000_000_000l) return (convert(num / 1000_000_000) + " Billion " + convert(num % 1000_000_000)).trim();
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(50868));
    }
}
