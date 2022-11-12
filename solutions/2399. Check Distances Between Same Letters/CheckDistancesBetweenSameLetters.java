package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of the string 's', because we traverse the string 's' once.
//
// Space Complexity : O(1),
// as we are modifying the 'distance' array in-place.

public class CheckDistancesBetweenSameLetters {

    // Approach:
    // For each first occurrence, check if the letter after distance[i] is the same.
    // Do note to make sure the index is within the length to prevent IndexOutOfBound error.

    public boolean checkDistances(String s, int[] distance) {
        int n = s.length();
        for (int i = 0, spaces; i < n; i++) {
            // Get the spaces between the two occurrences in the 'distance' array.
            spaces = distance[s.charAt(i) - 'a'];
            // For each letter that we checked, we change the distance[i] to -1.
            // If the letter is out of range or different, return false.
            if (spaces >= 0) {
                if (i + spaces + 1 >= n || s.charAt(i) != s.charAt(i + spaces + 1)) return false;
                distance[s.charAt(i) - 'a'] = -1;
            }
        }
        // If every letter is checked, return true.
        return true;
    }
}
