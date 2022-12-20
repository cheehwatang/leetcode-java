package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// as we iterate from 1 to 'n' to find the minimum cost to climb the stairs to the top.
//
// Space Complexity : O(1),
// as we use the 'cost' array to record the minimum cost at each step in-place,
// thus, we did not use any additional space for the tabulation.

public class MinCostClimbingStairs_Iterative {

    // Approach:
    // Same as the Fibonacci number sequence, where the number of ways is the sum of the ways for 'n - 1' and 'n - 2'.
    // When we are on step i, we can only be at i + 1 or i + 2 for one iteration.
    // Conversely, when we are at step n, we can only have taken the route from i - 1 or i - 2.
    // The same applies to the route to arrive at i - 1 and i - 2 respectively.
    // Between the two choice, we would take the minimum total cost.
    // Thus, cost(n) = Math.min(cost(n - 1) + cost(n - 2)).
    // Here, we use the iterative method, using the variable 'oneBefore' and 'twoBefore' to keep track.

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        // Get the minimum cost between the previous 2 steps, from n = 2 onwards.
        // This ensures each new cost is the minimum possible cost to take at i-th index.
        for (int i = 2; i < n; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        // Return the lower total cost between 'n - 1' and 'n - 2'.
        return Math.min(cost[n - 1], cost[n - 2]);
    }
}
