package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse 'nums' once to find the single number.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input.

public class SingleNumber {

    // Approach:
    // As the constraints are linear time complexity and constant space complexity,
    // it can only be achieved with bit manipulation.
    // Firstly, we need to understand the bitwise XOR operator '^'.
    // The XOR of any two numbers gives the difference of bit,
    // for example: 1010 ^ 1111 = 0101.
    // If we perform XOR of two identical number, then the result would be 0.
    // For example, 1111 ^ 1111 = 0.
    //
    // Within the 'nums' array, we are guaranteed to have a single distinct number without duplicates.
    // As such, all the other duplicates negates each other when performing XOR operation.
    // Thus, we can determine the single number by performing XOR for all the numbers in 'nums.
    // For example, 1111 ^ 1010 ^ 1111 = 1010, with 1111 negating each other in the XOR operation.

    public int singleNumber(int[] nums) {
        // For each number, perform the XOR operation and return the result.
        int result = 0;
        for (int number : nums) result ^= number;
        return result;
    }
}
