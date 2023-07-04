package com.cheehwatang.leetcode;

// Time Complexity  : O(n^2),
// where 'n' is the length of 'nums'.
// We traverse 'nums' recursively in halves and count each the elements of each half to find the majority.
//
// Space Complexity : O(logn),
// where 'n' is the length of 'nums'.
// The recursive call stack has a maximum size of 'logn' since we are dividing the array in half for each recursion.

public class MajorityElement_DivideAndConquer_Counting {

    // Approach:
    // We recursively divide 'nums' in two halves, and find the majority for each half
    // and return the number with greater frequency.

    // Main method to call the recursive method.
    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }

    // Recursive method to get the majority element of 'nums' between 'low' and 'high'.
    private int majorityElement(int[] nums, int low, int high) {
        // For base case when the section only has one element.
        if (low == high) return nums[low];

        // Get the midpoint.
        // The implementation below prevents integer overflow as compared to "(low + high) / 2".
        int mid = ((high - low) / 2) + low;

        // Recursively call the method to get the majority element for each half.
        int left = majorityElement(nums, low, mid);
        int right = majorityElement(nums, mid + 1, high);

        // If both half has the same majority element, return either element.
        if (left == right) return left;

        // Count the frequency for each element in the segment.
        int leftCount = countForRange(nums, low, high, left);
        int rightCount = countForRange(nums, low, high, right);

        // Return the element with greater frequency.
        return (leftCount > rightCount) ? left : right;
    }

    // Helper method to count the frequency of 'target' element in 'nums' between 'low' and 'high'.
    private int countForRange(int[] nums, int low, int high, int target) {
        int count = 0;
        // Traverse from 'low' to 'high' to count 'target' element in 'nums'.
        for (int i = low; i <= high; i++) {
            if (nums[i] == target) count++;
        }
        return count;
    }
}
