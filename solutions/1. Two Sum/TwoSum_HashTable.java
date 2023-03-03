package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse 'nums' to record the difference of integer from the 'target',
// with the worst case being iterating through 'nums'.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// The maximum size of the HashMap scales linearly with the length of 'nums'.

public class TwoSum_HashTable {

    // Approach:
    // Since we know there is only one correct combination to get 'target', we can use HashMap to keep track of
    // the integer and the index.
    //
    // We need to account for 2 scenarios:
    // 1. Solution involves 2 unique integer value (Example 1).
    // 2. Solution involves same integer value but different elements (Example 2).
    //
    // Using a HashMap, Scenario 1 is straightforward as the solution involves 2 unique integers.
    // For Scenario 2, we only need to keep track of the first occurrence of the integer.
    // When the second occurrence is checked to achieve 'target', we can record the index for both elements.

    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        // HashMap with key storing the Integer from 'nums', while value storing the index number.
        Map<Integer, Integer> map = new HashMap<>();

        // Traverse the 'nums'.
        for (int i = 0; i < nums.length; i++) {
            // Check if the HashMap contains the 'difference'.
            // If we found the 'difference' in the HashMap, then we have found our unique solution.
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                result[0] = i;
                result[1] = map.get(difference);
                break;
            }
            // Else, we record the Integer and index to check later.
            map.put(nums[i], i);
        }
        return result;
    }
}
