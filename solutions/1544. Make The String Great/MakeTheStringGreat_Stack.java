package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of string 's'.
// We traverse the string 's' once to check for the bad pair.
//
// Space Complexity : O(n),
// where 'n' is the length of string 's'.
// We use StringBuilder which scales linearly with the length of string 's',
// and the final result string also scales linearly with the length of string 's'.

public class MakeTheStringGreat_Stack {

    // Approach:
    // Using stack to check for the bad character pairs is suitable here,
    // because some bad character pairs can be found after other character pairs are removed, for example "abcCBA" -> "".
    //
    // To check if the adjacent characters are the same letter with different case,
    // we can check if the two characters are of lower and upper case, if they are different by 32,
    // This is because the ASCII value for 'a' is 97, and 'A' is 65, with 97 - 65 == 32.

    public String makeGood(String s) {
        int n = s.length();
        // Rather than using Stack<> and StringBuilder together, we can just use a StringBuilder for the function of stack,
        // by checking the last / rightmost character in the StringBuilder.
        // Since the StringBuilder is backed by an array with default initial capacity of 16,
        // we can set the initial capacity to the maximum length possible to prevent inefficiency in resizing when
        // s.length() > 16.
        StringBuilder stringBuilder = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            // Check if the 'stringBuilder' is empty, as it results in IndexOutOfBound error if not checked.
            // Using Math.abs(), we can check if the two characters are of different cases but same letter,
            // regardless which is lowercase or uppercase.
            // If found the bad pair, remove the rightmost character in the 'stringBuilder', like a stack.
            if (stringBuilder.length() > 0 && Math.abs(current - stringBuilder.charAt(stringBuilder.length() - 1)) == 32)
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            // If not, then add the character to the 'stringBuilder'.
            else stringBuilder.append(current);
        }
        return stringBuilder.toString();
    }
}
