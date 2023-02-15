package com.naveen.problems.strings;

import java.util.Arrays;

// https://leetcode.com/problems/zigzag-conversion/
// 6. Zigzag Conversion
// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
// (you may want to display this pattern in a fixed font for better legibility)
// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"
//
// Input: s = "PAYPALISHIRING", numRows = 4
// Output: "PINALSIGYAHRPI"
// Explanation:
// P     I    N
// A   L S  I G
// Y A   H R
// P     I
public class Problem6_ZigzagConversion {

    public String convert2(String s, int numRows) {
        char[] c = s.toCharArray();
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) builders[i] = new StringBuilder();

        int cind = 0, n = s.length();
        while (cind < n) {
            for (int bindex = 0; cind < n && bindex < numRows; bindex++)
                builders[bindex].append(c[cind++]);
            for (int bindex = numRows - 2; bindex >= 1 && cind < n; bindex--)
                builders[bindex].append(c[cind++]);
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder temp : builders) res.append(temp);
        return res.toString();
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        int n = s.length();
        int sections = (int) Math.ceil(n/(2 * numRows - 2.0));
        int numCols = sections * (numRows - 1);
        char[][] matrix = new char[numRows][numCols];
        for (int i = 0; i < numRows; i++) Arrays.fill(matrix[i], ' ');

        int currIndex = 0, curRow = 0, curCol = 0;
        while (currIndex < n) {
            while (curRow < numRows && currIndex < n) {
                matrix[curRow][curCol] = s.charAt(currIndex);
                currIndex++;
                curRow++;
            }

            curRow -= 2;
            curCol++;

            while (currIndex < n && curRow > 0 && curCol < numCols) {
                matrix[curRow][curCol] = s.charAt(currIndex);
                currIndex++;
                curCol++;
                curRow--;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (matrix[i][j] != ' ')
                    res.append(matrix[i][j]);
            }
        }

        return res.toString();
    }


}
