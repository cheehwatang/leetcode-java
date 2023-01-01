package com.cheehwatang.leetcode;

// Time Complexity  : O(sqrt(n)),
// where 'n' is the area, with the worst case is that the area is a prime number, thus only a width of 1 is possible.
//
// Space Complexity : O(1),
// as only fixed variable is used.

public class ConstructTheRectangle {

    // Approach:
    // As we know the greatest width possible is the square-root of 'area'.
    // However, as the result only accepts int, not double,
    // we can use the remainder operator % to find the greatest 'width' that fully divides 'area'.
    // The first possible 'width' is the width with the least difference to 'length'.

    public int[] constructRectangle(int area) {
        // Reminder: Result == [L, W]

        // Starts 'width' as the square-root of 'area' as we need to satisfy 'width' <= 'length'.
        int width = (int) Math.sqrt(area);

        // Continue to reduce 'width' (at the same time extends 'length'),
        // until we found a 'width' that fully divides 'area'.
        while (area % width != 0) width--;

        return new int[]{area / width, width};
    }
}
