package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse the array 'nums' once.
//
// Space Complexity : O(1),
// Only fixed variables that do not grow is used.

public class JumpGame_Greedy {

    // Approach:
    // From the very last position in 'nums', "n - 1",
    // we traverse 'nums' from back to front to check if the next position can jump to the last position.
    // Continue to update the last position until we traverse 'nums'.
    // If we have successfully arrived at position 0, return true.

    public boolean canJump(int[] nums) {

        int lastPosition = nums.length - 1;

        for (int i = lastPosition - 1; i >= 0; i--) {
            // If the 'lastPosition' can arrive from position 'i', then 'i' update 'i' as the new 'lastPosition'.
            if (i + nums[i] >= lastPosition) lastPosition = i;
        }
        // We can jump from the first index to the last index if the 'lastPosition' is at position 0.
        return lastPosition == 0;
    }
}
