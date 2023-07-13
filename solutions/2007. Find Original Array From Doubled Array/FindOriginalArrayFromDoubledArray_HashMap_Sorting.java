package src.com.cheehwatang.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n logn),
// where 'n' is the length of 'changed'.
// We traverse the 'changed' array twice,
// first is to count the numbers in 'changed' using a HashMap, and
// second is to traverse the sorted 'changed' array determine the original array, if any.
// Additionally, we sort 'changed' array using the Arrays.sort() function, which implements the Dual-Pivot Quicksort
// with O(n logn) time complexity.
// Thus, the final time complexity is O(n logn).
//
// Space Complexity : O(n),
// where 'n' is the length of 'changed'.
// We use a HashMap with the maximum size of 'n' to count the frequency of the numbers in 'changed'.
// Additionally, the result array has size half of 'changed', thus has space complexity of O(n).
// Thus, the total space complexity is O(n).

public class FindOriginalArrayFromDoubledArray_HashMap_Sorting {

    // Approach:
    // We use a HashMap to count the frequency of the numbers in 'changed' array.
    // Then, we sort 'changed' array.
    // This allows use to traverse the sorted 'changed' array in ascending order, and check the smaller numbers first.
    // As we traverse the sorted array, we skip the numbers that has 0 frequency.
    // For each number with frequency greater than 0, we check if the double exists.
    // Return an empty array if empty.
    // Else, record the number in the result array, and reduce the frequency of both number by 1.

    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;

        // If changed.length is 0 or odd, then it must not be a doubled array.
        // Since all values in the doubled array must be in pairs. (e.g. 1 -> 2, 5 -> 10, etc.)
        if (n == 0 || n % 2 == 1) return new int[0];

        // Count the frequency of each number and record into the HashMap.
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : changed) {
            count.put(number, count.getOrDefault(number, 0) + 1);
        }

        // Set up the array of the original array, and index to track the position in the array.
        int[] original = new int[n / 2];
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
            if (count.get(number) <= 0) continue;

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
