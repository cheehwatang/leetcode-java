package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse 'nums' to count the numbers in 'nums', and we traverse the HashMap with a maximum size of 'n'.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// The HashMap has a maximum size of 'n' if the numbers in 'nums' are all unique.

public class CountNumberOfPairsWithAbsoluteDifferenceK_HashTable {

    // Approach:
    // Using a HashMap to record the frequency of occurrence for all the numbers in 'nums'.
    // This only add the number to the HashMap if it is in 'nums'.

    public int countKDifference(int[] nums, int k) {

        // Record the frequency for all the numbers into the HashMap.
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        // The number of combinations is the multiples of both frequency.
        // e.g. [1,1,2,2,2] can have 2 * 3 = 6 combinations for k = 1.
        // Check for the frequency for both key - k and key + k, as the k difference can be in both directions.
        // Once the count is added, set the value of the number in the HashMap to 0, so that it will not be double counted.
        // Do note that we cannot remove the key-value pair,
        // as it causes Exceptions in the map.keySet() which uses an iterator.
        int count = 0;
        for (Integer key : map.keySet()) {
            if (map.containsKey(key - k)) {
                count += map.get(key) * map.get(key - k);
            }
            if (map.containsKey(key + k)) {
                count += map.get(key) * map.get(key + k);
            }
            map.put(key, 0);
        }
        return count;
    }
}
