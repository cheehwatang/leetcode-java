package com.cheehwatang.leetcode;

import java.util.Arrays;

/**
 * Problem:
 * Given the 2D binary matrix as described below, return k number of indices, of the weakest rows from weakest
 * to strongest.
 *
 * Note:
 * In a 2D binary matrix of int[m][n], with 1s (representing soldiers) and 0s (representing civilians).
 * In each row of int[m], the 1s (soldiers) are positioned to the left of the 0s (civilians).
 * Example:
 * int[m][n] mat = [ [1,1,0,0,0],   => m = 0
 *                   [1,1,1,0,0],        = 1
 *                   [1,0,0,0,0],        = 2
 *                   [1,1,1,0,0],        = 3
 *                   [1,1,1,1,1],        = 4
 *                   [1,0,0,0,0] ]       = 5
 *                n = 0,1,2,3,4
 *
 * A row (i) is weaker than a row (j) if one of the following conditions is true:
 * Condition 1: The number of 1s (soldier) in row (i) is less than the number of 1s (soldier) in row (j).
 * Condition 2: Row of the lower index (i < j) if both rows have the same number of 1s (soldier).
 *
 * Using the example above, to sort from weakest to strongest (Condition 1), with preceeding rows first (Condition 2):
 * int[m][n] mat = [ [1,0,0,0,0],   => m = 2
 *                   [1,0,0,0,0],        = 5
 *                   [1,1,0,0,0],        = 0
 *                   [1,1,1,0,0],        = 1
 *                   [1,1,1,0,0],        = 3
 *                   [1,1,1,1,1] ]       = 4
 *                n = 0,1,2,3,4
 * If k = 2: Output = [2,5]
 * If k = 4: Output = [2,5,0,1]
 *
 * @author Chee Hwa Tang
 */

public class TheKWeakestRowsInAMatrix_BinarySearch_Sort {

    // Implementation using Binary Search for number of soldiers, and Sort for the weakest rows.
    public int[] kWeakestRows(int[][] mat, int k) {

        // Using a 2D array to record the rowIndex and numberOfSoldiers,
        // which allows for sorting numberOfSoldiers in ascending order.
        // Note: the Arrays.sort() method is a stable sort, thus only compare numberOfSoldiers.
        int[][] rowIndexWithStrength = new int[mat.length][2];
        for (int rowIndex = 0; rowIndex < mat.length; rowIndex++) {
            rowIndexWithStrength[rowIndex][0] = rowIndex;
            rowIndexWithStrength[rowIndex][1] = numberOfSoldiers(mat[rowIndex]);
        }
        Arrays.sort(rowIndexWithStrength, (a, b) -> a[1] - b[1]);

        // Only select the first k number of elements from the rowIndexWithStrength array.
        int[] kWeakestRowsIndices = new int[k];
        for (int i = 0; i < k; i++) {
            kWeakestRowsIndices[i] = rowIndexWithStrength[i][0];
        }
        return kWeakestRowsIndices;
    }

    // Using binary search to determine the number of 1s (soldiers).
    private int numberOfSoldiers (int[] row) {
        int low = 0;
        int high = row.length;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (row[mid] == 0) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        // The while loop will exit with low == high, indicating the index of the first 0 (== number of 1s).
        return low;
    }

}
