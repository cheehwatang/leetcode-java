package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// as the recursive call stack is at a maximum of size 'n',
// when minCostClimbingStairs(i - 1) is called until reaching the base case.
//
// Space Complexity : O(n),
// as we use the memo of size 'n' to record the result of stairs from 1 to 'n'.

public class MinCostClimbingStairs_Recursive {

    // Approach:
    // Same as the Fibonacci number sequence, where the number of ways is the sum of the ways for 'n - 1' and 'n - 2'.
    // When we are on step i, we can only be at i + 1 or i + 2 for one iteration.
    // Conversely, when we are at step n, we can only have taken the route from i - 1 or i - 2.
    // The same applies to the route to arrive at i - 1 and i - 2 respectively.
    // Between the two choice, we would take the minimum total cost.
    // Thus, cost(n) = Math.min(cost(n - 1) + cost(n - 2)).
    // Here, we use the recursive and memoization method,
    // using the 'memo' keep track of the calculated number to lower the time complexity.

    public int minCostClimbingStairs(int[] cost) {

        // Use an integer array as 'memo' to record the total cost to arrive at 'n'.
        // This is so to not repeat the same calculation over the recursive calls.
        int[] memo = new int[cost.length + 1];
        return minCostClimbingStairs(cost, cost.length, memo);
    }

    private int minCostClimbingStairs(int[] cost, int n, int[] memo) {

        // As memo record the total cost to arrive at step 'n',
        // we get the minimum cost between the previous 2 steps, together with the minimum cost needed to get it.
        if (n > 1 && memo[n] == 0) {
            memo[n] = Math.min(minCostClimbingStairs(cost, n - 1, memo) + cost[n - 1],
                    minCostClimbingStairs(cost, n - 2, memo) + cost[n - 2]);
        }
        return memo[n];
    }
}
