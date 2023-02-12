package com.naveen.problems.strings;

// https://leetcode.com/problems/excel-sheet-column-title/
// 168. Excel Sheet Column Title
// Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
// A -> 1
// B -> 2
// C -> 3
// ...
// Z -> 26
// AA -> 27
// AB -> 28
// ...
// AZ -> 52
// BA -> 53
// ZY -> 701
// ZZ -> 702
// AAA -> 703
// Input: columnNumber = 701 =>> 701/26 =
// Output: "ZY"
public class Problem168_ExcelSheetColumnTitle {
    public static void main(String[] args) {
        String res = convertToTitle(52);
        System.out.println(res);
    }
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)('A' + n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
