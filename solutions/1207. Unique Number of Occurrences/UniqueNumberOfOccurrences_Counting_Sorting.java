package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n + m logm),
// where 'n' is the length of 'arr', and 'm' is the length of the counting array used, in this case it is 2001.
// We traverse 'arr' once to count the frequency of each number in the counting array.
// Then, we sort the counting array of size 'm' with O(m logm) time complexity,
// and check if the frequencies are unique with O(m) time complexity.
// As such, the time complexity is O(n + m logm).
//
// Space Complexity : O(m),
// where 'm' is the length of the counting array used, in this case it is 2001.
// We use counting array to record the frequency of the numbers in 'arr', with size of 2001.

public class UniqueNumberOfOccurrences_Counting_Sorting {

    // Approach:
    // We first use a counting array to count the frequency of each unique numbers in 'arr'.
    // Note that we can alternatively use a HashMap for a better solution,
    // as it allows us to get the solution without knowing the constraints.
    // Once counted, we sort the counting array and check if the frequencies are unique.
    // In a sorted array, the number is unique if the value is different from the two values beside.
    // Note that we would need to ignore 0 frequency.

    public boolean uniqueOccurrences(int[] arr) {
        // Use a counting array of size 2001 to count the frequency of the numbers in 'arr',
        // since we know the range of values in 'arr' is "-1000 <= arr[i] <= 1000".
        int[] counting = new int[2001];
        for (int number : arr) {
            // As the counting array is 0-indexed, and the minimum number is -1000,
            // we would need to shift the value by added 1000.
            counting[number + 1000]++;
        }

        // Then, we sort the counting array to make all the identical values next to each other.
        Arrays.sort(counting);
        // With this, we can traverse the counting array to check if the frequencies are all unique.
        for (int i = 0; i < counting.length - 1; i++) {
            // Note to skip 0 frequency.
            if (counting[i] == 0) continue;

            // If the current frequency is the same as the next, return false.
            if (counting[i] == counting[i + 1]) return false;
        }
        // If we successfully traverse the counting array, return true.
        return true;
    }
}
