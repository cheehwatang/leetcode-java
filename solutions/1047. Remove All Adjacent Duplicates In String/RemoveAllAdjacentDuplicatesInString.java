package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given a string 's' consisting of lowercase English letters, remove the adjacent duplicate letters found
 * and return the final string after repeating the duplicate removals until no longer possible.
 * Note that the duplicate consists of two adjacent and equal letters.
 * The string 's' consists of only lowercase English letters.
 *
 *
 * Example 1:
 * Input : s = "abccba"
 * Output: ""
 * Explanation: "abccba" -> "abba" -> "aa" -> "".
 *
 *
 * Example 2:
 * Input : s = "abcabc"
 * Output: "abcabc"
 * Explanation: No duplicates are found.
 *
 *
 * @author Chee Hwa Tang
 */

public class RemoveAllAdjacentDuplicatesInString {

    // Approach:
    // Using stack to check for the duplicates is suitable here,
    // because some duplicates can be found after other duplicates are removed, for example "abccba" -> "".

    public String removeDuplicates(String s) {
        int n = s.length();
        // Rather than using Stack<> and StringBuilder together, we can just use a StringBuilder for the function of stack,
        // by checking the last / rightmost character in the StringBuilder.
        // Since the StringBuilder is backed by an array with default initial capacity of 16,
        // we can set the initial capacity to the maximum length possible to prevent inefficiency in resizing when
        // s.length() > 16.
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            // Check if the 'stringBuilder' is empty, as it results in IndexOutOfBound error if not checked.
            // If found the duplicate, remove the rightmost character in the 'stringBuilder', like a stack.
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == s.charAt(i))
                sb.deleteCharAt(sb.length() - 1);
            // If not, then add the character to the 'stringBuilder'.
            else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
