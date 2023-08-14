package com.cheehwatang.leetcode;

// Time Complexity  : O(n^3),
// where 'n' is the length of 'arr'.
// We use 3 nested for-loops to check every combination where i < j < k, and count good triplets.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input.

public class CountGoodTriplets {

    // Approach:
    // With the 'arr' having a maximum length of 100, we can use the intuitive brute force approach
    // to iterate through every possible combinations where i < j < k, and count good triplets.

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;

        int count = 0;
        // First for-loop, for index 'i'.
        for (int i = 0; i < n; i++) {
            // Second for-loop for index 'j'.
            for (int j = i + 1; j < n; j++) {
                // An early check for "|arr[i] - arr[j]|", skip if the value is greater than 'a'.
                if (Math.abs(arr[i] - arr[j]) > a) continue;

                // Thrid for-loop for index 'k'.
                for (int k = j + 1; k < n; k++) {
                    // If either are greater than 'b' or 'c' respectively, skip.
                    if (Math.abs(arr[j] - arr[k]) > b || Math.abs(arr[i] - arr[k]) > c) continue;

                    // Increase the count by 1 if all 3 conditions are met.
                    count++;
                }
            }
        }
        return count;
    }
}
