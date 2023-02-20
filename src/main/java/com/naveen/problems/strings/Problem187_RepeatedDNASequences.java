package com.naveen.problems.strings;

import java.util.*;

// https://leetcode.com/problems/repeated-dna-sequences/
// The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
//
// For example, "ACGAATTCCG" is a DNA sequence.
// When studying DNA, it is useful to identify repeated sequences within the DNA.
//
// Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings)
// that occur more than once in a DNA molecule. You may return the answer in any order
// Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
// Output: ["AAAAACCCCC","CCCCCAAAAA"]
// Input: s = "AAAAAAAAAAAAA"
// Output: ["AAAAAAAAAA"]
public class Problem187_RepeatedDNASequences {
    public static void main(String[] args) {
        Problem187_RepeatedDNASequences sol = new Problem187_RepeatedDNASequences();
        sol.findRepeatedDnaSequences("AAAAAAAAAAAAA");
    }
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(), dup = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String temp = s.substring(i, i + 10);
            if (!seen.add(temp)) dup.add(temp);
        }
        return new ArrayList<>(dup);
    }
}
