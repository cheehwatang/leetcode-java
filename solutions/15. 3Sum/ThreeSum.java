package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time Complexity  : O(n^2),
// where 'n' is the length of 'nums'.
// We traverse 'nums' to check each 'nums[i]', with each element we use 2 pointers,
// thus it is a nested loop, with O(n^2) time complexity.
// The Arrays.sort() function has a time complexity of O(n logn).
//
// Space Complexity : O(n^2),
// where 'n' is the length of 'nums'.
// The result can grow quadratically with the input 'nums'.
// For each element 'nums[i]', there is 'n' number of possible triplets that sum to 0.
// As such, the space complexity is O(n^2).

public class ThreeSum {

    // Approach:
    // For 3 sum, nums[i] + nums[j] + nums[k] = 0.
    // For each 'nums[i]' in 'nums', we can check if the sum with nums[j] and nums[k] for the other numbers
    // are equal to 0, using two pointers, 'left' and 'right' to traverse the remaining numbers.
    // In order to use two pointers in this manner, we have to first sort the array in ascending order.
    // This allows use to check if nums[i] + nums[j] + nums[k] is greater or less than 0.
    // If the sum is less than 0, then we shift the 'left' pointer to the right.
    // If the sum is greater than 0, then we shift the 'right' pointer to the left.
    // If we found the sum to the 0, then we shift both pointers, and add the numbers to the result.

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        // Check each 'nums[i]'.
        // We use "nums.length - 2" as the last triplet to check.
        for (int i = 0; i < nums.length - 2; i++) {
            // If nums[i] is identical with the previous number,
            // skip the number to shorten time and prevent duplicate triplets.
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Two points, the 'left' and 'right'.
            // If the sum is > 0, then decrease the 'right', and increase 'left' if sum < 0.
            // We have found a triplet if the sum == 0.
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] > 0) right--;
                else if (nums[left] + nums[right] + nums[i] < 0) left++;
                else {
                    result.add(Arrays.asList(nums[left],nums[right],nums[i]));
                    right--;
                    left++;
                    // For both 'left' and 'right', skip if the subsequent integer is the same.
                    // This shortens the time and prevent duplicate triplets.
                    while (left < right && nums[right] == nums[right + 1]) right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }
            }
        }
        return result;
    }
}
