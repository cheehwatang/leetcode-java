package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse 'nums' to determine and count the relative values.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// We use a Hash Table to count the relative values, with a maximum size of 'n'.

public class CountNicePairsInAnArray {

    // Approach:
    // First we need to understand the bad pair, i < j and nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]).
    // With the brute force, we can check each and every pair if it is a nice pair,
    // but the algorithm will exceed the time limit.
    // Thus, let's change the equation for the bad pair as follows:
    // nums[i] - rev(nums[i]) == nums[j] - rev(nums[j]).
    // Use a HashMap to record the nums[i] - rev(nums[i]) for all the numbers, and the frequency.

    public int countNicePairs(int[] nums) {

        // Use long type, so as not the keep doing the modulo function, only need to do once at the end.
        long nicePairs = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int number : nums) {
            // Calculate the difference (relative value) between the nums[i] and rev(nums[i]).
            int relative = number - reverse(number);
            // If the map already had numbers with the same relative value, then add the frequency as the nice pairs.
            nicePairs += map.getOrDefault(relative, 0);
            // Increase the count in the map.
            map.put(relative, map.getOrDefault(relative, 0) + 1);
        }
        return (int) (nicePairs % (1e9 + 7));
    }

    // Method to reverse the number.
    private int reverse(int number) {
        int reverse = 0;
        while (number > 0) {
            reverse = reverse * 10 + number % 10;
            number /= 10;
        }
        return reverse;
    }
}
