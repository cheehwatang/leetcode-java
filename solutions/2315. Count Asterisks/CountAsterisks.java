package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of string 's'.
// We traverse the string 's' to check and count the asterisks.
//
// Space Complexity : O(n),
// where 'n' is the length of string 's'.
// We convert the string 's' into char array with the same size.
// Note: We can achieve constant time O(1) by using index when checking for vertical bar and asterisks.

public class CountAsterisks {

    // Approach:
    // Using a boolean variable to flag whether to count the asterisks.
    // The boolean variable 'isCounting' is first set to true as we start from outside the vertical bar pair.
    // When encounter vertical bar, we toggle 'isCounting', and only count the asterisks '*' when 'isCounting' is true.

    public int countAsterisks(String s) {
        int count = 0;
        boolean isCounting = true;

        for (char character : s.toCharArray()) {
            // Count the asterisks only when isCounting == true. Flip isCounting when encounter the '|' symbol.
            if (isCounting && character == '*')
                count++;
            else if (character == '|')
                isCounting = !isCounting;
        }
        return count;
    }
}
