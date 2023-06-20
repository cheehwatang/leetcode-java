package com.cheehwatang.leetcode;

// Time Complexity  : O(logn),
// where 'n' is the length of 'citations'.
// We perform the binary search once, with O(logn) time complexity.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input size.

public class HIndexII {

    // Approach:
    // The problem is asking us to find the maximum paper count with citation values greater than the paper count.
    // As such, we need to find the intersection between the paper count and the citations,
    // checking each citation in ascending order while decreasing the paper count (n - i),
    // the H-Index is when the paper count is less than or equal to citation,
    // with the remaining citations to be at least the number of paper.
    //
    // We can optimize this with binary search,
    // checking lower citation number if we found an index fulfilling the H-Index condition,
    // or checking the higher citation number if the index fails the H-Index condition.
    // Continue to binary search until we find the H-Index.

    public int hIndex(int[] citations) {
        int n = citations.length;
        int start = 0;
        int end = n;

        int result = 0;
        // While the 'start' and 'end' pointers not meet,
        while (start < end) {
            // Get the midpoint.
            // Note: Performing "(end + start) / 2" does not result in overflow in this case,
            //       as the constraint is "1 <= n <= 10e5".
            // However, the operations below is recommended as best practice to prevent overflow.
            int mid = (end - start) / 2 + start;
            // The paper count with greater or equal citation is "n - mid".
            int paper = n - mid;

            // If the condition is met, record the result,
            // and check for the lower citation number (higher paper number).
            if (paper <= citations[mid]) {
                result = paper;
                end = mid;
            } else {
                // Else, check the higher citation number (lower paper number).
                start = mid + 1;
            }
        }
        return result;
    }
}
