package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse the 'nums' array to add the integer to the HashSet.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// In the worst-case when no duplicate is found, the HashSet has a size of 'n'.

public class ContainsDuplicate_HashSet {

    // Approach:
    // Using HashSet, store the integers in 'nums'. Return true if the same integer is already in the HashSet.
    // Since Set unable to store repeated integers, the add function will return true if added successfully,
    // Return false if fail to add into the HashSet.
    // Note: HashSet uses less memory than HashMap.

    public boolean containsDuplicate(int[] nums) {
        // Set up the HashSet.
        Set<Integer> hashSet = new HashSet<>();

        // For each integer in 'nums'.
        for (int integer : nums) {
            // If fail to add, return true, since it means that there are duplicate integers.
            if (!hashSet.add(integer)) return true;
        }
        // If all integers added successfully, that means all integers are distinct.
        return false;
    }
}
