package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given two integer, 'n' and 'start', return the bitwise XOR of all the numbers from 0 to n,
 * with i-th number where number = start + 2 * i.
 *
 *
 * Example 1:
 * Input    : n = 4, start = 1
 * Output   : 0
 * Explanation:
 * [1,3,5,7] where (1 ^ 3 ^ 5 ^ 7) = 0.
 *
 *
 * Example 2:
 * Input    : n = 5, start = 2
 * Output   : 2
 * Explanation:
 * [2, 4, 6, 8, 10] where (2 ^ 4 ^ 6 ^ 8 ^ 10) = 2.
 *
 *
 * @author Chee Hwa Tang
 */

public class XOROperationInAnArray {

    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= (start + 2 * i);
        }
        return result;
    }

}
