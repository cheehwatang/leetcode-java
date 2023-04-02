package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n^2),
// where 'n' is the length of 'nums'.
// For each position, we check every possible jumping positions to get the minimum steps.
// As such, the worst-case is when every position can reach every other positions after it.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// We used an array to tabulate the minimum jumps to get from index 0 to index 'n - 1'.

public class JumpGameII_DynamicProgramming_Tabulation {

    // Approach:
    // Using the dynamic programming and the tabulation technique,
    // we can use a table to propagate the minimum number of jump that we need to take, starting from position 0.
    // With the index 0 in the array being zero jumps,
    // all the positions that we can jump to will have minimum of 1 jump.
    // Update the table accordingly with the least number of jumps required to arrive.

    public int jump(int[] nums) {
        int n = nums.length;

        // Set the table array with all the values being Integer.MAX_VALUE,
        // as we are getting the minimum number of jumps for each check.
        int[] table = new int[n];
        Arrays.fill(table, Integer.MAX_VALUE);
        // Set the first position as zero jumps, as we have not made any jumps.
        table[0] = 0;

        // Propagate the number of jumps to arrive at each position up, start with position 0 of zero jumps.
        for (int i = 0; i < n; i++) {
            // For each position, we update the minimum number of jumps to jump to all the reachable positions.
            for (int j = i; j < n && j <= i + nums[i]; j++)
                table[j] = Math.min(table[j], table[i] + 1);
        }
        // The last position of the table has the minimum number of jumps required to jump from index 0.
        return table[n - 1];
    }
}
