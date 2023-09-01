package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n^2),
// where 'n' is the length of 'nums'.
// We traverse 'nums' to check each 'nums[i]', with each element we use 2 pointers,
// thus it is a nested loop, with O(n^2) time complexity.
// The Arrays.sort() function has a time complexity of O(n logn).
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input.

public class ThreeSumClosest {

    // Approach:
    // Use sorting and two pointers to search for all the triplets and check for the closest sum to 'target'.
    // For each 'nums[i]' in 'nums', we can check the sum with nums[j] and nums[k] using two pointers,
    // 'left' and 'right' to traverse the remaining numbers.
    // In order to use two pointers in this manner, we have to first sort the array in ascending order.
    // This allows use to check if nums[i] + nums[j] + nums[k] is greater or less than 0.
    // If the sum is less than 'target', then we shift the 'left' pointer to the right.
    // If the sum is greater than 'target', then we shift the 'right' pointer to the left.
    // If we found the sum to be equal to 'target', then we return 'target'.
    //
    // To find the closest number to 'target', we use a variable to keep track and update when found a closer number.

    public int threeSumClosest(int[] nums, int target) {
        // Sort the array, and use 2 variables to keep track of the minimum difference and the sum of the triplets.
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        int threeSum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            // If nums[i] is identical with the previous number skip the number to shorten the time.
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // The following 'highSum' and 'lowSum' is additional check to shorten the time.
            // Otherwise, the rest of the code works on their own.
            //
            // The 'highSum' is to check if the largest possible sum for nums[i] is less than the target.
            // Since we have sorted the 'nums', we know all the remaining numbers will be smaller than the 'highSum'.
            // Thus, we can skip the remaining numbers if 'highSum' is lesser than target.
            int highSum = nums[i] + nums[nums.length - 1] + nums[nums.length - 2];
            if (highSum < target) {
                if (target - highSum < minDiff) {
                    threeSum = highSum;
                    minDiff = target - highSum;
                }
                continue;
            }
            // The 'lowSum' is to check if the smallest possible sum for nums[i] is greater than the target.
            // Since we have sorted the 'nums', we know all the remaining numbers will be greater than the 'lowSum'.
            // If the 'lowSum' is greater than the target,
            // the remaining numbers, including the subsequent i-th numbers will be greater than the 'lowSum'.
            // Thus, we are sure that 'lowSum' is the closest triplet to 'target', if found.
            int lowSum = nums[i] + nums[i + 1] + nums[i + 2];
            if (lowSum > target) {
                if (lowSum - target < minDiff) {
                    return lowSum;
                }
            }

            // After the initial checks, use two pointers, 'left' and 'right'.
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                int difference = Math.abs(sum - target);
                // If the triplet's 'minDiff' is lesser, then record it as the closest 'threeSum' for now.
                if (difference < minDiff) {
                    minDiff = difference;
                    threeSum = sum;
                }
                // Otherwise, decrease the 'right' if sum > target,
                if (sum > target) {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
                // and increase 'left' if sum < target.
                else if (sum < target) {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }
                // If found sum == target, then it is the closest possible.
                else {
                    return sum;
                }
            }
        }
        return threeSum;
    }
}
