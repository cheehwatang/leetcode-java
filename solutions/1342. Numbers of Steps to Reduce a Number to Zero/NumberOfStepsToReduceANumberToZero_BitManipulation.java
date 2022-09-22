package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given an integer, return the number of steps to reduce it to zero.
 * In each step,
 * 1. If the current number is even, divide it by 2.
 * 2. If the current number is odd, subtract 1 from it.
 *
 * Note:
 * Use math or bit manipulation to solve.
 *
 *
 * Example 1:
 * Input : 12
 * Output: 5
 * Explanation:
 * Step 1 - 12 is even, divide by 2 to get 6.
 * Step 2 - 6 is even, divide by 2 to get 3.
 * Step 3 - 3 is odd, subtract 1 to get 2.
 * Step 4 - 2 is even, divide by 2 to get 1.
 * Step 5 - 1 is odd, subtract 1 to get 0.
 *
 * Example 2:
 * Input : 5
 * Output: 4
 * Explanation:
 * Step 1 - 5 is odd, subtract 1 to get 4.
 * Step 2 - 4 is even, divide by 2 to get 2.
 * Step 3 - 2 is even, divide by 2 to get 1.
 * Step 4 - 1 is odd, subtract 1 to get 0.
 *
 *
 * @author Chee Hwa Tang
 */

public class NumberOfStepsToReduceANumberToZero_BitManipulation {

    // Notes:
    // & is AND Operation (1 AND 1 is 1, 1 AND 0 is 0, 0 AND 0 is 0)
    // num & 1 == 1 meaning odd, == 0 meaning even.
    // Example:
    // n = 15 or 1111. n & 0001 = 0001
    // n = 8 or 1000. n & 0001 = 0000.
    //
    // ^ is XOR Operation (1 OR 1 is 0, 1 OR 0 is 1, 0 OR 0 is 0)
    // num ^ 1 is num - 1 if num is odd, or num + 1 if num is even.
    // We only use num ^ 1 when num is odd.
    // Example:
    // n = 15 or 1111. n ^ 0001 = 1110 (14)
    // n = 8 or 1000. n ^ 0001 = 1001 (9)
    //
    // >> is SHIFT RIGHT Operation, the number is the number of bits moved (moving the whole binary one bit right).
    // num >> 1 is num / 2 if num is even. If num is odd, then is (num - 1) / 2.
    // Example:
    // n = 15 or 1111. n >> 1 = 0111 (7)
    // n = 8 or 1000. n >> 1 = 0100 (4)

    public int numberOfSteps(int num) {
        int count = 0;

        while (num > 0) {
            num = (num & 1) == 1 ? num ^ 1 : num >> 1;
            count++;
        }
        return count;
    }

}
