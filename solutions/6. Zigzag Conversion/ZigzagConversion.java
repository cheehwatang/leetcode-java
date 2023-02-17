package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of the string 's'.
// We traverse the string 's' once to record the letters in the zigzag formation.
//
// Space Complexity : O(n),
// where 'n' is the length of the string 's'.
// As the letters are stored in the zigzag formation, the total length of the strings is the length of string 's'.

public class ZigzagConversion {

    // Approach:
    // Using StringBuilder, each correspond to the row.
    // We traverse the string 's' while traversing the StringBuilders in a down and up order,
    // each time appending the letter to the corresponding StringBuilder.

    public String convert(String s, int nRows) {
        int n = s.length();

        // Create an array of StringBuilder.
        StringBuilder[] stringArray = new StringBuilder[nRows];
        // Note to traverse the array and create a new StringBuilder for each.
        for (int i = 0; i < nRows; i++) stringArray[i] = new StringBuilder();

        // Continue the down and up traversal of the StringBuilder array until we finish traverse the string 's'.
        // 'index' keeps track of the position in the string 's'.
        int index = 0;
        while (index < n) {
            // Append of letter to the StringBuilder of the corresponding row when traversing down and up.

            // Traverse down from first row (i = 0) to the last row (i = nRows - 1).
            for (int i = 0; i < nRows && index < n; i++, index++)
                stringArray[i].append(s.charAt(index));

            // Traverse up from the second last row (i = nRows - 2) to the second row (i = 1).
            // Note that the first and last row is not repeated when traversing up.
            for (int i = nRows - 2; i >= 1 && index < n; i--, index++)
                stringArray[i].append(s.charAt(index));
        }

        // Append all the rows into the result StringBuilder.
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nRows; i++) result.append(stringArray[i]);

        // Return the final string result.
        return result.toString();
    }
}
