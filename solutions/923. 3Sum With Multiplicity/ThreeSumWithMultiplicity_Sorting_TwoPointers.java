package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n^2),
// where 'n' is the length of 'arr'.
// We traverse 'arr'. With each 'arr[i]', we use two pointers to traverse to find the triplets.
// Arrays.sort() function has a time complexity of O(n logn).
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input 'arr'.

public class ThreeSumWithMultiplicity_Sorting_TwoPointers {

    // Approach:
    // Using sorting and two pointers to traverse the sorted array and check each number if they sum to 'target'.
    // Note that, i < j < k and arr[i] + arr[j] + arr[k] == target,
    // do not require the index as the sum is not dependent on the index, so sorting is fine.

    public int threeSumMulti(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        long count = 0;

        // With each 'i', use two pointers 'j' and 'k' to traverse the remaining numbers to the right of 'i'.
        for (int i = 0; i < n - 2; i++) {
            // If the smallest number is greater than 'target',
            // then the remaining numbers (which are greater) are impossible to sum to be equal to 'target'.
            if (arr[i] + arr[i + 1] + arr[i + 2] > target) break;
            // If the largest number is less than 'target', meaning we need to increase 'i' to get a larger number.
            if (arr[i] + arr[n - 1] + arr[n - 2] < target) continue;

            // After the check, traverse with 'j' and 'k' from both ends.
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                // Move 'j' to right if sum is less than target.
                if (sum < target) j++;
                // Move 'k' to left if sum is greater than target.
                else if (sum > target) k--;
                // If it is equal, keep track of the frequency for both 'arr[j]' and 'arr[k]'.
                else {
                    int countJ = 1;
                    while (j < k && arr[j] == arr[j + 1]) {
                        j++;
                        countJ++;
                    }
                    int countK = 1;
                    while (j < k && arr[k] == arr[k - 1]) {
                        k--;
                        countK++;
                    }
                    // If both are same, get the geometric sum for 'countJ' + 'countK' - 1.
                    // Example: [1,2,2,2,2], target = 5. With arr[i] = 1, arr[j] == arr[k] = 2.
                    //          Note that the "j < k" will break with 'j' overlapping with 'k'.
                    //          Thus, 'countJ' = 4 and 'countK' = 1.
                    //          'countJ' + 'countK' - 1 = 4, which results in 4 * 3 / 2 = 6 possible combinations.
                    if (arr[j] == arr[k]) {
                        int frequency = countJ + countK - 1;
                        count += (long) frequency * (frequency - 1) / 2;
                    }
                    // If they are different, the count increase by the multiplication for both.
                    // Example: [1,2,2,3,3], target = 6. With arr[i] = 1, arr[j] = 2 and arr[k] = 3.
                    //          There are 2 * 2 = 4 possible combinations for the 2 and 3.
                    else
                        count += (long) countJ * countK;
                    // Once done, move both pointers to continue check the other numbers.
                    j++;
                    k--;
                }
            }
        }
        return (int) (count % (1e9 + 7));
    }
}
