package com.cheehwatang.leetcode;

// Time Complexity  : O(n logn),
// where 'n' is the length of 'numbers'.
// For each of the integer in 'numbers', we perform binary search on the integers to the left
// to find the integer to sum to 'target'.
// Binary search has time complexity of O(logn).
// For the worst-case to perform binary search for each number O(n), the final time complexity is O(n logn).
//
// Space Complexity : O(1),
// as the auxiliary space used for the pointers is independent on the length of 'numbers'.

public class TwoSumII_InputArrayIsSorted_BinarySearch {

    // Approach:
    // Use binary search for the difference between 'target' and 'i-th' number, given that the 'numbers' is sorted.

    public int[] twoSum(int[] numbers, int target) {
        // For each of the number, we perform binary search to find the second number that sum to 'target'.
        for (int i = 0; i < numbers.length; i++) {
            int difference = target - numbers[i];
            // Find the 'difference' in the 'numbers' array using binary search.
            int left = i + 1;
            int right = numbers.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (numbers[mid] == difference)
                    // Return the result indices when found.
                    // Remember to return the indices added by one as stated in the problem.
                    return new int[]{i + 1, mid + 1};
                else if (numbers[mid] > difference)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        // As a valid result is guaranteed in the test cases,
        // returning an empty array is mainly to prevent compile-time error.
        return new int[2];
    }
}
