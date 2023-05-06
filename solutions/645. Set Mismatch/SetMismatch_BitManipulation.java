package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse the 'nums' array once to find the duplicate and the missing number.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// We use a counting array of the same length as 'nums' to keep track on the frequency of the numbers.

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
        // Optional to use result = new int[], with result[0] == duplicate, and result[1] == missing.
        // Here, we use separate variable for readability.
        int duplicate = 0;
        int missing = 0;
        int[] counting = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            // nums[i] is the current integer at 'i' position, while
            // (i + 1) is the imaginary correct number at 'i' position.
            // Here we are using 'missing' to keep track of the XOR result (which is 'c' in "a ^ b == c")
            missing ^= nums[i] ^ (i + 1);

            // When we found the duplicate integer in the counting array, then we have found 'b'.
            if (++counting[nums[i]] == 2)
                duplicate = nums[i];
        }
        // Using "c ^ b == a", we can get 'a', which is the missing integer.
        missing ^= duplicate;

        return new int[]{duplicate, missing};
    }
}
