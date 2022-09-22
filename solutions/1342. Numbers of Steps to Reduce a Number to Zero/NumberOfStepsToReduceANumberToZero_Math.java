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

public class NumberOfStepsToReduceANumberToZero_Math {

    public int numberOfSteps(int num) {

        int count = 0;
        while (num > 0) {
            num = num % 2 == 0 ? num / 2 : num - 1;
            count++;
        }
        return count;
    }
}
