package com.norrey.interview.stringmanipulation;

import java.util.Arrays;

/**
 * Find the maximum occuring character
 *
 * @author nokumu
 */
public class MaximumOccuringCharacter {

    private static Character maximum(final String str) {

        char[] charArray = str.toCharArray();

        Arrays.sort(charArray);
        int count = 1;
        char theChar = charArray[0];
        int numOccurences = 1;

        for (int i = 0; i < str.length() - 1; i++) {
            if (charArray[i] == charArray[i + 1]) {
                count++;
                if (count > numOccurences) {
                    System.out.println(count + " char: " + charArray[i]);
                    theChar = charArray[i];
                }
            } else {
                count = 0;
            }

        }

        return theChar;
    }

    public static void main(String[] args) {
        System.out.println(maximum("geeksforgeeks"));
    }

}
