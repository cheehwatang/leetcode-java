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

public class Maximum69Number_Math {

    // Approach:
    // As shown in Example 1, regardless of the number,
    // changing the first digit 6 to 9 from left to right yields the maximum number.
    //
    // Using math to traverse an integer from right to left, it is done using division '/' and remainder '%' operations.
    // Checking for the digit 6, and change the leftmost digit 6 to 9.
    // As such, we would need a variable to record the previous number that we changed, as we traverse the integer.

    public int maximum69Number (int num) {
        int result = num;
        // 'previous' is set 0 to start as there are no previous number change.
        int previous = 0;
        // Since we are only changing 6 to 9, we only need to add
        // the increment of 3 (and its 10 powers such as 30, 300 or 3000), if the digit is 6.
        // As we start from right to left, the first increment is 3.
        int increment = 3;

        while (num > 0) {
            // Check if the current digit is 6.
            if (num % 10 == 6) {
                // Change the 6 to 9, with "result + increment".
                // Change the previously changed 6 (if any), back to 6 with "result - previous".
                result = result - previous + increment;
                // Update 'previous'.
                previous = increment;
            }
            // Increase the increment by factor of 10 while traversing 'num' to the left.
            increment *= 10;
            num /= 10;
        }
        return result;
    }
}
