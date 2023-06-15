package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse 'nums' array once to find the match.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// The HashMap has a maximum size of 'n', where all numbers are unique and no match is found.

public class MaxNumberOfKSumPairs_HashTable {

    // Approach:
    // Using a HashMap to keep track of frequency of the numbers in 'nums'.
    // Reduce the count or remove the entry (value == 1) if we found the match.
    // If not, then we record the number into the HashMap.

    public int maxOperations(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // For each number in 'nums',
        for (int number : nums) {
            // 'difference' is the second number that pairs with 'number' to sum to 'k'.
            int difference = k - number;

            // Skip the number if it is greater than k.
            if (difference <= 0) continue;

            // If there is the 'difference' in the HashMap, meaning the number came up previously.
            // Increase the count, and reduce the frequency or remove the entry.
            if (map.containsKey(difference)) {
                count++;
                if (map.get(difference) == 1)
                    map.remove(difference);
                else
                    map.put(difference, map.get(difference) - 1);
            }
            // If no match found, increase the frequency or add the entry into the HashMap.
            else
                map.put(number, map.getOrDefault(number, 0) + 1);
        }
        return count;
    }
}
