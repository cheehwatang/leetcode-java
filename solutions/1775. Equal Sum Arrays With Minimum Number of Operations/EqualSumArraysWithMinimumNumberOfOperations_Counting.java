package com.cheehwatang.leetcode;

// Time Complexity  : O(n + m),
// where 'n' is the length of 'nums1', and 'm' is the length of 'nums2'.
// We traverse 'nums1' once, and 'nums2' once.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input.

public class EqualSumArraysWithMinimumNumberOfOperations_Counting {

    // Approach:
    // Using counting array to keep track of the frequency of both arrays.
    // Since both array's elements can be manipulated, the counting array records the inversion of the second array.
    // Example: nums1 = [1,1], nums2 = [6,5,4], counting array = [3,1,1,0,0,0].
    // This is because, to make the sum equal, in this example,
    // we can either increase the 1 in 'nums1' to 6 or decrease the 6 in 'nums2' to 1.
    // In both cases, the 'difference' is decreased by 5.
    // Once we have the counting array, and the sum of both arrays,
    // we get change the smallest number in the counting array first as it has the largest impact on the 'difference'
    // (Greedy Approach).

    public int minOperations(int[] nums1, int[] nums2) {
        // Case where it is impossible to get equal sum,
        // when one array is longer than 6 multiples of the second array length.
        if ((nums1.length * 6 < nums2.length) || (nums1.length > nums2.length * 6)) return -1;

        // Use the countArray to record the frequency of each number in 'nums1',
        // as well as the inversion of the numbers in 'nums2'.
        // Additionally, record the sum of each array.
        int[] countArray = new int[7];
        int sumNum1 = 0;
        for (int number : nums1) {
            countArray[number]++;
            sumNum1 += number;
        }
        int sumNum2 = 0;
        for (int number : nums2) {
            countArray[7 - number]++;
            sumNum2 += number;
        }

        int count = 0;
        int difference = sumNum1 - sumNum2;
        // In both cases, from the number with the largest impact (1 if difference is negative, 6 if difference is positive),
        // the operations to make is either:
        // - all the frequency of the number (with remainders of the difference), or
        // - the remainders of the difference divided by the number.
        if (difference < 0) {
            for (int i = 1; i < 6; i++) {
                int operations = Math.min(countArray[i], -difference / (6 - i) + (-difference % (6 - i) == 0 ? 0 : 1));
                difference += operations * (6 - i);
                count += operations;
                if (difference >= 0) break;
            }
        } else if (difference > 0) {
            for (int i = 6; i > 1; i--) {
                int operations = Math.min(countArray[i], difference / (i - 1) + (difference % (i - 1) == 0 ? 0 : 1));
                difference -= operations * (i - 1);
                count += operations;
                if (difference <= 0) break;
            }
        }
        return count;
    }
}
