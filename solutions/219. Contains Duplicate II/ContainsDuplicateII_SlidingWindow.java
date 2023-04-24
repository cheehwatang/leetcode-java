package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse the 'nums' array, with the worst-case having to traverse the whole array,
// which has a linear time complexity.
//
// Space Complexity : O(k),
// where 'k' is the input value 'k'.
// At any one time, the HashSet has a maximum size of 'k', and the integers outside the sliding window is removed.

public class ContainsDuplicateII_SlidingWindow {

    // Approach:
    // We use the sliding window technique.
    // Traversing from left to right, we use a HashSet to store the integers that we saw.
    // If the same integer is seen again, we have found the duplicate.
    // Then, we update the window again to be within 'k' index from 'index'.

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // If k is 0, then i and j cannot be distinct.
        if (k == 0) return false;

        // Set up the HashSet.
        Set<Integer> slidingWindow = new HashSet<>();

        // Start sliding the slidingWindow to the right.
        for (int index = 0; index < nums.length; index++) {
            // Return true when found duplicates in the slidingWindow.
            if (slidingWindow.contains(nums[index]))
                return true;

            // Update the state of the window, but removing the leftmost integer and add the new integer.
            if (index >= k)
                slidingWindow.remove(nums[index - k]);

            slidingWindow.add(nums[index]);
        }
        // If successfully traverse the whole array, meaning we fail to find any integers fulfilling the conditions.
        return false;
    }
}
