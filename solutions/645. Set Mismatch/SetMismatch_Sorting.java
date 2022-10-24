package com.cheehwatang.leetcode;

/**
 * Problem:
 * An array of integers 'nums' with length of 'n', which originally contains all the numbers from 1 to 'n',
 * but currently contains an error, which resulted in the repetition of one number and loss of another number.
 * Return an integer array representing:
 * 1. the number that occurs twice, and
 * 2. the number that is missing.
 *
 *
 * Example 1:
 * Input    : nums = [1,1]
 * Output   : [1,2]
 * Explanation: The integer '1' occurs twice, while integer '2' is missing.
 *
 *
 * Example 2:
 * Input    : nums = [3,2,2,4]
 * Output   : [2,1]
 * Explanation: The 'nums' contains the number from 1 to 4. The integer '2' occurs twice, while integer '1' is missing.
 *
 *
 * @author Chee Hwa Tang
 */

public class SetMismatch_Sorting {

    // Approach:
    // Using sorting technique to sort all the numbers in their supposedly correct position.
    // For example, integer 1 at index 0, integer 2 at index 1, etc.
    // Here, we are implementing our own sorting technique, similar to insertion sort,
    // but here the duplicate integer is in the position of the missing integer (pseudo-sorted).
    // For example:
    // nums = [4,2,3,2,1], the sorted array will be [1,2,3,4,2].
    // Once sorted, we know both the:
    // - duplicate by the integer at that position (2), and
    // - missing by the supposed integer (5), using example above.

    public int[] findErrorNums(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            // If the integer at nums[i] is 1, the correct index should be 0.
            int correct = nums[i] - 1;
            // If the integer at 'i' is not at the correct index, we swap nums[i] to its correct position.
            // As the number swapped to position 'i' maybe not be correct, continue swapping.
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            }
            else {
                i++;
            }
        }
        // Note that result[0] is the duplicate integer, result[1] is the missing integer.
        int[] result = new int[2];
        // Traverse the "sorted" array once more to find the integer that is not in its position.
        for (int j = 0; j < nums.length; j++) {
            if (j + 1 != nums[j]) {
                // nums[j] is the duplicate.
                result[0] = nums[j];
                // j + 1 is the missing number.
                result[1] = j + 1;
                break;
            }
        }
        return result;
    }

    // Method to swap elements.
    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
