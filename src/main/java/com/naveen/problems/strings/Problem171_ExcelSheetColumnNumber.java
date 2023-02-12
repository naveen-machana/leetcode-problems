package com.naveen.problems.strings;

// https://leetcode.com/problems/excel-sheet-column-number/
// 171. Excel Sheet Column Number
// Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
// A -> 1
// B -> 2
// C -> 3
// ...
// Z -> 26
// AA -> 27
// AB -> 28
// ...
// ZY -> 701 = 25 + 26 * 26
// ZZ -> 702
// AAA -> 703 -> 1 + 26 + 26 * 26 * 1
public class Problem171_ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        StringBuilder sb = new StringBuilder(columnTitle);
        sb.reverse();
        int i = 0, j = 1;
        while (i < sb.length()) {
            res += (sb.charAt(i++) - 'A' + 1) * j;
            j = j * 26;
        }
        return res;
    }
}
