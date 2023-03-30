package com.cheehwatang.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n logn),
// where 'n' is the length of 'nums'.
// We traverse 'nums' twice, firstly to count, and secondly to replace the sorted numbers in 'nums',
// giving a time complexity of O(n).
// However, we used a sort function, which implements the Double Pivot Quicksort,
// which has an average time complexity of O(n logn).
// This would happen if all the values in 'nums' are unique, resulting in sorting 'n' number of integers.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// We use HashMap to count the frequency of the numbers.
// The worst-case is when all the integers in 'nums' are unique, resulted in the size of 'n' for the HashMap.
// As we reused the 'nums' array for the final result, that did not contribute to additional space complexity.

public class SortArrayByIncreasingFrequency {

    // Approach:
    // First, we use a HashMap to count the frequency of the integers in 'nums'.
    // With that, we need to sort the frequencies in ascending order,
    // while sorting the integers with the same frequency in descending order.
    // As we cannot sort a HashMap, we convert the HashMap into an array to sort.
    // According to the sorted array, modify the 'nums' array with the new sorted sequence.

    public int[] frequencySort(int[] nums) {

        // Use a HashMap to count the frequency of the integer, with the key -> integer, and value -> frequency.
        Map<Integer, Integer> integerFrequency = new HashMap<>();
        for (int number : nums) {
            integerFrequency.put(number, integerFrequency.getOrDefault(number, 0) + 1);
        }

        // Convert the HashMap into an array,
        // with frequencyList[i][0] -> integer, and frequencyList[i][1] -> frequency.
        int[][] frequencyList = new int[integerFrequency.size()][2];
        int index = 0;
        for (Integer integer : integerFrequency.keySet()) {
            frequencyList[index++] = new int[]{integer, integerFrequency.get(integer)};
        }

        // Sort the array with the frequencies in ascending order,
        // while sorting the integers with the same frequency in descending order.
        Arrays.sort(frequencyList, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        // Replace the values in 'nums' with the new sorted sequence.
        int indexInNums = 0;
        for (int[] frequency : frequencyList) {
            for (int i = 0; i < frequency[1]; i++) {
                nums[indexInNums++] = frequency[0];
            }
        }

        // Return the sorted array.
        return nums;
    }
}
