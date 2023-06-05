package com.cheehwatang.leetcode;

// Time Complexity  : O(n^2),
// where 'n' is the input 'n'.
// We recursively call the countAndSay() function 'n' times.
// Approximating the length of the strings are length 'n',
// traversal of the string for each recursion would result in O(n^2) time complexity.
//
// Space Complexity : O(n),
// where 'n' is the input 'n'.
// The recursive call stack has a maximum height of 'n'.
// Note:
// It is difficult to determine the full space complexity due to the uncertain length of the result string.
// Approximating the length of the strings are length 'n',
// the memory used by the StringBuilder for each recursive call would result in O(n^2).

public class CountAndSay_Recursive {

    // Approach:
    // Use either String itself, or StringBuilder.
    // For longer string, StringBuilder is faster and uses less memory.
    // Recursively using countAndSay(n - 1) until the call stack hit the base case,
    // and check each digit in the countAndSay(n - 1) string using a 'count' variable.
    // Once finish counting, append the 'count' and the digit to the result.

    public String countAndSay(int n) {
        // Base case.
        if (n == 1) return "1";

        // Recursive call for 'n - 1'.
        // The count-and-say algorithm will continue when the top of the call stack hits the base case.
        String result = countAndSay(n - 1);

        // 'say' is the result for countAndSay(n), whereas 'result' is the result for countAndSay(n - 1).
        StringBuilder say = new StringBuilder();
        // Since we start from index 0 in the string, there is no previous digit, so assign -1 to 'prevDigit'.
        int prevDigit = -1;
        int count = 0;

        for (char character : result.toCharArray()) {
            int digit = character - '0';
            // Increase the count if we are at the start of the string,
            // or current digit is the same as previous digit.
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

        return say.toString();
    }
}
