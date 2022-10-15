package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given a palindromic string of lowercase English letters 'palindrome',
 * replace exactly one character with any lowercase English letter to make the string NOT a palindrome (non-palindrome)
 * that it is lexicographically smallest, and return the resulting string.
 * If it is not possible to make the string non-palindromic, return an empty string.
 *
 *
 * Example 1:
 * Input    : palindrome = "abcba"
 * Output   : "aacba"
 * Explanation: Some possible non-palindromes are "aacba", "abcaa" and "zbcba".
 *              Of all, "aacba" is lexicographically smallest.
 *
 *
 * Example 2:
 * Input    : palindrome = "aabaa"
 * Output   : "aabab"
 * Explanation: Some possible non-palindromes are "zabaa", "acbaa", "aabca" and "aabag".
 *              Of all, "aabab" is lexicographically smallest.
 *
 *
 * Example 3:
 * Input    : palindrome = "g"
 * Output   : ""
 * Explanation: The is no way to replace a single character to make "g" a non-palindrome.
 *
 *
 * @author Chee Hwa Tang
 */

public class BreakAPalindrome {

    // Approach:
    // Traverse the string while checking for 3 scenarios:
    // In Example 1: The first encounter of a letter in the string that is not 'a', replace with 'a',
    //               as it is lexicographically smallest.
    // In Example 2: If all the halves are made up of 'a', then replace the last one with 'b',
    //               to make it lexicographically smallest ("aabab" is lexicographically smaller than "babaa").
    // In Example 3: If the string only consists of one character, then not possible to make non-palindrome.

    public String breakPalindrome(String palindrome) {

        // Make the string into char[] to make it easier to change character.
        char[] chars = palindrome.toCharArray();
        int length = palindrome.length();

        // For the first half, the first encounter of the letter that is not 'a' is replaced with 'a' (Example 1).
        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return String.valueOf(chars);
            }
        }
        // If no non-'a' that is found and length is more than one, replace the last character with 'b' (Example 2).
        if (length > 1) {
            chars[length - 1] = 'b';
            return String.valueOf(chars);
        }
        // If length is 1, return empty string (Example 3).
        return "";
    }
}
