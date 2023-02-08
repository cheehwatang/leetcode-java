package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n),
// where 'n' is the size of the integer array 'fruits'.
// We traverse the array once with two pointers acting as the sliding window.
//
// Space Complexity : O(1),
// as the use of the auxiliary space is independent on the size of the input, 'fruits'.
// The HashMap used has a maximum size of 2 no matter how big the size of the 'fruits' array.

public class FruitIntoBaskets {

    // Approach:
    // Using two pointers marking the sliding window and
    // a HashMap to count the number of unique fruits in the sliding window,
    // we expand the front of the sliding window in each iteration,
    // with contracting the back of the sliding window if there are more than two unique key value in the HashMap.
    // In each iteration, we update the max with the maximum size of the sliding window.

    public int totalFruit(int[] fruits) {
        // The key of the HashMap is the unique fruit integer,
        // and the value is the number of that unique fruit in the sliding window.
        Map<Integer, Integer> map = new HashMap<>();

        // 'max' keeps track of the maximum size of the sliding window.
        // The 'back' and 'front' are the two pointers marking the sliding window.
        int max = 0, back = 0;
        for (int front = 0; front < fruits.length; front++) {
            // Count the fruits[front] into the HashMap.
            map.put(fruits[front], map.getOrDefault(fruits[front], 0) + 1);

            // If the HashMap has more than two unique fruits, then we contract the sliding window
            while (map.size() > 2) {
                // by moving the 'back' pointer forward, each time reducing the count of the fruit in the HashMap
                map.put(fruits[back], map.get(fruits[back]) - 1);
                // until two unique fruits are in the HashMap.
                if (map.get(fruits[back]) == 0) map.remove(fruits[back]);
                back++;
            }
            // Check and find the maximum size of the sliding window.
            max = Math.max(max, front - back + 1);
        }
        return max;
    }
}
