package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse the 'nums' array, with the worst-case having to traverse the whole array,
// which has a linear time complexity.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// The worst case is when all the integers in 'nums' are unique,
// thus resulting in the HashMap having the same size as the input 'nums'.

public class ContainsDuplicateII_HashMap {

    // Approach:
    // We use a HashMap to keep track of the last seen index of the integer.
    // Since we only concern about the i - j <= k, any prior j indices is not needed.

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // If k is 0, then i and j cannot be distinct.
        if (k == 0) return false;

        // Set up the HashMap, with key = integer in 'nums' and value = index.
        Map<Integer, Integer> map = new HashMap<>();

        // Traverse the 'nums'.
        for (int i = 0; i < nums.length; i++) {
            int integer = nums[i];
            // If contains key and i - j <= k, return true.
            if (map.containsKey(integer) && i - map.get(integer) <= k) {
                return true;
            }
            // Either put a new <Integer, Index> pair, or update index of existing integer in the HashMap.
            map.put(integer, i);
        }
        // If successfully traverse the whole array, meaning we fail to find any integers fulfilling the conditions.
        return false;
    }
}
