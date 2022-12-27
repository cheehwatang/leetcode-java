package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n^2 + m logm),
// where 'n' is the length of 'nums', and 'm' is the length of 'queries'.
// The Arrays.sort() method uses the Dual-Pivot Quicksort, which results in complexity of O(n logn) in most cases,
// but worst case is quadratic n^2.
// The Prefix Sum requires a traverse of array 'nums', results in complexity of O(n).
// For the Arrays.binarySearch(), it has a time complexity of O(log m).
// Since we perform binary search for each query, the final complexity is O(m logm).
// Adding all together results in O(n^2 + m logm), from the Sorting and Binary Search.
//
// Space Complexity : O(m),
// where 'm' is the length of 'queries'.
// The 'answer' array is of size 'm'.

public class LongestSubsequenceWithLimitedSum {

    // Approach:
    // As we are finding the maximum size of subsequence, not subarray,
    // the order of the elements in the subsequence is not important.
    // Thus, we can manipulate the position of the elements to find the maximum size of the subsequence for each query.
    // We can perform Sorting of the array, and get the Prefix Sum of the elements from the smallest to the greatest.
    // As such, this guarantees the position of the first prefix sum that is greater than the query
    // is the maximum size of the subsequence.
    // For example: nums = [1,2,3,4,5], prefix sum = [1,3,6,10,15].
    // If the query is 7, the first greater prefix sum is 10 at index 3.
    // The maximum subsequence is 1,2,3 (with prefix sum of 6), which is 3 elements.
    // We can use the Binary Search method in the Arrays class to find the maximum size of the subsequence
    // that sums to less than or equal to query.

    public int[] answerQueries(int[] nums, int[] queries) {

        int m = queries.length;
        int n = nums.length;
        int[] answer = new int[m];

        // Sort 'nums' in ascending order.
        Arrays.sort(nums);

        // Prefix Sum for all the elements in 'nums' in the sorted order.
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }

        // Traverse 'queries' to find the maximum size of each query.
        for (int i = 0; i < m; i++) {
            // Use the binarySearch method in the Arrays class to find the maximum size of the subsequence.
            int maxSize = Arrays.binarySearch(nums, queries[i]);
            // If the Binary Search result is a negative number,
            // it represents "- (insertion point) - 1", according to the Java documentation.
            // The insertion point is the point at which the number would be inserted into the array,
            // at the index of the first element that is greater than the number.
            // Here, the maximum size is the same as the insertion point, since array is 0-indexed.
            // If the Binary Search found the prefix sum, then the maximum size is the index + 1 (adjust for 0-indexed).
            answer[i] = maxSize < 0 ? -maxSize - 1 : maxSize + 1;
            // Above is clearer for explanation, but below is more concise.
            // answer[i] = Math.abs(maxSize + 1)
        }

        return answer;
    }
}
