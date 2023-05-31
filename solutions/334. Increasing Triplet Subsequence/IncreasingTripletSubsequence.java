package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse 'nums' once to determine if the triplet exists.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input 'nums'.

public class IncreasingTripletSubsequence {

    // Approach:
    // Use 2 variables, 'min1' and 'min2' to store the two smaller numbers in the triplet (if any).
    // 1. If found a number less than 'min1' and 'min2', update 'min1'.
    // 2. If found a number larger than 'min1', but smaller than 'min2', update 'min2'.
    // 3. If found a number larger than both 'min1' and 'min2', we found the triplet.
    // Return false failed to find the triplet after traversing the 'nums' array.
    //
    // Case 1 is to account for situation where triplet is smaller than the prior recorded integers.
    // For example: [4,5,1,2,3], where initially 'min1' = 4 and 'min2' = 5.
    // Updating 'min1' to 1, allows 'min2' to update to 2, thus the last integer 3 forms the triplet.
    // If [4,5,1,6], 'min1' = 1, 'min2' = 5, and the last integer 6 still forms the triplet [4,5,6].
    //
    // This is considered greedy algorithm, as we are replacing 'min1' as long as the number is less than 'min1'.
    // As such, we only care about whether the triplet exists, and not to determine the exact triplet.
    // This means that the final 'min1', 'min2' and 'number' do not necessarily form the triplet.

    public boolean increasingTriplet(int[] nums) {
        // Quick check, since the constraint is "1 <= nums.length <= 5 * 1e5".
        if (nums.length < 3) return false;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int number : nums) {
            if (number > min1) {
                // Case 3, when we found that the triplet exists.
                if (number > min2) return true;
                // Case 2, when the number is greater than 'min1' but less than 'min2'.
                else min2 = number;
            }
            // Case 1, when the number is less than both 'min1' and 'min2'.
            else min1 = number;
        }
        return false;
    }
}
