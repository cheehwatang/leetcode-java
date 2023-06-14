package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n logn),
// where 'n' is the length of 'nums'.
// We use Arrays.sort() to sort 'nums', which implements the Dual-Pivot Quicksort with O(n logn) time complexity.
// Then, we traverse the 'nums' array once to find the largest perimeter triangle.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent on the size of the input.

public class LargestPerimeterTriangle {

    // Approach:
    // Sort the array.
    // A triangle is only possible if the longer edge is smaller than the sum of the 2 other edges.
    // With the top 3 lengths, there can only be in 2 scenarios:
    // 1. Not able to form a triangle, meaning all the lengths that are shorter than the 2 points cannot form a triangle.
    // 2. Can form a triangle, meaning any lengths shorter will be a smaller triangle.
    // As such, we can traverse from longest to shortest lengths, considering only the top 3 lengths.
    // From the longest lengths, if we found 3 lengths that can form a triangle, we can be sure that it is the largest.

    public int largestPerimeter(int[] nums) {

        Arrays.sort(nums);
        // Since we sorted the array in ascending order, traverse from n - 1 in decreasing order.
        for (int i = nums.length - 1; i >= 2; i--) {
            // If the 3 lengths can form a triangle, then we have the largest perimeter.
            // If not, then move on to the next 3 lengths.
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
