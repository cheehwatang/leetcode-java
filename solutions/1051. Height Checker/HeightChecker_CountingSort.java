package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'heights'.
// We traverse the array 'heights' twice, once for the counting sort,
// and once to compare with the counting array.
//
// Space Complexity : O(1),
// as the counting array used has a fixed size of 101, independent on the size of the input array 'heights'.
// Note: The counting array is set up based on the constraints stated in the problem.

public class HeightChecker_CountingSort {

    // Approach:
    // First, we perform a counting sort on the 'heights' array, using an integer array of size 101.
    // This is possible because the constraint in the problem stated the range of height is from 1 to 100.
    // The size 101 is used because the integer array is zero-indexed.
    //
    // Then, we traverse the 'heights' array to compare with the heights in the counting sort array,
    // in ascending order, and count the number of heights that are different.

    public int heightChecker(int[] heights) {
        // Set up the counting array.
        int[] counting = new int[101];
        // Perform counting sort, where the index of the 'counting' array is the height.
        for (int height : heights) counting[height]++;

        int count = 0;
        // The minimum height starts at 1.
        int sortedHeight = 1;
        // For each height, check if it is the same height as the sorted height.
        // If it is different, then add to the 'count'.
        for (int height : heights) {
            while (counting[sortedHeight] == 0) sortedHeight++;

            if (sortedHeight != height) count++;
            // Remove the checked height from the 'counting' array.
            counting[sortedHeight]--;
        }
        return count;
    }
}
