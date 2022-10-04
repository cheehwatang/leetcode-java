package com.cheehwatang.leetcode;

import java.util.Arrays;

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

public class MaxNumberOfKSumPairs_Sorting_TwoPointers {

    // Approach:
    // Using sorting and two pointers. The sorting in ascending order allows us to use two pointers, 'left' and 'right'
    // to traverse the sorted array from both ends.
    // If the sum of nums[left] and nums[right] is greater than 'k',
    // then we move 'right' (to reduce the sum of the two numbers).
    // If the sum is less than 'k', then we move 'left' (to increase the sum of the two numbers).
    // If found a match, then we move both pointers.

    public int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);
        int count = 0;

        // Traverse the sorted array by moving the 'left' and 'right' pointers towards each other.
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // If nums[right] is larger than k, we know it is impossible to get a sum lesser or equal to k.
            // Move 'right' if sum is greater than k.
            if (nums[right] >= k || nums[left] + nums[right] > k) {
                right--;
            }
            // If match, increase the count and move both pointers.
            else if (nums[left] + nums[right] == k) {
                count++;
                left++;
                right--;
            }
            // Move 'left' if sum is lesser than k.
            else {
                left++;
            }
        }
        return count;
    }
}
