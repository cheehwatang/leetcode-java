package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n logn),
// where 'n' is the length of 'citations'.
// The Arrays.sort() method implements Dual-Pivot Quicksort, which has a O(n logn) time complexity.
// Additionally, we traverse 'citations' once to get the H-Index.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input size.

public class HIndex_Sorting {

    // Approach:
    // The problem is asking us to find the maximum paper count with citation values greater than the paper count.
    // As such, we need to find the intersection between the paper count and the citations,
    // traversing the citation from least to greatest, and the paper count from greatest ot least.
    //
    // This is achieved by first sorting 'citations' array.
    // Checking each citation in ascending order while decreasing the paper count,
    // the H-Index is when the paper count is less than or equal to citation,
    // with the remaining citations to be at least the number of paper.

    public int hIndex(int[] citations) {
        // Sort the citations in ascending order.
        Arrays.sort(citations);

        // 'count' is the number of paper.
        int count = citations.length;
        // Traversing from the least to the greatest number of citations,
        for (int citation : citations) {
            // and check if the number of paper is less than the current citation.
            // If it is, then the 'count' is the H-Index.
            // Note that the 'citations' is in ascending order,
            // thus the remaining citations are at least 'count'.
            if (count <= citation) {
                return count;
            }
            // Reduce the 'count' for each citation checked.
            count--;
        }
        return count;
    }
}
