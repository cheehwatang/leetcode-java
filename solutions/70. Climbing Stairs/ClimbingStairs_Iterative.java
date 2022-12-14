package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// as we iterate from 1 to 'n' to find the number of ways to climb stairs.
//
// Space Complexity : O(n),
// as we use the table of size 'n' to record the result of stairs from 1 to 'n'.
// If we use only two variable to record ways(i - 1) and ways(i - 2), then it will be O(1).

public class ClimbingStairs_Iterative {

    // Approach:
    // This problem is the same as the Fibonacci number sequence,
    // where the number of ways is the sum of the ways for 'n - 1' and 'n - 2'.
    // When we are on step i, we can only be at i + 1 or i + 2 for one iteration.
    // Conversely, when we are at step n, we can only have taken the route from i - 1 or i - 2.
    // The same applies to the route to arrive at i - 1 and i - 2 respectively.
    // Thus, ways(n) = ways(n - 1) + ways(n - 2).
    // Here, we use the iterative and tabulation method, using an array to keep track.
    //
    // Note that it is possible to use only two variables to keep track of ways(i - 1) and ways(i - 2),
    // but this is a good practice for the tabulation method in dynamic programming.

    public int climbStairs(int n) {

        // Return the ways for n == 1 and n == 2, since we know the result already.
        if (n == 1 || n == 2) return n;

        // When using tabulation, seed the table with the base cases for n == 1 and n == 2.
        // Since the array in Java is zero-indexed, we make sure to have the table of size "n + 1"
        // as we need to access index 'n'.
        int[] table = new int[n + 1];
        table[1] = 1;
        table[2] = 2;
        // Iterate through the table and update its values until 'n'.
        for (int i = 3; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }

        // table[n] is the result.
        return table[n];
    }
}
