package com.cheehwatang.leetcode;

// Time Complexity  : O(n^2),
// where 'n' is the length of 'nums'.
// Worst case is when we need to traverse 'table' for each position in 'nums'.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// We use a truth table of size 'n' to record the index of the position that we jump to from index 0.

public class JumpGame_DynamicProgramming {

    // Approach:
    // Using the dynamic programming and the tabulation technique,
    // we can use a truth table to propagate the positions that we can jump to, starting from position 0.
    // With the index 0 in the boolean array being true,
    // all the positions that we can jump to are positions 'i' to "i + nums[i]".
    // Update the truth table accordingly if table[i] is true.

    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        boolean[] table = new boolean[n];
        // Set the first position as true, since we start jumping from here.
        table[0] = true;
        for (int i = 0; i < n; i++) {
            // If the table[i] is false, meaning we cannot jump to position 'i' from the first index.
            // So, we skip to the next position to check if that position can reach from the first index.
            if (!table[i]) continue;
            // If we can reach 'i' from the first index, we update the table[position] reachable from position 'i'.
            for (int j = 1; (j <= nums[i]) && (i + j < n); j++) {
                table[i + j] = true;
            }
        }
        // If the last index is true, then we can jump from the first index to the last index.
        return table[n - 1];
    }
}
