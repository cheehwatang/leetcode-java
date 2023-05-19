package com.cheehwatang.leetcode;

import java.util.PriorityQueue;

// Time Complexity  : O(m * (logn + logm)),
// where 'm' is the number of rows in 'mat', and 'n' is the number of columns in 'mat'.
// For each row, we perform binary search to determine the strength of the row, resulting in O(m logn) time complexity.
// Additionally, inserting element into a priority queue is O(logm),
// thus offering all the row information into the priority queue has a O(m logm) time complexity.
// To be exact, there is O(k) as we record the weakest rows into the 'result' array.
//
// Space Complexity : O(m + k)
// where 'm' is the number of rows in 'mat', and 'k' is the input 'k'.
// The priority queue has size that grows linearly with 'm',
// and the 'result' array has size of 'k'.

public class TheKWeakestRowsInAMatrix_BinarySearch_PriorityQueue {

    // Approach:
    // We use binary search to determine the strength of each row (number of soldiers '1'),
    // with the final index of the binary search being the number of soldiers in the row.
    // Then, we use a 2D array to record the 'rowIndex' and the 'numberOfSoldiers'.
    // This then allow us to add the information to a priority queue,
    // with the priority queue being set up to prioritize the weakest row.
    // Lastly, we keep polling from the priority queue and record the result until 'k' elements.

    public int[] kWeakestRows(int[][] mat, int k) {
        // The priority queue is set up to queue the weakest rows at the front.
        // Using the lambda expression, prioritize the row index in ascending order if the number of soldiers is the same,
        // and prioritize the number of soldiers in ascending order otherwise.
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int row = 0; row < mat.length; row++) {
            // Use the 'numberOfSoldiers' private method defined below
            // to perform binary search to determine the strength of the row.
            int numberOfSoldiers = numberOfSoldiers(mat[row]);

            // Record the row and number of soldiers into the priority queue.
            priorityQueue.offer(new int[]{row, numberOfSoldiers});
        }

        // Only select the first 'k' number of elements from the priority queue.
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            // With the lambda expression, the polling from the priority queue always get the weakest row.
            result[i] = priorityQueue.poll()[0];
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
