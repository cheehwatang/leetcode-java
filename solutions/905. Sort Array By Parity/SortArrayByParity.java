package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the size of 'nums'.
// We use two pointers to traverse the array 'nums'.
//
// Space Complexity : O(1),
// as we use variables that are independent of the size of 'nums'.

public class SortArrayByParity {

    // Approach:
    // Since we are sorting the even number to the front and the odd number to the back of the array 'nums',
    // we use a pointer 'end' to traverse the array to find any even number,
    // and a pointer 'start' to indicate the partition for the even number to be placed.
    // Each time we place an even number at position 'start', we move the pointer forward.

    public int[] sortArrayByParity(int[] nums) {

        // Both 'start' and 'end' pointers start at index 0.
        for (int start = 0, end = 0; end < nums.length; end++) {
            // If the 'end' pointer found an even number, swap the number in-place to the position 'start',
            // and move the 'start' pointer forward.
            if (nums[end] % 2 == 0) {
                int temp = nums[start];
                nums[start++] = nums[end];
                nums[end] = temp;
            }
        }
        // Return the same 'nums' array.
        return nums;
    }
}
