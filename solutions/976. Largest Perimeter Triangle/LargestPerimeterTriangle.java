package com.cheehwatang.leetcode;

import java.util.Arrays;

/**
 * Problem:
 * Given an array of integers 'nums' representing the length of the edge of a triangle,
 * return the largest perimeter of a triangle with a non-zero area, formed from three of the lengths in 'nums'.
 * If not triangle is possible, return 0.
 *
 *
 * Example 1:
 * Input    : nums = [2,3,2]
 * Output   : 7
 * Explanation: A triangle with short edges 2,2, and a long edge of 3 is possible.
 *
 *
 * Example 2:
 * Input    : nums = [3,2,1]
 * Output   : 0
 * Explanation: A triangle using the 3 length is not possible.
 *
 *
 * @author Chee Hwa Tang
 */

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
