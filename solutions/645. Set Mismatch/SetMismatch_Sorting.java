package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// Since we know that the sorted array would be from 1 to 'n', the implemented sorting function only has
// time complexity of O(2n), with the sorting and traversal of 'nums' each results in O(n).
// Additionally, we traverse the array once more to find the missing and the duplicate numbers.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent on the size of the input.

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
            // Note that if we encounter the duplicate, 'nums[i] != nums[correct]' would return false,
            // thus continuing to the next number while keeping the duplicate number in the missing position.
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            }
            else {
                i++;
            }
        }
        // Optional to use result = new int[], with result[0] == duplicate, and result[1] == missing.
        // Here, we use separate variable for readability.
        int duplicate = 0;
        int missing = 0;
        // Traverse the "sorted" array once more to find the integer that is not in its position.
        for (int j = 0; j < nums.length; j++) {
            if (j + 1 != nums[j]) {
                // nums[j] is the duplicate.
                duplicate = nums[j];
                // j + 1 is the missing number.
                missing = j + 1;
                break;
            }
        }
        return new int[]{duplicate, missing};
    }

    // Method to swap elements.
    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
