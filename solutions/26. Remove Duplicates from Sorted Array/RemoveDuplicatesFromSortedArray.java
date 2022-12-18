package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse through 'nums' once to check every element.
//
// Space Complexity : O(1),
// as we only use fixed variables that does not grow with 'n'.

public class RemoveDuplicatesFromSortedArray {

    // Approach:
    // With the removal of duplicates, we can use two pointers,
    // - a 'tail' to represent the final array with the duplicates removed, and
    // - a 'head' to iterate through 'nums'.
    // A duplicate is found when nums[head] == nums[head - 1].
    // Thus, we can move the pointer 'tail' forward when nums[head] != nums[head - 1], and stay otherwise.

    public int removeDuplicates(int[] nums) {
        // As the first element is not a duplicate, we start 'tail' at 1 and 'head' at 1.
        // Else, we need to move 'tail' forward first before replacing the element, and the result is 'tail' + 1.
        int tail = 1;
        for (int head = 1; head < nums.length; head++)
            // As the question is basically asking the length of the final array,
            // we only need to count the number unique integers.
            // However, for the spirit of the question, we are updating the array in-place up until 'k' unique elements.
            if (nums[head] != nums[head - 1])
                nums[tail++] = nums[head];
        
        return tail;
    }
}
