package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of the longest string.
// This happens when the greatest common divisor is a string of length 1.
//
// Space Complexity : O(n),
// where 'n' is the length of the longest string.
// The maximum height of the recursive call stack is 'n' when the greatest common divisor is a string of length 1.

public class GreatestCommonDivisorOfStrings {

    // Approach:
    // Using Euclid's Algorithm from math for the strings' Greatest Common Divisor (GCD).
    // Euclid's algorithm has 2 main theorem:
    // 1. Subtracting the smaller number from the larger number does not change the GCD.
    //    (e.g. 6 - 4 = 2, the GCD remains as 2).
    // 2. If the smaller number exactly divides the larger number, the smallest number is the GCD.
    //    (e.g. 8 % 4 = 0, so 4 is the GCD)
    // The implementation of Euclid's Algorithm for whole numbers is as below:
    /*
    int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) return n1;
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
    */

    public String gcdOfStrings(String str1, String str2) {
        // If all of str2 is 'divided' and none remains, then str1 is the GCD.
        // Similar to "if (n2 == 0) return n1;"
        if (str2.equals("")) {
            return str1;
        }

        int length1 = str1.length();
        int length2 = str2.length();
        // Check if the shorter string is the same as the substring of same length of the longer string.
        // If it is the same, then we perform recursion of the smaller string and the 'remainder'.
        // Similar to "return gcdByEuclidsAlgorithm(n2, n1 % n2);" above, but we need to take note on the string length.
        if (length1 > length2) {
            if (str1.substring(0, length2).equals(str2)) {
                return gcdOfStrings(str2, str1.substring(length2));
            }
        } else{
            if (str2.substring(0, length1).equals(str1)) {
                return gcdOfStrings(str1, str2.substring(length1));
            }
        }

        // If the substring is not the same as the shorter string, then there are no GCD.
        return "";
    }
}
