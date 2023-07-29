package com.cheehwatang.leetcode;

// Time Complexity  : O(logn),
// where 'n' is the length of 'letters'.
// We perform binary search to find the first letter that is lexicographically greater than 'target'.
// Binary search has O(logn) time complexity.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input size.

public class FindSmallestLetterGreaterThanTarget_BinarySearch {

    // Approach:
    // As 'letters' is sorted in non-descending order,
    // we can perform binary search to find the letter that is the least greater than 'target'.
    // If the element is not found, with 'low' and 'high' reaches letters.length, return the first element.

    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length;
        while (low < high) {
            // The implementation below prevents integer overflow.
            int mid = (high - low) / 2 + low;
            // Shift the 'high' pointer to the right if the letter is lexicographically greater than 'target'.
            if (letters[mid] - target > 0) {
                high = mid;
            }
            // Shift the 'low' pointer to the left otherwise.
            else {
                low = mid + 1;
            }
        }
        // If the pointer is outside the array, return the first element.
        // Else, return the letter greater than 'target' with the least difference.
        return low == letters.length ? letters[0] : letters[low];
    }
}
