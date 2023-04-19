package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n logn),
// where 'n' is the length of 'nums'.
// The sorting function in Arrays class has a time complexity of O(n logn).
// The traversal of the 'nums' array has linear time complexity.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// The sorted array has the same length of 'n' as the input 'nums' array.

public class ContainsDuplicate_Sorting {

    // Approach:
    // Sort the 'nums' array so that the duplicate integers (if any) are next to each other.
    // Then, we traverse the sorted array to check if any adjacent integers are the same.
    // Note: With the sorting algorithm having time complexity of O(n logn), it is slower than HashMap and HashSet.

    public boolean containsDuplicate(int[] nums) {
        // Sort the array.
        Arrays.sort(nums);

        // For each integer in 'nums', compare if it is the same as the next integer.
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) return true;
        }
        // If all integers added successfully, meaning all are distinct integers.
        return false;
    }
}
