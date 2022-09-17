package com.cheehwatang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Problem:
 * Given an array 'changed', return the original array if 'changed' is a doubled array,
 * or return an empty array if 'changed' is not a doubled array.
 *
 * Note:
 * A doubled array is when an original array is appended double the value of each of its containing element.
 * The resulted array is then shuffled.
 * Example: Original = [1,2,3]
 *          Doubled  = [1,2,3,2,4,6]
 *          Shuffled = [1,4,3,2,2,6]
 *
 *
 * Example 1:
 * Input    : changed = [1,4,3,2,2,6]
 * Output   : [1,2,3] or in other ordering such as [1,3,2], [3,2,1], etc.
 * Explanation: Twice the value of 1: 1 * 2 = 2.
 *              Twice the value of 2: 2 * 2 = 4.
 *              Twice the value of 3: 3 * 2 = 6.
 *              'changed' can split into [1,2,3] and [2,4,6], thus it is a doubled array.
 *
 * Example 2:
 * Input    : changed = [2,4,3,1,6,0]
 * Output   : []
 * Explanation: Twice the value of 0: 0 * 2 = 0.
 *              Twice the value of 1: 1 * 2 = 2.
 *              Twice the value of 2: 2 * 2 = 4.
 *              Twice the value of 3: 3 * 2 = 6.
 *              'changed' is NOT a doubled array, as there is no match for 0 and 4.
 *
 * Example 3:
 * Input    : changed = [0]
 * Output   : []
 * Explanation: Not a doubled array.
 *
 *
 * @author Chee Hwa Tang
 */

public class FindOriginalArrayFromDoubledArray_Queue_Sorting {

    public int[] findOriginalArray(int[] changed) {

        // For all test cases, if changed.length is 0, or odd number, then it must not be a doubled array.
        // Since all values in the doubled array must be in pairs. (e.g. 1 -> 2, 5 -> 10, etc.)
        if (changed.length == 0 || changed.length % 2 == 1) {
            return new int[0];
        }

        // We will use sorting, to get ascending sequence, and a queue to keep track of values without a pair yet.
        Arrays.sort(changed);
        LinkedList<Integer> queue = new LinkedList<>();

        // Set up the array of the original array, and index to track the position in the array.
        int[] original = new int[changed.length/2];
        int index = 0;

        for (int number : changed) {
            // Check for pair matching, if not found, add to the queue to check later.
            // If found, then we take the smaller value (which is the one in queue), and put into 'original'.
            if (queue.isEmpty() || queue.peek() * 2 != number) {
                queue.offer(number);
            } else {
                original[index++] = queue.poll();
            }
        }

        // If at the end there is still numbers in the queue, meaning there are number that is not matched.
        // If it is empty, meaning all successfully match, returning the original.
        if (queue.isEmpty()) {
            return original;
        } else {
            return new int[0];
        }
    }
}
