package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given a positive integer 'n', return the smallest positive integer that is a multiple of both 2 and 'n'.
 *
 * Example 1:
 * Input    : n = 4
 * Output   : 4
 *
 *
 * Example 2:
 * Input    : n = 5
 * Output   : 10
 *
 *
 * @author Chee Hwa Tang
 */

public class SmallestEvenMultiple {
    public int smallestEvenMultiple(int n) {
        // If the n is even, then the smallest even multiple is n, else it is n * 2.
        return n % 2 == 0 ? n : n * 2;
    }
}
