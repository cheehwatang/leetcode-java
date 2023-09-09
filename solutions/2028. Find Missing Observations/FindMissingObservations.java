package com.cheehwatang.leetcode;

// Time Complexity  : O(m + n),
// where 'm' is the length of 'rolls', and 'n' is 'n'.
// We traverse 'rolls' to get the sum, and traverse the result array of size 'n' to populate the missing observations.
//
// Space Complexity : O(n),
// where 'n' is the input variable 'n'.
// The result has a size of 'n'.

public class FindMissingObservations {

    // Approach:
    // Arithmetically determine the sum of the 'n' rolls by first getting the sum of the 'm' rolls.
    // Then determine the average roll for the 'n' rolls and its remainders to assign the correct rolls.
    // If sum = 10, n = 4, the average roll is 10 / 4 == 2, with remainder of 2. Thus, we know to assign [3,3,2,2]

    public int[] missingRolls(int[] rolls, int mean, int n) {
        // Determine the sum of 'n' rolls.
        int sumM = 0;
        for (int roll : rolls) sumM += roll;
        int sumN = mean * (rolls.length + n) - sumM;

        // If the sum for 'n' rolls is:
        // - less than all 'n' rolls of 1, or
        // - greater than all 'n' rolls of 6,
        // then we know it is impossible to get the target with 'n' rolls.
        if (sumN < n || sumN > 6 * n) return new int[0];

        // Determine the 'floor' number, and the 'remainder' for the number of rolls to add 1 to the 'floor'.
        int floor = sumN / n;
        int remainder = sumN % n;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = remainder-- > 0 ? floor + 1 : floor;
        }
        return result;
    }
}
