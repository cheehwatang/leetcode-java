package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// as the recursive call stack is at a maximum of size 'n', when climbStairs(i - 1) is called until reaching the base case.
//
// Space Complexity : O(n),
// as we use the memo of size 'n' to record the result of stairs from 1 to 'n'.

public class ClimbingStairs_Recursive {

    // Approach:
    // This problem is the same as the Fibonacci number sequence,
    // where the number of ways is the sum of the ways for 'n - 1' and 'n - 2'.
    // When we are on step i, we can only be at i + 1 or i + 2 for one iteration.
    // Conversely, when we are at step n, we can only have taken the route from i - 1 or i - 2.
    // The same applies to the route to arrive at i - 1 and i - 2 respectively.
    // Thus, ways(n) = ways(n - 1) + ways(n - 2).
    // Here, we use the recursive method,
    // using the 'memo' keep track of the calculated number to lower the time complexity.

    // Wrapper method.
    public int climbStairs(int n) {

        // Use an integer array as 'memo' to record the results that was calculated.
        // This is so to not repeat the same calculation over the recursive calls.
        int[] memo = new int[n + 1];
        return climbStairs(n, memo);
    }

    // Recursive method.
    private int climbStairs(int n, int[] memo) {

        // If 'n' is already in the memo, return memo[n].
        if (memo[n] > 0) return memo[n];

        // We know the ways for n == 1 and n == 2, so record it into the memo.
        if (n == 1) memo[1] = 1;
        if (n == 2) memo[2] = 2;

        // If the current 'n' is not in the memo, then we call the recursive method to calculate and record memo[n],
        // and return the result.
        return memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
    }
}
