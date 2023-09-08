package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n * k),
// where 'n' and 'k' are the variables used by the method.
// For every face, we check every dice, to find all the possible combinations that sums to 'target',
// thus we can treat it like nested for-loop.
//
// Space Complexity : O(n * target),
// where 'n' and 'target' are the variables used by the method.
// We use a matrix of 'n' rows with 'target' columns for memoization.
// The recursive call stack has a maximum height of 'n'.

public class NumberOfDiceRollsWithTargetSum_Memoization {

    // Approach:
    // A dynamic programming problem where there are overlapping subproblem,
    // for which each roll has possible 1 to k number face-up.
    // Here, the recursive and memoization method is used.
    // By reducing the target by the face-up number each roll (hence n - 1),
    // the successful sequence of rolls is achieved when n = 0 and target = 0,
    // which forms the base case where target == 0 && n == 0.
    // If target <= 0 || n == 0, meaning the sequence is unsuccessful.

    // Wrapper method to initiate the memo and call the recursive method.
    // As the number 0 in the memo is a meaningful result, set all the elements of the memo to -1.
    public int numRollsToTarget(int n, int k, int target) {
        // As the array is 0-indexed, we need + 1 length to accommodate 'n' and 'target' respectively.
        int[][] memo = new int[n + 1][target + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return numRollsToTarget(n, k, target, memo);
    }

    // Recursive method.
    private int numRollsToTarget(int n, int k, int target, int[][] memo) {
        // Base case for successful sequence.
        if (target == 0 && n == 0) return 1;
        // Base case for unsuccessful sequence.
        if (target <= 0 || n == 0) return 0;
        // If memo already contains the result, return the result.
        if (memo[n][target] != -1) return memo[n][target];
        int modulus = (int) (1e9 + 7);
        int count = 0;
        // For each face, reduce the 'n' by 1 and 'target' by the face-up number.
        for (int face = 1; face <= k; face++) {
            count = (count + numRollsToTarget(n - 1, k, target - face, memo)) % modulus;
        }
        // Store the result into the memo and return the result.
        return memo[n][target] = count;
    }
}
