package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'citations'.
// We traverse 'citations' twice, once for counting sort and once for checking for the H-Index.
//
// Space Complexity : O(n),
// where 'n' is the length of 'citations'.
// The size counting array for the counting sort grows linearly with the size of the input 'citations'.

public class HIndex_CountingSort {

    // Approach:
    // The problem is asking us to find the maximum paper count with citation values greater than the paper count.
    // As such, we need to find the intersection between the paper count and the citations,
    // traversing the citation from least to greatest, and the paper count from greatest ot least.
    //
    // With counting sort, we can record the frequency of the citation.
    // As we are only checking 'n' number of papers, the citations greater than 'n' can be grouped together as 'n'.
    // Then, we check each citation in ascending order while decreasing the paper count,
    // the H-Index is when the paper count is less than or equal to citation,
    // with the remaining citations to be at least the number of paper.

    public int hIndex(int[] citations) {
        int n = citations.length;

        // The 'counting' array records the frequency of each citation,
        int[] counting = new int[n + 1];
        for (int citation : citations) {
            // with any citations greater than 'n' grouped together.
            if (citation > n) {
                counting[n]++;
            } else {
                counting[citation]++;
            }
        }

        // 'count' is the number of citations.
        int count = 0;
        // Traversing from the greatest to the least number of citations,
        for (int paper = n; paper > 0; paper--) {
            // add the citation to the count,
            count += counting[paper];
            // and check if the number of paper is less than or equal to the number of citations so far.
            if (paper <= count) return paper;
        }
        // If no number of paper is found to satisfy the requirement, return 0 H-Index.
        return 0;
    }
}
