package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem:
 * Given an array of integers 'nums' with distinct positive integers,
 * return the largest subset such that every pair of elements in the subset satisfies:
 * - nums[i] % nums[j] == 0, or
 * - nums[j] % nums[i] == 0,
 *
 *
 * Example 1:
 * Input    : nums = [1,2,3,4]
 * Output   : [1,2,4]
 * Explanation : 2 is divisible by 1, 4 is divisible by 1 and 2.
 *
 *
 * Example 2:
 * Input    : nums = [2,3,4,5,6]
 * Output   : [2,4]
 * Explanation : [3,6] or [2,6] is also accepted.
 *
 *
 * @author Chee Hwa Tang
 */

public class LargestDivisibleSubset {

    // Approach:
    // If we sort 'nums' in ascending order,
    // we can see that all the possible divisible integers are to the right of that number.
    // Additionally, if nums[i] is divisible by nums[j], then all the divisor for nums[j] is also the divisor for nums[i].
    // For Example, nums = [1,2,4,8,16].
    // The divisor for 2 is 1, the divisor of 4 is 2 and 1, the divisor of 8 is 4,2 and 1.
    // If 8 is the divisor for 16, then naturally 1, 2 and 4 is the divisor for 16 as well.
    // As such, we look for the longest subsequence with elements that is divisible by its preceding integer in the subsequence.
    // This looks like the longest increasing subsequence where we look for subsequence with numbers increasing.
    // For that, we first sort the array, then use Dynamic Programming to keep track of the index and length of the subsequence.
    //
    // Note: We will refer the subset as a subsequence for better visualization.

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        // Sort in ascending order.
        Arrays.sort(nums);

        // 'length' records the length of the longest subsequence possible for nums[i].
        int[] length = new int[n];
        // 'previous' records the index of the preceding integer, so that we can get the list of the subsequence.
        int[] previous = new int[n];

        // For keeping track of the maximum length, so we take note of the index of the head of the subsequence.
        int maxLength = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            // Initialize the arrays. Length is 1 because that is the shortest possible length, with 1 element.
            // Previous with -1 for when that number is the start of the subsequence (do not have any divisor).
            length[i] = 1;
            previous[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                // If we found a divisor, as the length is greater, then record in the arrays.
                if (nums[i] % nums[j] == 0 && length[j] + 1 > length[i]) {
                    length[i] = length[j] + 1;
                    previous[i] = j;
                }
            }
            // If we successfully found a longer subsequence, then keep track of the index of the head.
            if (length[i] > maxLength) {
                maxLength = length[i];
                index = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        // Here is where we use the index (head) of the subsequence and traverse each element in the subsequence.
        // Imagine a singly linked list.
        while (index >= 0) {
            result.add(nums[index]);
            index = previous[index];
        }
        return result;
    }
}
