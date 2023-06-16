package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n logn),
// where 'n' is the length of 'nums'.
// We use Arrays.sort() to sort the array, which implements Dual-Pivot Quicksort which has O(n logn) time complexity.
// Additionally, we use two pointers to traverse 'nums' once, with O(n) time complexity.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input size.

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
