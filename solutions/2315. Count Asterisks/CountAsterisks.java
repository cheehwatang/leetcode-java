package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given a string 's', count the asterisk symbol '*' in the string,
 * excluding the '*' between each pair of vertical bars '|'.
 * The vertical bars '|' are considered a pair, for every 2 consecutive vertical, i.e. 1st and 2nd, 3rd and 4th, etc.
 * Note that each '|' is belonged to exactly one pair.
 *
 *
 * Example 1:
 * Input    : "l*|ee*t|c**o|de*|"
 * Output   : 3
 * Explanation:
 * Only the section 'l*' and 'c**o' counts.
 *
 *
 * Example 2:
 * Input    : "kee*|p*up*|*t*he|*g*ood*|*w**ork"
 * Output   : 6
 * Explanation:
 * Only the section 'kee*', '*t*he' and '*w**ork' counts.
 *
 *
 * @author Chee Hwa Tang
 */

public class CountAsterisks {

    public int countAsterisks(String s) {

        // Convert the string into char array.
        char[] characters = s.toCharArray();

        int count = 0;
        boolean isCounting = true;

        for (char character : characters) {
            // Count the asterisks only when isCounting == true. Flip isCounting when encounter the '|' symbol.
            if (isCounting && character == '*') {
                count++;
            } else if (character == '|') {
                isCounting = !isCounting;
            }
        }
        return count;
    }
}
