package com.cheehwatang.leetcode;

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

// Time Complexity  : O(logn),
// where 'n' is the range of number to search for the pick.
// In a binary search function, worst case is only log (base 2) of 'n' as we are only checking the midpoints.
//
// Space Complexity : O(1),
// as not additional space is used other than the fixed variables.

public class GuessNumberHigherOrLower_BinarySearch extends GuessGame {

    // Approach:
    // Using binary search to reduce time complexity as compared to linear search.
    // This is possible as we are search for the range of 1 to 'n', with the numbers in sorted orders.

    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        int mid;
        while (low <= high) {
            // Do take note on integer overflow as 'n' <= 2^31 - 1,
            // thus the midpoint, 'mid' is calculated with "low + (high - low) / 2" rather than "(low + high) / 2".
            mid = low + (high - low) / 2;
            // Return 'mid' when found 'pick'.
            if (guess(mid) == 0) return mid;
            // Shrink the search space accordingly when 'pick' is greater or lesser.
            else if (guess(mid) == -1) high = mid - 1;
            else if (guess(mid) == 1) low = mid + 1;
        }
        // Return negative integer is not found.
        // Even though it is impossible to not find 'pick' in this question,
        // but it is a good practice to indicate that the search is not successful.
        return -1;
    }
}
