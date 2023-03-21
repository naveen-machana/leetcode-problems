package com.naveen.problems.strings;

import java.util.LinkedList;
import java.util.List;

/*
* https://leetcode.ca/all/271.html
* Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is
* decoded back to the original list of strings.
* Note:

The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized
* enough to work on any possible characters.
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
* */
public class Problem271_EncodeAndDecodeStrings {
    public static void main(String[] args) {
        List<String> list = List.of("one", "2#abcd", "%asdfasdf123412345*");
        String encoded = encode(list);
        System.out.println(decode(encoded));
    }
    static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs)
            sb.append(s.length()).append("#").append(s);
        return sb.toString();
    }

    static List<String> decode(String s) {
        LinkedList<String> res = new LinkedList<>();
        if (s.length() == 0) return res;
        while (!s.isEmpty()) {
            int index = s.indexOf("#");
            int l = Integer.valueOf(s.substring(0, index));
            res.addLast(s.substring(index + 1, index + l + 1));
            s = s.substring(index + l + 1);
        }
        return res;
    }
}
