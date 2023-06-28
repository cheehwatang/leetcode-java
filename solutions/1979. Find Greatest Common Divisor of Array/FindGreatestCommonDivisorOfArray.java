package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse 'nums' once to find the minimum and the maximum number.
//
// Space Complexity : O(1),
// as the recursive call stack is not quantifiable from the input, thus we can assume that the memory used is constant.
// The recursive method can be implemented iteratively.

public class FindGreatestCommonDivisorOfArray {

    // Approach:
    // Using Euclid's Algorithm from math for the strings' Greatest Common Divisor (GCD).
    // Euclid's algorithm has 2 main theorem:
    // 1. Subtracting the smaller number from the larger number does not change the GCD.
    //    (e.g. 6 - 4 = 2, the GCD remains as 2).
    // 2. If the smaller number exactly divides the larger number, the smallest number is the GCD.
    //    (e.g. 8 % 4 = 0, so 4 is the GCD)

    public int findGCD(int[] nums) {

        // With the smallest number and largest number for Integer is Integer.MIN_VALUE and Integer.MAX_VALUE respectively,
        // any number smaller than the MAX_VALUE is the new minimum, and vice versa for the maximum.
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Traverse 'nums' to get the minimum and maximum values.
        for (int number : nums) {
            if (number < min) min = number;
            if (number > max) max = number;
        }

        // Euclid's algorithm.
        return gcd(max, min);
    }

    // Recursive method to find the Greatest Common Divisor of 2 integers.
    private int gcd(int num1, int num2) {
        if (num2 == 0) return num1;
        return gcd(num2, num1 % num2);
    }
}
