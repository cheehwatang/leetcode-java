package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given a positive integer 'n', return the n-th term of the count-and-say sequence.
 * Note that 'n' is from 1 to 30 inclusive.
 * A count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * - countAndSay(1) = "1",
 * - countAndSay(n) is the way you would say the digit string from countAndSay(n - 1),
 * which is then converted into a different digit string.
 * For example: countAndSay(2) = "11", by counting 1 "1" in countAndSay(1).
 *
 *
 * Example 1:
 * Input    : n = 2
 * Output   : "11"
 * Explanation: countAndSay(1) = "1", countAndSay(2) = say "1" = 1 "1" = "11"
 *
 *
 * Example 2:
 * Input    : n = 5
 * Output   : "111221"
 * Explanation:
 * - countAndSay(1) = "1",
 * - countAndSay(2) = = say "1" = 1 "1" = "11";
 * - countAndSay(3) = = say "11" = 2 "1" = "21";
 * - countAndSay(4) = = say "21" = 1 "2" + 1 "1" = "1211";
 * - countAndSay(5) = = say "1211" = 1 "1" + 1 "2" + 2 "1" = "111221";
 *
 *
 * @author Chee Hwa Tang
 */

public class CountAndSay_Recursive {

    // Approach:
    // Use either String itself, or StringBuilder.
    // For longer string, StringBuilder is faster and uses less memory.
    // Recursively using countAndSay(n - 1) until the call stack hit the base case,
    // check each digit in the countAndSay(n - 1) string, using a 'count' variable.
    // Then input into the result.

    public String countAndSay(int n) {
        // Base case.
        if (n == 1) return "1";

        // Recursive call for n - 1.
        // The count-and-say algorithm will continue when the top of the call stack hits the base case.
        String result = countAndSay(n - 1);

        // 'say' is the result for countAndSay(n), whereas 'result' is the result for countAndSay(n - 1).
        StringBuilder say = new StringBuilder();
        // Since we start from index 0 in the string, there is no previous digit, so assign -1 to start.
        int prevDigit = -1;
        int count = 0;

        for (int j = 0; j < result.length(); j++) {
            int digit = result.charAt(j) - '0';
            // If we are at the start of the string, or current digit is the same as previous digit, increase the count.
            if (prevDigit == -1 || digit == prevDigit) count++;

            // Once we found a digit that is different, we can append the 'count' and the 'prevDigit' to 'say'.
            // Update the 'count' and 'prevDigit' to restart.
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
