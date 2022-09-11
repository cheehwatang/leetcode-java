package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given an Integer value, return the Roman numeral in String.
 *
 * Notes:
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

public class IntegerToRoman {

    public String intToRoman(int num) {

        // Comments:
        // This method uses two arrays with the corresponding integer-roman map, in descending order.

        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romanNumeral = new StringBuilder();

        for (int i = 0; i < value.length && num > 0; i++) {
            while (num >= value[i]) {
                romanNumeral.append(roman[i]);
                num -= value[i];
            }
        }
        return romanNumeral.toString();
    }
}
