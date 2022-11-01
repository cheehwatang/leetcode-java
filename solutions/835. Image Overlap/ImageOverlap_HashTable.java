package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem:
 * Given two images, 'img1' and 'img2', represented as binary in a square matrices of size n * n,
 * return the largest possible overlap of the 1s in both images,
 * where we can translate one image however we choose by sliding in any combinations of directions.
 *
 *
 * Example 1:
 * Input    : img1 = [[1,1],[1,0]], img2 = [[0,1],[0,1]]
 *            img1 = | 1 | 1 |      img2 = | 0 | 1 |
 *                   | 1 | 0 |             | 0 | 1 |
 * Output   : 2
 * Explanation : Largest overlap of 2, when we slide 'img1' right by 1 unit.
 *
 *
 * Example 2:
 * Input    : img1 = [[1,1,0],[0,1,1],[1,1,0], img2 = [[0,0,0],[1,1,1],[0,0,1]
 *            img1 = | 1 | 1 | 0 |             img2 = | 0 | 0 | 0 |
 *                   | 0 | 1 | 1 |                    | 1 | 1 | 1 |
 *                   | 1 | 1 | 0 |                    | 0 | 0 | 1 |
 * Output   : 3
 * Explanation : Largest overlap of 3, when we slide 'img1' right by 1 unit and down by 1 unit,
 *               or just shift 'img1' down by 1 unit.
 *
 *
 * @author Chee Hwa Tang
 */

public class ImageOverlap_HashTable {

    // Approach:
    // Every 1 in 'img1' has a certain relationship with the 1s in 'img2',
    // in terms of the differences in the 'row' and 'column.
    // Using Example 2 above, img1[0][0] has the same 'row' with img2[1][0], but 1 unit more in 'column'.
    //
    // If two points in 'img1' overlaps with two points in 'img2',
    // then this two pairs has the same 'row' and 'column' differences.
    // As such, we can use a Hash Table to keep track on the frequency of the 'row' and 'column' differences,
    // and return the 'row' and 'column' difference with the highest frequency.

    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<Integer> coordinates1 = new ArrayList<>();
        List<Integer> coordinates2 = new ArrayList<>();
        // Using n * n to traverse row by row, with the row = i / n, and column = i % n.
        for (int i = 0; i < n * n; i++) {
            // With the constraint of 1 <= n <= 30,
            // we can use XX00 to store the 'row', and 00XX to store the 'column'.
            int hash = (i / n * 100) + (i % n);
            // Only store the 'hash' if it contains a 1.
            if (img1[i / n][i % n] == 1) coordinates1.add(hash);
            if (img2[i / n][i % n] == 1) coordinates2.add(hash);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        // Compare all the coordinates from 'img1' containing 1 with the coordinates from 'img2' containing 1.
        // Use the HashMap to store the differences, and find the maximum number of overlap.
        for (int i : coordinates1) {
            for (int j : coordinates2) {
                map.put(i - j, map.getOrDefault(i - j, 0) + 1);
                max = Math.max(max, map.get(i - j));
            }
        }
        return max;
    }
}
