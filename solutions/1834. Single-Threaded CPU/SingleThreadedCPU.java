package com.cheehwatang.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

// Time Complexity  : O(n^2),
// where 'n' is the number of tasks.
// The Arrays.sort() method uses the Dual-Pivot Quicksort, which results in complexity of O(n logn) in most cases,
// but worst case is quadratic O(n^2).
// Otherwise, the enqueing and dequeing methods of the priority queue resulted in complexity of O(logn).
// As we perform enqueing and dequeing methods for all the elements in 'tasks',
// the final complexity from priority queue is O(n logn).
// If we take worst-case for the Sorting, then the time complexity is O(n^2), but on average is O(n logn).
//
// Space Complexity : O(n),
// where 'n' is the number of tasks.
// We use a new array of size 'n',
// and the maximum size of the priority queue is 'n' when all the tasks are queued.

public class SingleThreadedCPU {

    // Approach:
    // As the index of the task is important when more than one element have the same 'processingTime',
    // we create a new array to include the index of the tasks, as well as the 'enqueueTime' and 'processingTime'.
    // From there, we sort the new array in ascending order of the 'enqueueTime'.
    // For the task processing, we use a priority queue, a minimum heap,
    // to let us process the task with the least 'processingTime' (lower Index if same).
    // We can think of the sorted array as the memory of the tasks, which is retrieved when "time >= enqueueTime",
    // and the priority queue as the processing stack.
    // Each time, we check if new tasks need to be read from the memory to the processing stack.
    // Then, if there are tasks queued in the processing stack, we process the top priority task.

    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

        // Add the 'index' information together with the 'enqueueTime' and 'processingTime' into the new array.
        int[][] tasksWithIndex = new int[n][3];
        for (int i = 0; i < n; i++) {
            // tasksWithIndex[i][0] = 'enqueueTime'
            // tasksWithIndex[i][1] = 'processingTime'
            // tasksWithIndex[i][2] = 'index'
            tasksWithIndex[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }

        // Sort the new array in the ascending order of the 'enqueueTime'.
        // The other two variables are not important here,
        // as their relevance will be processed in the priority queue when added.
        Arrays.sort(tasksWithIndex, (a, b) -> a[0] - b[0]);

        // Create a priority queue with the priority given to the least 'processingTime',
        // and lowest 'index' if same 'processingTime'.
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);

        int[] result = new int[n];

        // 'time' keeps track of the current time.
        int time = 0;
        // 'enqueueIndex' keeps track of the task to add from the new array, when the 'enqueueTime' <= 'time'.
        int enqueueIndex = 0;
        // 'processedIndex' keeps track of the result position in 'result'.
        int processedIndex = 0;

        // Process all the tasks.
        while (processedIndex < n) {
            // If there are tasks in the priority queue,
            if (!priorityQueue.isEmpty()) {
                int[] task = priorityQueue.poll();
                // add the 'index' (task[2]) to the 'result'.
                result[processedIndex++] = task[2];
                // Update the 'time' by adding the 'processingTime' (task[1]).
                time += task[1];
            }
            // If the priority queue is empty, update the 'time' to the 'enqueueTime' of the next time in the new array.
            else {
                time = tasksWithIndex[enqueueIndex][0];
            }

            // For the new 'time', read the tasks from the memory to the priority queue, if any.
            while (enqueueIndex < n && tasksWithIndex[enqueueIndex][0] <= time) {
                priorityQueue.offer(tasksWithIndex[enqueueIndex++]);
            }
        }

        return result;
    }
}
