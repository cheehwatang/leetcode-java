package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is either 'num1' or 'num2', depending on which is greater.
// The operations range from O(1), when both numbers are the same, to O(n), when one of the number is 1.
// As it is hard to determine the time complexity based on the input,
// we can take the worst-case scenario when one of the number is 1.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the inputs.

public class CountOperationsToObtainZero {

    // Approach:
    // Using a while-loop and execute the stated conditions:
    // 1. when num1 >= num2, subtract num2 from num1, or
    // 2. when num2 > num1, subtract num1 from num2.
    //
    // Use a 'count' variable to record the count, and exit the loop when either number reaches 0.

    public int countOperations(int num1, int num2) {
        int count = 0;
        // While both 'num1' and 'num2' are greater than 0,
        while (num1 > 0 && num2 > 0) {
            // subtract 'num2' from 'num1' if "num1 >= num2", or
            if (num1 >= num2) num1 -= num2;
            // subtract 'num1' from 'num2' if "num1 < num2", or
            else num2 -= num1;
            // Increase count by 1 for each operation performed.
            count++;
        }
        return count;
    }
}
