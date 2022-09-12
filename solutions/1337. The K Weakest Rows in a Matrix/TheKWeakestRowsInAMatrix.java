package com.cheehwatang.leetcode;

import java.util.PriorityQueue;

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

public class TheKWeakestRowsInAMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {

        // Traverse every row (m) in the matrix to record the indices using an array of LinkedList (strengthArray).
        // In the array, each index represents the number of soldiers in a row.
        // The Linked List will implement a Queue (FIFO = first-in-first-out) for rows with the same number of soldier.
        // Using the recorded array (strengthArray), fulfill:
        // - condition 1: start from index 0 (0 soldiers = weakest possible).
        // - condition 2: get the front of the queue (FIFO).
        // Return the result with a number (int k) of indices, by fulfilling condition 1 followed by condition 2.

        // Initialize array of PriorityQueue (strengthQueue)
        PriorityQueue<Integer>[] strengthQueue = new PriorityQueue[mat[0].length + 1];
        for (int i = 0; i < strengthQueue.length; i++) {
            strengthQueue[i] = new PriorityQueue<>();
        }

        // Record into the strengthQueue
        int count;
        for (int m = 0; m < mat.length; m++) {
            count = 0;
            for (int n = 0; n < mat[m].length; n++) {
                if (mat[m][n] == 0) {
                    break;
                }
                count++;
            }
            strengthQueue[count].add(m);
        }

        // Check for condition 1 followed by condition 2 in the strengthQueue
        // Return only up to k number of indices
        int[] result = new int[k];
        int index = 0;
        for (PriorityQueue<Integer> listOfSameSoldier : strengthQueue) {
            while (!listOfSameSoldier.isEmpty()) {
                result[index++] = listOfSameSoldier.remove();
                if (index == k) {
                    break;
                }
            }
            if (index == k) {
                break;
            }
        }
        return result;
    }
}
