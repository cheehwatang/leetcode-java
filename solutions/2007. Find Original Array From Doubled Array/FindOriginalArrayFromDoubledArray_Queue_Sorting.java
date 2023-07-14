package src.com.cheehwatang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Time Complexity  : O(n logn),
// where 'n' is the length of 'changed'.
// We sort 'changed' array using the Arrays.sort() function,
// which implements the Dual-Pivot Quicksort with O(n logn) time complexity.
// Then, we traverse 'changed' array once to determine the original array.
// Thus, the final time complexity is O(n logn).
//
// Space Complexity : O(n),
// where 'n' is the length of 'changed'.
// We use a Queue with the maximum size of 'n' to record the numbers that are not matched.
// Additionally, the result array has size half of 'changed', thus has space complexity of O(n).
// Thus, the total space complexity is O(n).

public class FindOriginalArrayFromDoubledArray_Queue_Sorting {

    // Approach:
    // We first sort 'changed' array, so that we can traverse the sorted array in ascending order.
    // As we traverse the sorted array, we use a Queue to record the numbers that are not matched.
    // For each number, we check if the number is double the first element in the Queue.
    // If the numbers matched, we add the smaller number to the result array.
    // If not matched, we offer the number to the Queue.
    //
    // After traverse the sorted array, we check if the Queue is empty.
    // If the Queue is empty, then there are numbers that is not matched, and we return an empty array.
    // Return the result array otherwise.

    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;

        // For all test cases, if changed.length is 0, or odd number, then it must not be a doubled array.
        // Since all values in the doubled array must be in pairs. (e.g. 1 -> 2, 5 -> 10, etc.)
        if (n == 0 || n % 2 == 1) return new int[0];

        // We will use sorting, to get ascending sequence, and a queue to keep track of values without a pair yet.
        Arrays.sort(changed);
        Queue<Integer> queue = new LinkedList<>();

        // Set up the array of the original array, and index to track the position in the array.
        int[] original = new int[n/2];
        int index = 0;

        for (int number : changed) {
            // Check for pair matching, if not found, add to the queue to check later.
            if (queue.isEmpty() || queue.peek() * 2 != number)
                queue.offer(number);
            // If found, then we take the smaller value (which is the one in the queue), and put into 'original'.
            else
                original[index++] = queue.poll();
        }

        // If the queue is empty, meaning all numbers in 'changed' successfully matched.
        if (queue.isEmpty()) return original;
        // Else, there are numbers that is not matched.
        else return new int[0];
    }
}
