package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given a string 's' of lower and upper case English letters, return a good string where,
 * no two adjacent characters are the same letter with different cases,
 * such as s[i] == 'a' and s[i + 1] == 'A' or s[i] == 'A' and s[i + 1] == 'a'.
 * If there are two adjacent characters that make the string bad, remove them,
 * and keep checking until the string becomes good.
 * Note that an empty string is also good.
 *
 *
 * Example 1:
 * Input : s = "abcCBA"
 * Output: ""
 * Explanation: "abcCBA" -> "abBA" -> "aA" -> "".
 *
 *
 * Example 2:
 * Input : s = "HelloWorld"
 * Output: "HelloWorld"
 * Explanation: The string 's' is already a good string.
 *
 *
 * @author Chee Hwa Tang
 */

public class MakeTheStringGreat_Stack {

    // Approach:
    // Using stack to check for the bad character pairs is suitable here,
    // because some bad character pairs can be found after other character pairs are removed, for example "abcCBA" -> "".
    //
    // To check if the adjacent characters are the same letter with different case,
    // we can check if the two characters are of lower and upper case, if they are different by 32,
    // This is because the ASCII value for 'a' is 97, and 'A' is 65, with 97 - 65 == 32.

    public String makeGood(String s) {
        int n = s.length();
        // Rather than using Stack<> and StringBuilder together, we can just use a StringBuilder for the function of stack,
        // by checking the last / rightmost character in the StringBuilder.
        // Since the StringBuilder is backed by an array with default initial capacity of 16,
        // we can set the initial capacity to the maximum length possible to prevent inefficiency in resizing when
        // s.length() > 16.
        StringBuilder stringBuilder = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            // Check if the 'stringBuilder' is empty, as it results in IndexOutOfBound error if not checked.
            // Using Math.abs(), we can check if the two characters are of different cases but same letter,
            // regardless which is lowercase or uppercase.
            // If found the bad pair, remove the rightmost character in the 'stringBuilder', like a stack.
            if (stringBuilder.length() > 0 && Math.abs(current - stringBuilder.charAt(stringBuilder.length() - 1)) == 32)
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            // If not, then add the character to the 'stringBuilder'.
            else
                stringBuilder.append(current);
        }
        return stringBuilder.toString();
    }
}
