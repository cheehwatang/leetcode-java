package com.cheehwatang.leetcode;

// Time Complexity  : O(1),
// as the number of operations performed is independent of the input 'n'.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input 'n'.

public class SmallestEvenMultiple {

    // Approach:
    // If the n is even, then the smallest even multiple is n, else it is n * 2.

    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n * 2;
    }
}
