package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse through 'nums' once to check every element.
//
// Space Complexity : O(1),
// as we only use fixed variables that does not grow with 'n'.

public class RemoveDuplicatesFromSortedArrayII {

    // Approach:
    // With the removal of duplicates, we can use two pointers,
    // - a 'tail' to represent the final array with the duplicates removed, and
    // - a 'head' to iterate through 'nums'.
    // A duplicate is found when nums[head] == nums[tail],
    // where nums[tail] is the latest number added in-place in the array.
    // We also use a counter to keep track if how many of a number is added in the array.

    public int removeDuplicates(int[] nums) {
        // 'tail' indicating the index in 'nums'.
        int tail = 0;
        // 'count' to keep track of the frequency of the number added.
        int count = 1;

        // Using a 'head' pointer to traverse through 'nums'.
        for (int head = 1; head < nums.length; head++) {
            // If we already have 2 of the same number added in the array,
            // we skip (meaning we remove the second duplicate).
            if (nums[tail] == nums[head] && count == 2) continue;

            // If the count is 1 and nums[tail] == nums[head], increase the count.
            if (nums[tail] == nums[head]) count++;
            // If nums[tail] != nums[head], reset the count to 1.
            else count = 1;

            // In both cases, we add nums[head] to the next position.
            nums[++tail] = nums[head];
        }
        // As the array is 0-indexed, we return the index + 1 value for the length of the new array.
        return tail + 1;
    }
}
