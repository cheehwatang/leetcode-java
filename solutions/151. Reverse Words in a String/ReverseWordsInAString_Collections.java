package com.cheehwatang.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

public class ReverseWordsInAString_Collections {

    // Approach:
    // Use the String functions to trim the leading and trailing spaces, then split into words and store in a list.
    // With Collections package, reverse the word order in the list.
    // Use the String.join with " " as the delimiter to produce the reversedWords.

    public static String reverseWords(String s) {
        List<String> words = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }

}
