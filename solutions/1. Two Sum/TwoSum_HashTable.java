package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * Given an array of integers 'nums' and an integer 'target',
 * return the indices of the two numbers such that they add up to 'target'.
 *
 * Note:
 * In the 'nums' input, there is only one solution that add up to 'target', and you may not use the same element twice.
 *
 *
 * Example 1:
 * Input    : nums = [1,2,3,4], target = 6
 * Output   : [1,3]
 * Explanation:
 * nums[1] + nums[3] = 2 + 4 = 6.
 *
 *
 * Example 2:
 * Input    : nums = [1,1,2,2,3,3], target = 6
 * Output   : [4,5]
 * Explanation:
 * nums[4] + nums[5] = 3 + 3 = 6.
 *
 *
 * @author Chee Hwa Tang
 */

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
    // While the second occurrence is checked to achieve 'target', then we can record the index for both elements.

    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        // HashMap with Key (Integer) storing the Integer value, while Value (Integer) storing the index number.
        Map<Integer, Integer> map = new HashMap<>();

        // Traverse the 'nums'.
        for (int i = 0; i < nums.length; i++) {
            // Check if the HashMap contains the 'difference'. If not, then we record the Integer and index to check later.
            // If we found the 'difference' in the HashMap, then we have found our unique solution.
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                result[0] = i;
                result[1] = map.get(difference);
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
