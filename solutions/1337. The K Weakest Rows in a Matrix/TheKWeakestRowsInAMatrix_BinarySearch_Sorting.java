package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(m * (logn + logm)),
// where 'm' is the number of rows in 'mat', and 'n' is the number of columns in 'mat'.
// For each row, we perform binary search to determine the strength of the row, resulting in O(m logn) time complexity.
// Additionally, the Arrays.sort() method implements the Dual-Pivot Quicksort which has O(m logm) time complexity.
// To be exact, there is O(k) as we record the weakest rows into the 'result' array.
//
// Space Complexity : O(m + k)
// where 'm' is the number of rows in 'mat', and 'k' is the input 'k'.
// The 'rowIndexWithStrength' array has size that grows linearly with 'm',
// and the 'result' array has size of 'k'.

public class TheKWeakestRowsInAMatrix_BinarySearch_Sorting {

    // Approach:
    // We use binary search to determine the strength of each row (number of soldiers '1'),
    // with the final index of the binary search being the number of soldiers in the row.
    // Then, we use a 2D array to record the 'rowIndex' and the 'numberOfSoldiers'.
    // This then allow us to sort the array by the 'numberOfSoldiers'.
    // With the row in the sorted order while fulfilling the two conditions,
    // we traverse the array to record the result until 'k' elements.
    //
    // Note: Arrays.sort() method is a stable sort, thus the ordering of the 'rowIndex' remains stable.

    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;

        // 'rowIndexWithStrength[0]' represents the row index, and
        // 'rowIndexWithStrength[1]' represents the strength of the row.
        int[][] rowIndexWithStrength = new int[rows][2];
        for (int row = 0; row < rows; row++) {
            rowIndexWithStrength[row][0] = row;
            // Use the 'numberOfSoldiers' private method defined below
            // to perform binary search to determine the strength of the row.
            rowIndexWithStrength[row][1] = numberOfSoldiers(mat[row]);
        }

        // Sort the 'rowIndexWithStrength' array with the number of soldiers in ascending order,
        // while maintaining the ascending order of the row index for each row with the same strength.
        Arrays.sort(rowIndexWithStrength, (a, b) -> a[1] - b[1]);

        // Only select the first 'k' number of elements from the 'rowIndexWithStrength' array.
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = rowIndexWithStrength[i][0];
        }
        return result;
    }

    // Using binary search to determine the strength of a row (number of soldiers '1').
    private int numberOfSoldiers (int[] row) {
        int start = 0;
        int end = row.length;
        int mid;
        while (start < end) {
            mid = start + (end - start) / 2;

            if (row[mid] == 0) end = mid;
            else start = mid + 1;
        }
        // The while loop exit with start == end, indicating the index of the first 0 (== number of soldiers '1').
        return start;
    }
}
