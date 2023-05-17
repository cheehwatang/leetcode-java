package com.cheehwatang.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// Time Complexity  : O(m logn),
// where 'm' is the number of rows in 'mat', and 'n' is the number of columns in 'mat'.
// The setup of the 'strengths' array and recording of results both have time complexity of O(n).
// However, for counting the soldiers for each row, the time complexity is O(m * logn),
// with the binary search having time complexity of O(logn).
//
// Space Complexity : O(m + n + k)
// where 'm' is the number of rows in 'mat', 'n' is the number of columns in 'mat', and 'k' is the input 'k'.
// The 'strengths' array has size that grows linearly with 'n',
// with the total size of the nodes in the Queues being the same as 'm',
// and the 'result' array has size of 'k'.

public class TheKWeakestRowsInAMatrix_BinarySearch {

    // Approach:
    // Traverse every row in the matrix to record the indices using LinkedList array 'strengths'.
    // In the 'strengths' array, each index represents the number of soldiers in a row.
    // The LinkedList will implement a Queue (FIFO = first-in-first-out) for rows with the same number of soldier.
    // Using the array 'strengths', we can fulfill:
    // - Condition 1: Traverse 'strengths' in ascending order, with 0 soldiers = weakest and 'n' being the strongest.
    // - Condition 2: Poll the row index 'm' from the front of the queue (FIFO).
    // Return the result with 'k' number of indices, by fulfilling condition 1 followed by condition 2.
    //
    // Here, the strength of a row (number of soldiers '1') is determined with binary search of the first civilian '0'.

    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int columns = mat[0].length;

        // Initialize the Queue array 'strengths'.
        // Note that we are using 'columns + 1', as the array is zero-indexed.
        Queue<Integer>[] strengths = new LinkedList[columns + 1];
        // Traverse the 'strengths' array to initialize each Queue.
        // Note: Avoid using Arrays.fill() as it would result in using the same Queue for all strengths.
        for (int i = 0; i < strengths.length; i++) {
            strengths[i] = new LinkedList<>();
        }

        // For each row,
        for (int row = 0; row < rows; row++) {
            // perform binary search for civilian '0' to count the number of soldiers '1'.
            int strength = numberOfSoldiers(mat[row]);
            // Record the 'row' index into the 'strengths' queue for the strength 'column'.
            strengths[strength].offer(row);
        }

        // Set up a 'result' array and use a 'index' variable to track to index to record the result.
        int[] result = new int[k];
        int index = 0;
        // Traverse 'strengths' in ascending order, to fulfill condition 1.
        for (Queue<Integer> strength : strengths) {
            // If the 'strength' is not empty, record the row index into the 'result'.
            // Always poll from the Queue to get the row of lower index number first, to fulfill condition 2.
            while (!strength.isEmpty()) {
                result[index++] = strength.poll();
                // Once we reach 'k', return the result.
                if (index == k) {
                    return result;
                }
            }
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
