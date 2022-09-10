package com.cheehwatang.leetcode;

/**
 * Given a valid Roman numeral, return the integer value.
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
 * Note: Roman numerals represent 4 and 9 with the following:
 * 4 = IV (not IIII), 9 = IX (not VIIII)
 *
 * Likewise for 40 = XL, 90 = XC, 400 = CD and 900 = CM.
 *
 * @author Chee Hwa Tang
 */

public class RomanToInteger {

    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            switch (letter) {
                case 'M':
                    sum += 1000;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'C':
                    // check if any symbol after 'C', as need to evaluate if it has CM = 900, or CD = 400.
                    if (i != s.length() - 1) {
                        if (s.charAt(i+1) == 'M') {
                            sum += 900;
                            i++;
                            break;
                        } else if (s.charAt(i+1) == 'D') {
                            sum += 400;
                            i++;
                            break;
                        }
                    }
                    sum += 100;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'X':
                    // check if any symbol after 'X', as need to evaluate if it has XC = 90, or XL = 40.
                    if (i != s.length() - 1) {
                        if (s.charAt(i+1) == 'C') {
                            sum += 90;
                            i++;
                            break;
                        } else if (s.charAt(i+1) == 'L') {
                            sum += 40;
                            i++;
                            break;
                        }
                    }
                    sum += 10;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'I':
                    // check if any symbol after 'I', as need to evaluate if it has IX = 9, or IV = 4.
                    if (i != s.length() - 1) {
                        if (s.charAt(i+1) == 'X') {
                            sum += 9;
                            i++;
                            break;
                        } else if (s.charAt(i+1) == 'V') {
                            sum += 4;
                            i++;
                            break;
                        }
                    }
                    sum += 1;
                    break;
            }
        }
        return sum;
    }
}
