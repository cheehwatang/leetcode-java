package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse the 'nums' array to add the integer to the HashMap.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// In the worst-case when no duplicate is found, the HashMap has a size of 'n'.

public class ContainsDuplicate_HashMap {

    // Approach:
    // Using HashMap, store the integers in 'nums'. Return true if the same integer is already in the HashMap.

    public boolean containsDuplicate(int[] nums) {
        // Set up the HashMap.
        Map<Integer, Integer> hashMap = new HashMap<>();

        // For each integer in 'nums',
        for (int integer : nums) {
            // if HashMap contains the key, duplicate integer is found and return true.
            if (hashMap.containsKey(integer)) return true;
            // Add the integer into the HashMap.
            hashMap.put(integer, 1);
        }
        // If all integers added successfully, that means all integers are distinct.
        return false;
    }
}
