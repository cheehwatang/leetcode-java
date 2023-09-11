package com.cheehwatang.leetcode;

// Time Complexity  : O(n + k),
// where 'n' is the length of 'nums', and 'k' is 'k'.
// We traverse 'nums' to count the numbers in 'nums', and we traverse maximum 'k' length to get the count.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input.

public class CountNumberOfPairsWithAbsoluteDifferenceK_Counting {

    // Approach:
    // Using a counting array to record the frequency of occurrence for all the numbers in 'nums'.
    // Since we know the number ranges from 1 to 100, we can build array of that size to keep track.

    public int countKDifference(int[] nums, int k) {

        // Counting array of size 101, since it is 0-indexed.
        int[] countingArray = new int[100 + 1];

        // Record the frequency for all the numbers.
        for (int number : nums) countingArray[number]++;

        // The number of combinations is the multiples of both frequency.
        // e.g. [1,1,2,2,2] can have 2 * 3 = 6 combinations for k = 1.
        // Since we are traversing from 1 to 100, we will only add to the count if both i and i+k is > 0 frequency.
        // With that, we do not need to compare with i-k.
        int count = 0;
        for (int i = 1; i < countingArray.length - k; i++) {
            count += countingArray[i] * countingArray[i + k];
        }
        return count;
    }
}
