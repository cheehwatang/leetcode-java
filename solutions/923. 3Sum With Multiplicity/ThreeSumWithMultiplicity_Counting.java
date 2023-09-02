package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'arr'.
// We traverse 'arr' once to count the frequency of the elements.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input 'arr',
// with the counting array with size of 101 regardless of the input 'arr'.

public class ThreeSumWithMultiplicity_Counting {

    // Approach:
    // Using a counting array, get the frequency of all the integers,
    // then check all the possible combinations to get the sum.
    // Note that, i < j < k and arr[i] + arr[j] + arr[k] == target,
    // do not require the index as the sum is not dependent on the index.

    public int threeSumMulti(int[] arr, int target) {

        // With the constraint of 0 <= arr[i] <= 100, count the frequency of all the integers/
        int[] counting = new int[101];
        for (int integer : arr) counting[integer]++;

        // Keep the count as long type, so as only need to perform the modulo once at the end.
        long count = 0;

        // Traverse the counting array in two for-loops to get the value for 'i' and 'j'.
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                // Get the k integer to check if it is in the counting array.
                int k = target - i - j;
                if (k < 0 || k > 100) continue;
                if (counting[k] > 0) {
                    // If the triplet is of the same integers (eg. [1,1,1], target = 3),
                    // then perform geometric sum for 3 elements.
                    if (i == k && j == k)
                        count += (long) counting[i] * (counting[i] - 1) * (counting[i] - 2) / 6;
                    // If i and j is identical, but different from k (eg. [1,1,2], target = 4),
                    // then perform geometric sum for i & j, then multiply with k.
                    else if (i == j)
                        count += (long) counting[i] * (counting[i] - 1) / 2 * counting[k];
                    // If both i and j is smaller than k, then get the multiples of all the frequency.
                    // This is to make sure no duplicates of results
                    // (eg, [1,2,3], target = 6), only [1,2,3] is counted, but not [2,1,3] or [3,2,1], etc.)
                    else if (i < k && j < k)
                        count += (long) counting[i] * counting[j] * counting[k];
                }
            }
        }
        return (int) (count % (1e9 + 7));
    }
}
