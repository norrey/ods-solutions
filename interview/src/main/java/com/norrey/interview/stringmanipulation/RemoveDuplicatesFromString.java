package com.norrey.interview.stringmanipulation;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author nokumu
 */
/**
 *
 * @author nokumu
 */
public class RemoveDuplicatesFromString {

    /**
     * Brute force
     *
     * O(n^2)
     *
     * @param s
     * @return
     */
    private static String removeDuplicatesFromStringBruteForce(final String s) {
        if (s == null) {
            return s;
        }

        if (s.isEmpty()) {
            return s;
        }

        if (s.length() <= 1) {
            return s;
        }

        int length = s.length();

        char[] chars = s.toCharArray();
        String result = "";

        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (chars[i] == chars[j]) {
                    count++;
                }
            }

            if (count == 1) {
                result = result + chars[i];
            }
        }
        return result;
    }

    /**
     * IndexOf method
     *
     * O(n)
     *
     * @param s
     * @return
     */
    private static String removeDuplicatesIndexOf(final String s) {
        if (s == null) {
            return s;
        }

        if (s.isEmpty()) {
            return s;
        }

        if (s.length() <= 1) {
            return s;
        }

        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (result.indexOf(s.charAt(i)) < 0) {
                result = result + s.charAt(i);
            }
        }

        return result;
    }

    private static String hashing(String s) {
        if (s == null) {
            return s;
        }

        if (s.isEmpty()) {
            return s;
        }

        if (s.length() <= 1) {
            return s;
        }

        Set<Character> set = new LinkedHashSet<>();

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        String result = "";
        for (Character c : set) {
            result = result + c;
        }

        return result;

    }

    /**
     * Driver
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(removeDuplicatesIndexOf("qwqwqwqwqhhhrhehrhheerer"));
        System.out.println(removeDuplicatesFromStringBruteForce("qwqwqwqwqhhhrhehrhheerer"));
        System.out.println(hashing("qwqwqwqwqhhhrhehrhheerer"));
    }

}
