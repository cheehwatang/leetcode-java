package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n),
// where 'n' is the number of tasks.
// We iterate through the 'tasks' array once to count the frequency.
// Additionally, we iterate through the 'map', with a maximum size of 'n'.
//
// Space Complexity : O(n),
// where 'n' is the number of tasks.
// The worst-case is if every task is of unique difficulty, then the size of 'map' is the size of 'tasks'.

public class MinimumRoundsToCompleteAllTasks {

    // Approach:
    // First, use a HashMap to count the frequency for each difficulty.
    // If any of the frequency is 1, then it is not possible to complete all the tasks.
    // For frequency greater than 1, there are the following possibilities:
    // - If frequency == 2, perform one 2-tasks.
    // - If frequency == 3, perform one 3-tasks.
    // - If frequency == 3x, perform x number of 3-tasks (3 * x).
    // - If frequency == 3x + 1, perform (x - 1) number of 3-tasks and two number of 2-tasks, total (x + 1) number of tasks.
    //   For example, frequency == 4, we perform two number of 2-tasks.
    // - If frequency == 3x + 2, perform x number of 3-tasks and one number of 2-tasks, total (x + 1) number of tasks.
    //   For example, frequency == 5, we perform one number of 3-tasks, and one number of 2-tasks.
    //
    // Thus, we can simplify the number of tasks for frequency > 1 as (frequency + 2) / 3.
    // For each difficulty, get the number of tasks as (frequency + 2) / 3.

    public int minimumRounds(int[] tasks) {
        // As the constraint for tasks[i] is <= 10^9, it is better to use HashMap instead of Array,
        // since we need to create array of size 10^9 regardless of the number of tasks,
        // which has a higher space complexity than having HashMap of size 'n'.
        Map<Integer, Integer> map = new HashMap<>();

        // Count the frequency for each task difficulty.
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int result = 0;
        // For each frequency,
        for (int frequency : map.values()) {
            // return -1 if the frequency is 1, as it is not possible to complete the task.
            if (frequency == 1) return -1;
            // Add the number of tasks needed to the 'result'.
            result += (frequency + 2) / 3;
        }
        // If any of the frequency is 1, then we will not arrive here, since we already return -1.
        // If we arrive here, it means it is possible to complete all the tasks.
        return result;
    }
}
