package com.cheehwatang.leetcode;

// Time Complexity  : O(n^2),
// where 'n' is the input 'n'.
// We iterate from 2 to 'n'.
// Approximating the length of the strings are length 'n',
// traversal of the string for each iteration would result in O(n^2) time complexity.
//
// Space Complexity : O(n),
// where 'n' is the input 'n'.
// The length of the string created is approximately 'n' for each iteration.

public class CountAndSay_Iterative {

    // Approach:
    // Use either String itself, or StringBuilder.
    // For longer string, StringBuilder is faster and uses less memory.
    // Iteratively from 1 to n, check each digit in the countAndSay(n - 1) string using a 'count' variable.
    // Once finish counting, append the 'count' and the digit to the result.

    public String countAndSay(int n) {
        // Base case.
        if (n == 1) return "1";

        String result = "1";
        for (int i = 2; i <= n; i++) {
            // 'say' is the result for countAndSay(i), whereas 'result' is the result for countAndSay(i - 1).
            StringBuilder say = new StringBuilder();
            // Since we start from index 0 in the string, there is no previous digit, so assign -1 to start.
            int prevDigit = -1;
            int count = 0;

            for (char character : result.toCharArray()) {
                int digit = character - '0';
                // If we are at the start of the string, or current digit is the same as previous digit, increase the count.
                if (prevDigit == -1 || digit == prevDigit) count++;

                // Once we found a digit that is different, we can append the 'count' and the 'prevDigit' to 'say'.
                // Restart the 'count' at 1.
                else {
                    say.append(count);
                    say.append(prevDigit);
                    count = 1;
                }
                prevDigit = digit;
            }
            // Since the loop ended with 1 unrecorded sequence, we append them to 'say'.
            say.append(count);
            say.append(prevDigit);
            // Update the 'result' to 'say' and continue the iteration.
            result = say.toString();
        }
        return result;
    }
}
