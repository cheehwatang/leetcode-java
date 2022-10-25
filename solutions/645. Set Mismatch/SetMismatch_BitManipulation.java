package com.cheehwatang.leetcode;

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

public class SetMismatch_BitManipulation {

    // Approach:
    // Using bit manipulation and counting array.
    // In bit manipulation, the XOR (Exclusive OR), ^, is useful in determining that 2 integers are different.
    // For example, integer 3 as 11 in binary, with "3 ^ 3 (11 ^ 11) == 0", while "3 ^ 2 (11 ^ 10) == 1 (non-zero)".
    //
    // How is XOR useful in this problem?
    // Here, we can XOR to compare 'nums' and the supposedly correct original array that is sorted.
    // If both arrays are the same:
    // "(1 ^ 2 ^ 3 ^ ... ^ n) ^ (1 ^ 2 ^ 3 ^ ... ^ n) == 0"
    // With one element change to another (a change to b for example), we have the scenario that:
    // "0 ^ a ^ b ^ b ^ b == a ^ b" (0 representing the other elements are the same.)
    // Despite 'nums' is not sorted, XOR all the elements with the imaginary correct array would not affect the end result.
    //
    // Using the counting array, we can find 'b' which is the duplicate.
    // With "a ^ b = c", we can use "c ^ b" to get 'a', which is the missing integer.
    // 'c' is the end result when we XOR all the elements in 'nums' and the imaginary correct array.

    public int[] findErrorNums(int[] nums) {
        // Note that result[0] is the duplicate integer, result[1] is the missing integer.
        int[] result = new int[2];
        int[] counting = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            // nums[i] is the current integer at 'i' position, while
            // (i + 1) is the imaginary correct number at 'i' position.
            // Here we are using result[1] to keep track of the XOR result (which is 'c' in "a ^ b == c")
            result[1] ^= nums[i] ^ (i + 1);

            // When we found the duplicate integer in the counting array, then we have found 'b'.
            if (++counting[nums[i]] == 2)
                result[0] = nums[i];
        }
        // Using "c ^ b == a", we can get 'a', which is the missing integer.
        result[1] ^= result[0];

        return result;
    }
}
