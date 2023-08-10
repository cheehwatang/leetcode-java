package com.cheehwatang.leetcode;

// Time Complexity  : O(m logn),
// where 'm' is the number of rows in 'grid', and 'n' is the number of columns in 'grid'.
// We traverse each row 'm' of the matrix ,
// and perform binary search to find the position of the leftmost negative number,
// with binary search having O(logn) time complexity.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input size.

public class CountNegativeNumbersInASortedMatrix_BinarySearch {

    // Approach:
    // Improving on the intuitive approach, we can perform binary search for each row
    // to find the leftmost negative number.
    // With the leftmost negative number, we can get the negative numbers of the row with "n - index".

    public int countNegatives(int[][] grid) {
        int columns = grid[0].length;

        int count = 0;
        // For each row in 'grid',
        for (int[] row : grid) {
            int left = 0, right = columns;
            // Perform binary search, with each iteration checking if row[mid] is negative number.
            while (left < right) {
                int mid = (right - left) / 2 + left;
                // If row[mid] is negative, check the right side by shifting 'right' to 'mid' + 1.
                if (row[mid] < 0)
                    right = mid;
                // If row[mid] is not negative, check the left side by shifting 'left' to 'mid'.
                else
                    left = mid + 1;
            }
            // The number of negative numbers of the row is 'columns - index',
            // in this case index can be 'left' or 'right'.
            count += (columns - left);
        }
        return count;
    }
}
