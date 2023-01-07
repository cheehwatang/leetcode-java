package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We use two pointers to traverse the 'nums' array once.
//
// Space Complexity : O(1),
// as we only use variables that are independent on the size of the input.
// We are swapping the elements in-place, so the result array does not take up additional space.

public class SortArrayByParityII {

    // Approach:
    // Using two pointers, 'even' and 'odd',
    // to keep track of the position of the number that is not even, and not odd respectively.
    // If both pointers found numbers that do not fulfill the requirement, swap the two numbers.
    // Continue for the whole array.

    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        // The 'even' pointer starts at the first even position, which is 0,
        // and the 'odd' pointer starts at the first odd position, which is 1.
        int even = 0, odd = 1;

        // Continue to traverse 'nums' until the end of the array.
        while (even < n && odd < n) {
            // If the 'even' pointer position is an even number,
            // continue until found an odd number or reached the end of the array.
            while (even < n && nums[even] % 2 == 0) even += 2;

            // If the 'odd' pointer position is an odd number,
            // continue until found an even number or reached the end of the array.
            while (odd < n && nums[odd] % 2 != 0) odd += 2;

            // Swap the two numbers in-place if the pointers are within the bound of the array.
            if (even < n && odd < n) {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
            }
        }
        return nums;
    }
}
