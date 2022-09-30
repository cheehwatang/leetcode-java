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

public class ReverseWordsInAString_TwoPointers {

    // Approach:
    // Using two pointers, 'left' and 'right', traverse the list from left to right,
    // while extracting the words using substring method.

    public String reverseWords(String s) {

        String reversedWords = "";
        int left;
        int right;

        for (left = s.length() - 1; left >= 0; left--) {

            // If 'left' meets spaces ' ', we skip the loop, until 'left' meets a letter.
            if (s.charAt(left) == ' ') {
                continue;
            }

            // Once 'left' meets a letter, 'right' is used to mark the end of the word.
            right = left;
            // Traverse the 'left' until the start of the word.
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }

            // Add the word (between 'left' and 'right') to the 'reversedWords'.
            // If it is the first word in 'reversedWords', do not add a leading space " ".
            if (reversedWords.compareTo("") == 0) {
                reversedWords += s.substring(left + 1, right + 1);
            } else {
                reversedWords += " " + s.substring(left + 1, right + 1);
            }
        }
        
        return reversedWords;
    }

}
