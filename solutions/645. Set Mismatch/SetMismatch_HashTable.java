package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem:
 * An array of integers 'nums' with length of 'n', which originally contains all the numbers from 1 to 'n',
 * but currently contains an error, which resulted in the repetition of one number and loss of another number.
 * Return an integer array representing:
 * 1. the number that occurs twice, and
 * 2. the number that is missing.
 *
 *
 * Example 1:
 * Input    : nums = [1,1]
 * Output   : [1,2]
 * Explanation: The integer '1' occurs twice, while integer '2' is missing.
 *
 *
 * Example 2:
 * Input    : nums = [3,2,2,4]
 * Output   : [2,1]
 * Explanation: The 'nums' contains the number from 1 to 4. The integer '2' occurs twice, while integer '1' is missing.
 *
 *
 * @author Chee Hwa Tang
 */

public class SetMismatch_HashTable {

    // Approach:
    // Using HashSet to check which number is duplicate and which is missing.
    // This is because we know for a fact that the integers in 'nums' is from 1 to n.

    public int[] findErrorNums(int[] nums) {
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
