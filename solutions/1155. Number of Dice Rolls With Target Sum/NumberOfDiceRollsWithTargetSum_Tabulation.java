package com.cheehwatang.leetcode;

// Time Complexity  : O(n * k * target),
// where 'n', 'k' and 'target' are the variables used by the method.
// For each dice, 'n', we check each values of 'target' to add the number of faces 'k' that can sum to 'target',
// in a 3 layer nested for-loops.
//
// Space Complexity : O(n * target),
// where 'n' and 'target' are the variables used by the method.
// We use a matrix of 'n' rows with 'target' columns for tabulation.

public class NumberOfDiceRollsWithTargetSum_Tabulation {

    // Approach:
    // A dynamic programming problem where there are overlapping subproblem,
    // for which each roll has possible 1 to k number face-up.
    // Here, the iterative and tabulation method is used.
    // By reducing the target by the face-up number each roll (hence n - 1),
    // the successful sequence of rolls is achieved when n = 0 and target = 0, which forms the base case for the table.

    public int numRollsToTarget(int n, int k, int target) {
        // As the array is 0-indexed, we need + 1 length to accommodate 'n' and 'target' respectively.
        int[][] table = new int[n + 1][target + 1];
        // The seed/base case for successful sequence in the table.
        table[0][0] = 1;
        // Iterate through the table to get the result for all possibilities.
        int modulus = (int) (1e9 + 7);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < target; j++) {
                // Skip if the position in the array is 0, meaning nothing to add to the j + 1 to k positions.
                if (table[i][j] == 0) continue;
                for (int face = 1; face <= k; face++) {
                    if (face + j <= target) {
                        table[i + 1][j + face] = (table[i + 1][j + face] + table[i][j]) % modulus;
                    }
                }
            }
        }
        return table[n][target];
    }
}
