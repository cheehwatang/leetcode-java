package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums', as we traverse 'nums' once.
//
// Space Complexity : O(1),
// as we only modified 'nums' in-place, not creating additional array.

public class RemoveElement {

    // Approach:
    // Using two pointers, 'i' is to traverse 'nums' and
    // 'k' is the pointer indicating the position of the modified array.
    // Since the test only check for the elements up to 'k' position, thus not required to modify the remaining elements.

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            // If the element is different from 'val', then we can put it at the latest position in the modified array,
            // at position 'k'.
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
