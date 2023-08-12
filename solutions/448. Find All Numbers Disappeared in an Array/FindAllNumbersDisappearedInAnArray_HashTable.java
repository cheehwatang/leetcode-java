package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse the 'nums' array twice, once to add the numbers to the HashSet,
// and once to find numbers that are missing.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// The result list has length of 'n', and the HashSet has a maximum size of 'n'.

public class FindAllNumbersDisappearedInAnArray_HashTable {

    // Approach:
    // We use a HashSet to record the distinct numbers found in 'nums'.
    // First traverse 'nums' array to add the numbers to the HashSet.
    // Then, we check each number from 1 to 'n' to find the numbers that are missing and add to the result list.

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();

        // Add the numbers to the HashSet.
        for (int number : nums) set.add(number);

        List<Integer> result = new ArrayList<>();
        // For each number from 1 to 'n', check if the number is in the HashSet.
        // If the number is not found, add to the result list.
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) result.add(i);
        }
        return result;
    }
}
