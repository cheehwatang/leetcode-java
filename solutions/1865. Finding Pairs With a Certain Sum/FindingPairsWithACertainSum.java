package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * Given two arrays of integers 'nums1' and 'nums2', design a data structure that supports two functions:
 * 1. add(int index, int val),
 *    which adds a positive integer 'val' to the element in 'nums2' at position 'index'.
 * 2. count(int tot),
 *    which returns the number of pairs (i, j) such that nums1[i] + nums2[j] == tot.
 *
 *
 * Example 1:
 * Input :
 * - Function calls: ["FindSumPairs", "count", "add", "count", "count", "add", "add", "count"]
 * - Inputs:         [[[1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]], [7], [3, 2], [8], [4], [0, 1], [1, 1], [7]]
 * Output: [null, 8, null, 2, 1, null, null, 11]
 * Explanation:
 * - Instantiate object with FindSumPairs([1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4])
 * - count(7) = returns 8.
 * - add(3, 2), nums2[3] == 2, 2 + 2 = 4.
 * - count(8) = returns 2.
 * - count(4) = returns 1.
 * - add(0, 1), nums2[0] == 1, 1 + 1 = 2.
 * - add(1, 1), nums2[1] == 4, 4 + 1 = 5.
 * - count(7) = returns 11.
 *
 *
 * @author Chee Hwa Tang
 */

class FindSumPairs {

    // Approach:
    // As the count() function is the same as the two sum problem,
    // we can use HashMap to record the frequency of the numbers in 'nums2'.
    // In the add() function, update the frequency by reducing the current, and increasing the new number after addition.

    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> map2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        // Create and record the frequency HashMap during the object instantiation.
        this.map2 = new HashMap<>();
        for (int number : nums2) map2.put(number, map2.getOrDefault(number, 0) + 1);
    }

    public void add(int index, int val) {
        // Decrease the count of current number.
        map2.put(nums2[index], map2.get(nums2[index]) - 1);
        nums2[index] += val;
        // Increase the count of the new number (nums2[index] + val).
        map2.put(nums2[index], map2.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        // Check if the corresponding number is in the map.
        for (int number : nums1) count += map2.getOrDefault(tot - number, 0);
        return count;
    }
}
