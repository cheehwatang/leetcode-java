package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse the 'nums' array and the imaginary correct array once to find the duplicate and the missing number.
// In actual, it is O(2n), which simplified to O(n).
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// We use a HashSet which grows linearly with the length of the input 'nums'.

public class SetMismatch_HashTable {

    // Approach:
    // Using HashSet to check which number is duplicate and which is missing.
    // This is because we know for a fact that the integers in 'nums' is from 1 to n.

    public int[] findErrorNums(int[] nums) {
        // Optional to use result = new int[], with result[0] == duplicate, and result[1] == missing.
        // Here, we use separate variable for readability.
        int duplicate = 0;
        int missing = 0;
        Set<Integer> set = new HashSet<>();
        for (int integer : nums) {
            // If the integer is already in the HashSet, then it is the duplicate.
            // Note that "!set.add(integer)" will still add the integer to the set,
            // just that it will return true of successful, and false otherwise.
            if (!set.add(integer)) duplicate = integer;
        }

        // From the imaginary correct array of 1 to n, we check which integer is missing from the set.
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }
        return new int[]{duplicate, missing};
    }
}
