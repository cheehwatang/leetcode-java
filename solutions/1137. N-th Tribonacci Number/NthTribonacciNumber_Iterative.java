package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the input 'n'.
// We traverse from 3 to 'n' to calculate the n-th tribonacci number.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input.

public class NthTribonacciNumber_Iterative {

    // Approach:
    // We use the iterative method, using the variable 'first', 'second' and 'third' to keep track.

    public int tribonacci(int n) {
        if (n == 0 || n == 1) return n;
        if (n == 2) return 1;

        // As we need both 'n - 1', 'n - 2' and 'n - 3' to start, record 'first', 'second' and 'third', respectively.
        // For each iteration until n, sum all three numbers and replace the numbers.
        int first = 1;
        int second = 1;
        int third = 0;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = first + second + third;
            third = second;
            second = first;
            first = result;
        }
        return result;
    }
}
