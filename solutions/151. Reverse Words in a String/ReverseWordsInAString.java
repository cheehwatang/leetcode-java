package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given a string 's', reverse order of the words, where each word is separated by at least one space.
 * Return a string of words in reverse order concatenated by a single space.
 * Please exclude any additional spaces as well as any leading or trailing spaces.
 *
 *
 * Example 1:
 * Input : s = "LeetCode is awesome"
 * Output: "awesome is LeetCode"
 *
 * Example 2:
 * Input : s = "   Hello   World   "
 * Output: "World Hello"
 * Explanation: The reversed string do not contain any leading or trailing spaces,
 *              and reduce multiple spaces to a single space between words.
 *
 *
 * @author Chee Hwa Tang
 */

public class ReverseWordsInAString {

    // Approach:
    // Use the String functions to trim the leading and trailing spaces, then split into words and store in an array.
    // Append the words in the reverse order from the array, with spaces " " in between.

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        String reversedWords = words[words.length - 1];
        for (int i = words.length - 2; i >= 0; i--) {
            reversedWords += " " + words[i];
        }

        return reversedWords;
    }

}
