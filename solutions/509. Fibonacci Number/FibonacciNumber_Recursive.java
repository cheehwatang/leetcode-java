package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// as the recursive call stack is at a maximum of size 'n', when fib(i - 1) is called until reaching the base case.
//
// Space Complexity : O(n),
// as we use the memo of size 'n' to record the result of fib(1) to fib(n).

public class FibonacciNumber_Recursive {

    // Approach:
    // Using dynamic programming through the recursive and memoization method,
    // with the 'memo' to keep track of the calculated number to lower the time complexity.

    // Wrapper method to set up and initiate the recursive call.
    public int fib(int n) {
        // Use an integer array as 'memo' to record the results that was calculated.
        // This is so to not repeat the same calculation over the recursive calls.
        int[] memo = new int[n + 1];
        return fib(n, memo);
    }

    // Recursive method.
    private int fib(int n, int[] memo) {
        // If 'n' is already in the memo, return memo[n].
        if (memo[n] > 0) return memo[n];

        // We know the fibonacci number for n == 0 and n == 1, so record it into the memo.
        if (n == 0) return memo[0] = 0;
        if (n == 1) return memo[1] = 1;

        // If the current 'n' is not in the memo, then we call the recursive method to calculate and record memo[n],
        // and return the result.
        return memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
    }
}
