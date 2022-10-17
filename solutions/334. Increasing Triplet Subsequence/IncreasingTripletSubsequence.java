package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given an array of integers 'nums', return 'true' if there exists a triple of indices (i, j, k),
 * such that i < j < k and nums[i] < nums[j] < nums[k]. Otherwise, return false.
 *
 *
 * Example 1:
 * Input    : nums = [1,2,3]
 * Output   : true
 * Explanation: i = 0 < j = 1 < k = 2, nums[i] = 1 < nums[j] = 2 < nums[k] = 3.
 *
 *
 * Example 2:
 * Input    : nums = [3,2,1]
 * Output   : false
 *
 *
 * Example 3:
 * Input    : nums = [2,4,1,3,5]
 * Output   : true
 * Explanation: Triplets [2,3,5] and [1,3,5] are valid.
 *
 *
 * @author Chee Hwa Tang
 */

public class IncreasingTripletSubsequence {

    // Approach:
    // Use 2 variables, 'min1' and 'min2' to store the two smaller numbers in the triplet (if any).
    // 1. If found a number larger than 'min1', but smaller than 'min2', then update 'min2'.
    // 2. If found a number larger than both 'min1' and 'min2', we found the triplet.
    // Return false failed to find the triplet.

    public boolean increasingTriplet(int[] nums) {
        // Quick check, since the constraint is "1 <= nums.length <= 5 * 1e5".
        if (nums.length < 3) return false;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int number : nums) {
            if (number > min1) {
                // Case 2.
                if (number > min2) return true;
                // Case 1.
                else min2 = number;
            }
            // Update 'min1' if found a smaller number.
            // This is to account for situation where triplet is smaller than the previous integers
            // Example: [4,5,1,2,3], where initially 'min1' = 4 and 'min2' = 5.
            // Updating 'min1' to 1, allows 'min2' to update to 2, thus the last integer 3 forms the triplet.
            // If [4,5,1,6], 'min1' = 1, 'min2' = 5, and the last integer 6 still forms the triplet [4,5,6].
            else min1 = number;
        }
        return false;
    }
}
