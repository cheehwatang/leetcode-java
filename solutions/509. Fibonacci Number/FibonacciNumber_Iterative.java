package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// as we iterate from 1 to 'n' to find the fibonacci number 'n'.
//
// Space Complexity : O(n),
// as we use the table of size 'n' to record the result of fib(1) to fib(n).
// If we use only two variable to record fib(i - 1) and fib(i - 2), then it will be O(1).

public class FibonacciNumber_Iterative {

    // Approach:
    // Using dynamic programming, through iteration and tabulation.
    //
    // Note that it is possible to use only two variables to keep track of (i - 1) and (i - 2),
    // but this is a good practice for the tabulation method in dynamic programming.

    public int fib(int n) {

        // Return the fibonacci number for n == 0 and n == 1, since we know the result already.
        if (n == 0 || n == 1) return n;

        // When using tabulation, seed the table with the base cases for n == 0 and n == 1.
        // Since the array is zero-indexed, we make sure to have the table of size "n + 1"
        // as we need to access index 'n'.
        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;

        // Iterate through the table and update its values until 'n'.
        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }

        // table[n] is the result.
        return table[n];
    }
}
