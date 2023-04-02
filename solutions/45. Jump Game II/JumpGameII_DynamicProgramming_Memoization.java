package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n^2),
// where 'n' is the length of 'nums'.
// For each position, we check every possible jumping positions to get the minimum steps.
// As such, the worst-case is when every position can reach every other positions after it.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// We used an array to memoize the minimum jumps to get from index 0 to index 'n - 1'.

public class JumpGameII_DynamicProgramming_Memoization {

    // Approach:
    // Using the dynamic programming and the memoization technique,
    // we can use a memo to record the minimum number of jump from any positions to arrive at index 'n - 1'.
    // With the recursive method call starting at index 0, we will increase the count by 1 for each jump,
    // and the breaking condition for the recursive calls is when we arrive at the last position 'n - 1'.
    // As we return zero jump from the last position, the recursive calls will increase the jump count by 1
    // for each return of the recursive call stack, at the same time getting the minimum count for each return.
    // We all the recursive calls collapse back to the first method call,
    // memo[0] will have the minimum jump count needed to get from index 0 to index 'n - 1'.

    public int jump(int[] nums) {
        // Create the integer array to memoize the minimum jump count from any position to position 'n - 1'.
        int[] memo = new int[nums.length];
        // As the constraint stated that the size of 'nums' is <= 10^4, we use 10001 for indicate position
        // that is unable to get to index 'n - 1'.
        // Note: Use of Integer.MAX_VALUE may result in integer overflow to Integer.MIN_VALUE,
        // thus affecting the Math.min check to get the minimum jump count for that position.
        Arrays.fill(memo, 10001);

        // Call the recursive method to return the minimum jumps needed to get from index 0 to index 'n - 1'.
        return jump(nums, 0, memo);
    }

    // Recursive method.
    private int jump(int[] nums, int position, int[] memo) {
        // Breaking condition, return 0 when the position is at or after the last position 'n - 1'.
        if (position >= nums.length - 1) return 0;
        // Return the jump count if it is already recorded in the memo.
        if (memo[position] != 10001) return memo[position];

        // For each possible jump position, increase the jump count by 1 and
        // call the recursive method for the next position.
        for (int i = 1; i <= nums[position]; i++) {
            memo[position] = Math.min(memo[position], 1 + jump(nums, position + i, memo));
        }

        // Return the minimum jump count from the current position to the last position 'n - 1'.
        return memo[position];
    }
}
