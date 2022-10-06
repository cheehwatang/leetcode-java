package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given an array of integers 'nums', return the greatest common divisor of the smallest and largest number in 'nums'.
 * The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
 *
 *
 * Example 1:
 * Input    : nums = [2,3,4,5,6]
 * Output   : 2
 * Explanation:
 * The greatest common divisor for smallest number, 2, and largest number, 6, is 2.
 *
 *
 * Example 2:
 * Input    : nums = [8,10,6,11,15]
 * Output   : 3
 * Explanation:
 * The greatest common divisor for smallest number, 6, and largest number, 15, is 3.
 *
 *
 * @author Chee Hwa Tang
 */

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

    private int gcd(int num1, int num2) {
        if (num2 == 0) return num1;
        return gcd(num2, num1 % num2);
    }
}
