package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the input 'n'.
// The recursive call stack has a maximum height of 'n'.
//
// Space Complexity : O(n),
// where 'n' is the input 'n'.
// We use a memo of size 'n' to store the tribonacci numbers.
// Additionally, the recursive call stack has a maximum height of 'n'.

public class NthTribonacciNumber_Recursive {

    // Approach:
    // We use the recursive method, using the 'memo' keep track of the calculated number to lower the time complexity.

    public int tribonacci(int n) {

        // Use an integer array as 'memo' to record the results that was calculated.
        // This is so to not repeat the same calculation over the recursive calls.
        int[] memo = new int[n + 1];
        return tribonacci(n, memo);
    }

    private int tribonacci(int n, int[] memo) {
        if (n == 0 || n == 1) return n;
        if (n == 2) return 1;

        // Record the first three element in the Fibonacci sequence.
        memo[1] = 1;
        memo[2] = 1;

        // If the ways for n is not recorded in the 'memo' yet, then calculate and record the result into the memo.
        if (memo[n] == 0) {
            memo[n] = tribonacci(n - 1, memo) + tribonacci(n - 2, memo) + tribonacci(n - 3, memo);
        }
        return memo[n];
    }
}
