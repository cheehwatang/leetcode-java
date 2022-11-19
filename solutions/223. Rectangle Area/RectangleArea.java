package com.cheehwatang.leetcode;

// Time Complexity  : O(1),
// as no iteration is performed, only simple arithmetic calculations.
//
// Space Complexity : O(1),
// as only fixed variables are created.

public class RectangleArea {

    // Approach:
    // The area of a rectangle is the product of the sides on the x-axis and y-axis,
    // which is the difference of the x-coordinates and y-coordinates of the two diagonal corners.
    // For the overlap, we find the coordinates which is explained below, and get the product of its corners.
    // Using x-coordinates as example:
    // Rectangle A:         |           |          * Indicates the max for x1 and min for x2.
    //                     ax1*         ax2
    // Rectangle B:     |          |
    //                 bx1        bx2*
    // The overlap on the left is Math.max(ax1, bx1), while the right is Math.min(ax2, bx2).
    // The same applies for the y-coordinates.
    // If there are no overlap, then (Math.min(ax2, bx2) <= Math.max(ax1, bx1)) == (bx2 <= ax1).
    // Rectangle A:                     |           |       * Indicates the max for x1 and min for x2.
    //                                 ax1*         ax2
    // Rectangle B:     |          |
    //                 bx1        bx2*

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        // It is helpful that ax2 > ax1, ay2 > ay1, bx2 > bx1, by2 > by1,
        // so there is no need to perform checks on the corner coordinates.
        // Calculate the area if rectangle A and B.
        int areaA = (ax2 - ax1) * (ay2 - ay1);
        int areaB = (bx2 - bx1) * (by2 - by1);

        // If there are any overlap, the top right corner coordinates of the overlap
        // will be the minimum of the top right of both A and B.
        int top = Math.min(ay2, by2);
        int right = Math.min(ax2, bx2);

        // Likewise for the bottom left corner is the maximum of the bottom left of both A and B.
        int bottom = Math.max(ay1, by1);
        int left = Math.max(ax1, bx1);

        // If the top right corner and bottom left corner is not in the correct position,
        // then rectangle A and B do not overlap.
        // There are overlap only if top > bottom and right > left.
        int overlap = 0;
        if (top > bottom && right > left)
            overlap = (top - bottom) * (right - left);

        // The total area covered is rectangle A and rectangle B, except for the double count of overlap, if any.
        return areaA + areaB - overlap;
    }
}
