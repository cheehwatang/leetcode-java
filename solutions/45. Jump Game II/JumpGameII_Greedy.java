package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse the array 'nums' once to find the minimum steps to reach position 'n - 1'.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent on the size of 'nums'.

public class JumpGameII_Greedy {

    // Approach:
    // For any position, where the range of the current jump is from 'start' to 'end',
    // the farthest point to make the jump from the current position is 'end'.
    // Then, we check all the point from 'start' to 'end' to determine the next farthest point 'farthest' to jump.
    // We then make the jump and check the next farthest points from 'end' to 'farthest',
    // each time recording the number of times we jumped.
    // We continue the process until we check all the positions in 'nums'.

    public int jump(int[] nums) {
        // 'currentEnd' keeps track of the last position to make the jump.
        // 'currentFarthest' keeps track of the farthest position that we can jump to.
        int result = 0, currentEnd = 0, currentFarthest = 0;

        // Traverse the whole array, except for the last position in 'nums' as that is the destination.
        for (int i = 0; i < nums.length - 1; i++) {
            // Record the furthest position we can jump to.
            currentFarthest = Math.max(currentFarthest, i + nums[i]);
            // If we have arrived at the last position to make the jump,
            if (i == currentEnd) {
                // we jump, increasing the count by 1,
                result++;
                // and we set the next last position to jump as 'currentFarthest'.
                currentEnd = currentFarthest;
            }
        }
        return result;
    }
}
