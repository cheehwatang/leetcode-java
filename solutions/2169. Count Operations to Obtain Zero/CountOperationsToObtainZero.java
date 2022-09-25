package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given two integers 'num1' and 'num2', return the number of operations to reduce either number to zero.
 * For each operation, either:
 * 1. when num1 >= num2, subtract num2 from num1, or
 * 2. when num2 > num1, subtract num1 from num2.
 *
 *
 * Example 1:
 * Input    : num1 = 5, num2 = 2
 * Output   : 4
 * Explanation:
 * Step 1: num1 > num2, num1 = 5 - 2 = 3
 * Step 2: num1 > num2, num1 = 3 - 2 = 1
 * Step 3: num2 > num1, num2 = 2 - 1 = 1
 * Step 4: num1 == num2, num1 = 1 - 1 = 0
 *
 *
 * Example 2:
 * Input    : num1 = 5, num2 = 0
 * Output   : 0
 * Explanation:
 * No operation is performed as num2 is 0.
 *
 *
 * @author Chee Hwa Tang
 */

public class CountOperationsToObtainZero {

    public int countOperations(int num1, int num2) {
        int count = 0;
        while (num1 > 0 && num2 > 0) {
            if (num1 >= num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            count++;
        }
        return count;
    }
}
