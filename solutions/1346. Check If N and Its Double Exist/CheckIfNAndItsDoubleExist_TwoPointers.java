package com.cheehwatang.leetcode;

// Time Complexity  : O(n^2),
// where 'n' is the length of 'arr', as we use nested loops to traverse through 'arr'.
//
// Space Complexity : O(1),
// as no additional space is used.

public class CheckIfNAndItsDoubleExist_TwoPointers {

    // Approach:
    // Using two pointers and the brute force approach to check every element pair.

    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                // We need to check for both directions as the pair can be in any order in 'arr'.
                if (arr[i] == arr[j] * 2 || arr[i] * 2 == arr[j])
                    return true;
            }
        }
        return false;
    }
}
