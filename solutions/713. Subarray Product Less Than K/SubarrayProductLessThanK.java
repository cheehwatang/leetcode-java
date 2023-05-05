package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse 'nums' once with the sliding window.
// In actual, it is O(2n), as we use the 'back' and 'front' pointer, which is simplified to O(n).
//
// Space Complexity : O(1),
// as the auxiliary space used is independent on the size of the input 'nums'.

public class SubarrayProductLessThanK {

    // Approach:
    // Using sliding window expand the window when the product in the sliding window is less than 'k',
    // and shrink the window when the product >= 'k'.
    // When the product is less than 'k', the number of subarrays in the sliding window that is less than 'k'
    // is the size of the window.
    // For example:
    // Sliding window of [1,2,3,4] with k = 25, 'back' of the window is at index 0, 'front' at index 3,
    // the subarrays that fit the requirements are [1,2,3,4], [2,3,4], [3,4] and [4], totalling 4, same as the window size.
    // The same happens initially when 'front' at index 2, [1,2,3], [2,3] and [3], totalling 3, same as the window size.

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int front = 0, back = 0, product = 1; front < nums.length; front++) {
            // For each new nums[front], get the product and check if the product is less than 'k'.
            product *= nums[front];

            // If the product >= k, then shift 'back' forward until the product is less than k, or reached 0 size window.
            // Note that the size of the window is (front - back + 1).
            if (product >= k) {
                while (product >= k && back < front + 1) {
                    product /= nums[back++];
                }
            }
            // If the product is less than 'k', then increase the count by the size of the sliding window.
            if (product < k) count += (front - back + 1);
        }
        return count;
    }
}
