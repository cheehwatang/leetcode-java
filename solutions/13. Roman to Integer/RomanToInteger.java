package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given a valid Roman numeral, return the integer value.
 * 
 * Note:
 * Basics of Roman numeral:
 * I = 1
 * V = 5
 * X = 10
 * L = 50
 * C = 100
 * D = 500
 * M = 1000
 *
 * Written with the largest to smallest from left to right, with following priorities:
 * Thousands(M) -> Hundreds(D,C) -> Tens(L,X) -> Ones(V,I)
 *
 * Example 1: XXXVII = XXX(3 * 10) + V(5) + II(2 * 1) = 37
 *
 * Roman numerals represent 4 and 9 with the following:
 * 4 = IV (not IIII), 9 = IX (not VIIII)
 *
 * Likewise for 40 = XL, 90 = XC, 400 = CD and 900 = CM.
 *
 * @author Chee Hwa Tang
 */

public class RomanToInteger {

    // Generally, the Roman characters increases in value from right to left. However...
    // Notice the pattern in the Roman numeral, where IV = 5 - 1, IX = 10 - 1, XL = 50 - 10 etc.
    // Whenever the left (eg I) is less than the right (eg X), we will deduct left (in this case 1).
    // Thus, we will keep track of the previous value to compare.

    public int romanToInt(String s) {
        int sum = 0;
        int previous = 0;
        int current = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            char letter = s.charAt(i);
            switch (letter) {
                case 'I':
                    current = 1;
                    break;
                case 'V':
                    current = 5;
                    break;
                case 'X':
                    current = 10;
                    break;
                case 'L':
                    current = 50;
                    break;
                case 'C':
                    current = 100;
                    break;
                case 'D':
                    current = 500;
                    break;
                case 'M':
                    current = 1000;
                    break;
            }
            sum = current >= previous ? sum + current : sum - current;
            previous = current;
        }
        return sum;
    }
}
