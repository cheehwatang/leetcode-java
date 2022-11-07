package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given a positive integer 'num' consisting only of digits 6 and 9,
 * return the maximum number you can get by changing at most one digit (6 becomes 9, or 9 becomes 6).
 *
 *
 * Example 1:
 * Input : num = 6666
 * Output: 9666
 * Explanation: Changing the first 6 to 9 results in the maximum number, as compared to 6966, 6696 and 6669.
 *
 *
 * Example 2:
 * Input : num = 9999
 * Output: 9999
 * Explanation: 9999 is already the maximum number.
 *
 *
 * @author Chee Hwa Tang
 */

public class Maximum69Number_String {

    // Approach:
    // As shown in Example 1, regardless of the number,
    // changing the first digit 6 to 9 from left to right yields the maximum number.
    // As such, we can use String conversion, then traverse the string from left to right,
    // to change the first digit 6 that we encounter to digit 9.

    public int maximum69Number (int num) {
        // Convert the integer 'num' to String, then to char[] for easy conversion of char '6' to char '9'.
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // Once found and converted the 6 to 9, we can exit the loop and return the result.
            if (chars[i] == '6') {
                chars[i] = '9';
                break;
            }
        }
        // Convert the char[] back to String and back to integer.
        return Integer.parseInt(String.valueOf(chars));
    }
}
