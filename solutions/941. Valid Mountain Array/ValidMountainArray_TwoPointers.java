package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'arr', as we only traverse the array once with both pointers.
//
// Space Complexity : O(1),
// as no additional space is used.

public class ValidMountainArray_TwoPointers {

    // Approach:
    // Using two pointers to traverse 'arr' from both ends,
    // much like having two climbers climbing the mountain from each side of the mountain.
    // If the two climbers meet, and either climbers are not at the starting points,
    // then 'arr' is a valid mountain array.

    public boolean validMountainArray(int[] arr) {
        int n = arr.length, left = 0, right = n - 1;

        // Continue to move 'left' as the next integer is greater, from left to right.
        while (left < n - 1 && arr[left] < arr[left + 1])
            left++;

        // Continue to move 'right' as the next integer is greater, from right to left.
        while (right > 0 && arr[right] < arr[right - 1])
            right--;

        // If the two pointers meet, and either are not at the starting points, then 'arr' is a valid mountain array.
        return left == right && right < n - 1 && left > 0;
    }
}
