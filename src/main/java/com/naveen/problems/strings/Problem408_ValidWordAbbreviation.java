package com.naveen.problems.strings;

// https://leetcode.ca/2017-01-11-408-Valid-Word-Abbreviation/
// Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
//
//A string such as "word" contains only the following valid abbreviations:
//
//["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
//Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid
// abbreviation of "word".
//
//Note:
//Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
//
//Example 1:
//Given s = "internationalization", abbr = "i12iz4n":
//
//Return true.
public class Problem408_ValidWordAbbreviation {
    boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0, m = word.length(), n = abbr.length();
        while (i < m && j < n) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++; j++; continue;
            }
            if (abbr.charAt(j) < '0' || abbr.charAt(j) > '9')
                return false;
            int start = j;
            while (j < n && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') j++;
            int ni = Integer.valueOf(abbr.substring(start, j));
            i += ni;
        }
        return i == m && j == n;
    }
}
