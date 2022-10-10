package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem:
 * Given the coordinates of 4 points in a 2D plane, p1, p2, p3 and p4,
 * return true if the four points construct a valid square.
 * The coordinate of a point represents the [x,y] position.
 * A valid square has four sides of equal positive length and four 90-degrees angles.
 *
 *
 * Example 1:
 * Input    : p1 = [0,0], p2 = [0,1], p3 = [1,0], p4 = [1,1]
 * Output   : true
 *
 * Example 2:
 * Input    : p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
 * Output   : true
 *
 * Example 3:
 * Input    : p1 = [0,0], p2 = [0,2], p3 = [2,0], p4 = [3,1]
 * Output   : false
 *
 *
 * @author Chee Hwa Tang
 */

public class ValidSquare {

    // Approach:
    // A valid square with 90 degrees angle in each corner has the following properties:
    // 1. All 4 edges / sides have the same length.
    // 2. Contains 2 straight diagonal lines of equal length of the edge within the square.
    // There are a total of 6 lines that can be drawn among the 4 points :
    // p1p2, p1p3, p1p4, p2p3, p2p4 and p3p4.
    // So we can check if 6 lines fits within the 2 properties mentioned above.

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        // First, using Pythagorean Theorem, the square length of the line between two points
        // is calculated by the sum of the square of |x1 - x2| and the square of |y1 - y2|.
        // A little shortcut:
        // It is impossible for the 4 points to have lines of more than 2 distinct length to be a square.
        // Other than the case where a line with length of 0 (2 points at the same position),
        // we can be sure that it is a valid square if there is only 2 lengths stored in the HashSet.
        Set<Integer> set = new HashSet<>();
        set.add((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
        set.add((p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]));
        set.add((p1[0] - p4[0]) * (p1[0] - p4[0]) + (p1[1] - p4[1]) * (p1[1] - p4[1]));
        set.add((p2[0] - p3[0]) * (p2[0] - p3[0]) + (p2[1] - p3[1]) * (p2[1] - p3[1]));
        set.add((p2[0] - p4[0]) * (p2[0] - p4[0]) + (p2[1] - p4[1]) * (p2[1] - p4[1]));
        set.add((p3[0] - p4[0]) * (p3[0] - p4[0]) + (p3[1] - p4[1]) * (p3[1] - p4[1]));
        return set.size() == 2 && !set.contains(0);
    }
}
