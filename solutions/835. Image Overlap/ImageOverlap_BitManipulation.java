package com.cheehwatang.leetcode;

// Time Complexity  : O(n^3),
// where 'n' is the number of rows in 'img1' and 'img2'.
// We traverse both 'img1' and 'img2' once to convert the rows into binaries represented by an integer,
// which results in time complexity of O(n^2).
// Next, we shift the images in both axes, for iterating through each of the 4 directions.
// Since we use the bitwise shift operators '<<' and '>>', the time complexity lowers to O(n^3).
// This results in the final time complexity of O(n^3).
//
// Space Complexity : O(n),
// where 'n' is the number of rows in 'img1' and 'img2'.
// We use 2 arrays of length 'n' to store the rows (after conversion to binaries and stored as bits) of both images.

public class ImageOverlap_BitManipulation {

    // Approach:
    // This is basically a brute force technique by translating 'img1' in all the possible combinations.
    // which will result in a O(n^4) time complexity, 'n' to translate horizontally, nest 'n' to translate vertically,
    // nest 'n' to traverse every row, nest 'n' to traverse every column.
    // For improvement, we can use Bit Manipulation to lower the time complexity to O(n^3).
    // Given the constraint of 1 <= n <= 30, O(n^3) is possible as a solution without getting the TimeLimitExceeded notice.
    // Using a primitive type int that can store maximum 2 ^ 31 - 1,
    // we can store the rows as binary using the left shift '<<' operator and bitwise OR '|' operation.
    //
    // When comparing for overlap, we can simply use bitwise AND '&' operation, for each row.
    // Bit Manipulation allows us to reduce time complexity by reducing the need to traverse the row to check for overlap.
    // Note:
    // As we need to left shift by 'n' when checking for overlap, resulting in a number of 2^60,
    // we need to use type long which stores up to 2^63 - 1.

    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        long[] image1 = new long[n];
        long[] image2 = new long[n];
        // Convert the rows into binary.
        for (int i = 0; i < n; i++) {
            int binary1 = 0; int binary2 = 0;
            for (int bit : img1[i]) binary1 = (binary1 << 1) | bit;
            for (int bit : img2[i]) binary2 = (binary2 << 1) | bit;
            image1[i] = binary1;
            image2[i] = binary2;
        }

        int max = 0;
        // 'i' is used to shift left or right.
        for (int i = 0; i < n; i++) {
            // 'j' is used to shift up or down.
            for (int j = 0; j < n; j++) {
                int countDownRight = 0;
                int countDownLeft = 0;
                int countUpRight = 0;
                int countUpLeft = 0;
                for (int k = 0; k < n - j; k++) {
                    // Shift down, by comparing image1[k] with image2[k + j]
                    countDownRight += Long.bitCount(image1[k] >> i & image2[k + j]);
                    countDownLeft += Long.bitCount(image1[k] << i & image2[k + j]);
                    // Shift up, by comparing image1[k + j] with image2[k]
                    countUpRight += Long.bitCount(image1[k + j] & image2[k] << i);
                    countUpLeft += Long.bitCount(image1[k + j] & image2[k] >> i);
                }
                // Check for the maximum for all 4 directions of translation.
                max = Math.max(max, Math.max(Math.max(countDownRight, countDownLeft), Math.max(countUpRight, countUpLeft)));
            }
        }
        return max;
    }
}
