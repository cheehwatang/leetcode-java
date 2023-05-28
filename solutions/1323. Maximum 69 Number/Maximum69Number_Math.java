package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the number of digits in 'num'.
// Traverse 'num' from right to left using the division operator.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input.

public class Maximum69Number_Math {

    // Approach:
    // For any number, changing the first digit 6 to 9 from left to right yields the maximum number.
    // This is also known as to be Greedy as we only need to find the first digit 6.
    //
    // Using math to traverse an integer from right to left, it is done using division '/' and remainder '%' operations.
    // Checking for the digit 6, and change the leftmost digit 6 to 9.
    // We use a variable 'previous' to record the previous number that we changed, and
    // a variable 'increment' to record the increment we used previously to change the digit 6 to digit 9.
    // Traversing from right to left, we add the increment each time we find a 6,
    // while subtracting the previous increment that we used to change the previously changed 9 back to 6.

    public int maximum69Number (int num) {
        int result = num;
        // 'previous' is set 0 to start as there are no previous number change.
        int previous = 0;
        // Since we are only changing 6 to 9, we only need to add
        // the increment of 3 (and its 10 powers such as 30, 300 or 3000), if the digit is 6.
        // As we start from right to left, the first increment is 3.
        int increment = 3;

        while (num > 0) {
            // Check if the current digit is 6.
            if (num % 10 == 6) {
                // Change the 6 to 9, with "result + increment".
                // Change the previously changed 6 (if any), back to 6 with "result - previous".
                result = result - previous + increment;
                // Update 'previous'.
                previous = increment;
            }
            // Increase the increment by factor of 10 while traversing 'num' to the left.
            increment *= 10;
            num /= 10;
        }
        return result;
    }
}
