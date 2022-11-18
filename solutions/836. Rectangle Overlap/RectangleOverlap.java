package com.cheehwatang.leetcode;

// Time Complexity  : O(1),
// as no iteration is performed, only simple arithmetic calculations.
//
// Space Complexity : O(1),
// as only fixed variables are created.

public class RectangleOverlap {

    // Approach:
    // For the overlap, we find the coordinates which is explained below.
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

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Reminder: rec[0] == x1, rec[1] == y1, rec[2] == x2, rec[3] == y2.

        // If there are any overlap, the top right corner coordinates of the overlap
        // will be the minimum of the top right of both A and B.
        int top = Math.min(rec1[3], rec2[3]);
        int right = Math.min(rec1[2], rec2[2]);

        // Likewise for the bottom left corner is the maximum of the bottom left of both A and B.
        int bottom = Math.max(rec1[1], rec2[1]);
        int left = Math.max(rec1[0], rec2[0]);

        // There are overlap only if top > bottom and right > left.
        return top > bottom && right > left;
    }
}
