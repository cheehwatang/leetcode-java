package com.cheehwatang.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

public class FindOriginalArrayFromDoubledArray_HashMap_Sorting {

    public int[] findOriginalArray(int[] changed) {

        // If changed.length is 0 or odd, then it must not be a doubled array.
        // Since all values in the doubled array must be in pairs. (e.g. 1 -> 2, 5 -> 10, etc.)
        if (changed.length == 0 || changed.length % 2 == 1) {
            return new int[0];
        }

        // Count the frequency of each number and record into the HashMap.
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : changed) {
            count.put(number, count.getOrDefault(number, 0) + 1);
        }

        // Set up the array of the original array, and index to track the position in the array.
        int[] original = new int[changed.length / 2];
        int index = 0;

        // For the method below to work, we must sort the 'changed' array.
        // The reason being that we are checking if the frequency of number > frequency of number * 2.
        // If number of higher value at front, it will unintentionally return new int[0],
        // even if later will have a number matching.
        // e.g. if array [14,7], will first check if 28 exist. Answer is no, so return an empty array,
        //      but in actual case it has a match later with 7.
        Arrays.sort(changed);
        for (int number : changed) {
            // If the frequency of the number is already "used up" when matching with smaller number, we will skip.
            if (count.get(number) == 0) {
                continue;
            }

            // If frequency of number > frequency of (number * 2), return an empty array.
            if (count.get(number) > count.getOrDefault(number * 2, 0)) {
                return new int[0];
            }

            // If reach here, meaning frequency of (number * 2) is sufficient to match the frequency of number.
            // Input the number to the original array.
            original[index++] = number;
            // Reduce the count for both, number and number * 2
            count.put(number, count.get(number) - 1);
            count.put(number * 2, count.get(number * 2) - 1);
        }
        return original;
    }
}
