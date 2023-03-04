package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'numbers'.
// We use two pointers to traverse the 'numbers' array from both ends to find the combination,
// with the worst-case being the two sum is found at the center of the array.
//
// Space Complexity : O(1),
// as the auxiliary space used for the pointers is independent on the length of 'numbers'.

public class TwoSumII_InputArrayIsSorted_TwoPointers {

    // Approach:
    // Use two pointers to traverse the 'numbers' array from both ends, 'left' and 'right' pointer.
    // As 'numbers' is sorted in ascending order, we can traverse the array to check all pairs.
    // If the integer sum is greater than 'target', move the 'right' pointer to the left.
    // If the integer sum is less than 'target', move the 'left' pointer to the right.

    public int[] twoSum(int[] numbers, int target) {
        // Two pointers, the 'left' and 'right'.
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            // If the sum is > target, then decrease the 'right' pointer.
            if (sum > target) {
                right--;
                // Skip if the previous number is the same.
                while (left < right && numbers[right] == numbers[right + 1]) right--;
            }
            // If sum < target, then increase the 'left' pointer.
            else if (sum < target) {
                left++;
                // Skip if the previous number is the same.
                while (left < right && numbers[left] == numbers[left - 1]) left++;
            }
            // If we found the sum == target, return the result.
            // Remember to return the indices added by one as stated in the problem.
            else {
                return new int[]{left + 1, right + 1};
            }
        }
        // As a valid result is guaranteed in the test cases,
        // returning an empty array is mainly to prevent compile-time error.
        return new int[2];
    }
}
