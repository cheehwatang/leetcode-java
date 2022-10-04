package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * Given an array of integers 'nums' and an integer 'k'.
 * In one operation, you can pick two numbers from the array whose sum equals 'k' and remove them from the array.
 * Return the maximum number of operations that can be performed on the array.
 *
 *
 * Example 1:
 * Input    : nums = [1,2,3,4,5], k = 6
 * Output   : 2
 * Explanation:
 * 1. Remove 1 and 5, nums = [2,3,4].
 * 2. Remove 2 and 4, nums = [3].
 * No more pairs left to get a sum of 6.
 *
 *
 * Example 2:
 * Input    : nums = [1,2,3,4,5], k = 2
 * Output   : 0
 * The unique pairs with k difference:
 * No more pair can get a sum of 2.
 *
 *
 * @author Chee Hwa Tang
 */

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
                if (map.get(difference) == 1) {
                    map.remove(difference);
                }
                else {
                    map.put(difference, map.get(difference) - 1);
                }
            }
            // If no match found, increase the frequency or add the entry into the HashMap.
            else {
                map.put(number, map.getOrDefault(number, 0) + 1);
            }
        }
        return count;
    }
}
