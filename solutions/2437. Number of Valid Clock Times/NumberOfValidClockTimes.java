package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given a string 'time' with the format "hh:mm", with the time ranges from "00:00" to "23:59".
 * In 'time', some number digits are represented by a '?' unknown symbol, which can be replaced with a digit from 0 to 9.
 * Return the number of valid clock times that can be created by replacing every '?' in 'time'.
 *
 *
 * Example 1:
 * Input    : time = "??:??"
 * Output   : "1440"
 * Explanation: Possible choices for the hours are 24, and for minutes are 60, totalling 24 * 60 = 1440.
 *
 *
 * Example 2:
 * Input    : time = "?9:00"
 * Output   : "2"
 * Explanation: With the second digit of hour greater than 3, only '0' and '1' is possible, since hour 29 is invalid.
 *
 *
 * Example 3:
 * Input    : time = "00:?0"
 * Output   : "6"
 * Explanation: For the minutes, the first digit could possibly be from number 0 to 5.
 *
 * 
 * @author Chee Hwa Tang
 */

public class NumberOfValidClockTimes {

    // Approach:
    // The clock has few possible arrangements:
    // Hour:
    // ?? = 24 possibilities.
    // ?3 (0 to 3) = 3 possibilities where ? = 0, 1 or 2.
    // ?9 (4 to 9) = 2 possibilities where ? = 0 or 1. (with hour 29 not possible.)
    // 2? = 4 possibilities where ? = 0, 1, 2 or 3.
    // (0 or 1) 1? = 10 possibilities where ? = 0 to 9.
    // Minute:
    // ?? = 60 possibilities.
    // ?0 = 6 possibilities where ? = 0 to 5.
    // 0? = 10 possibilities where ? = 0 to 9.

    public int countTime(String time) {
        char[] hourMinute = time.toCharArray();

        // Section to check the hours.
        int hours = 1;
        if (hourMinute[0] == '?' && hourMinute[1] == '?') hours = 24;
        else if (hourMinute[0] == '?') {
            if (hourMinute[1] - '0' <= 3) hours = 3;
            else hours = 2;
        } else if (hourMinute[1] == '?') {
            if (hourMinute[0] == '2') hours = 4;
            else hours = 10;
        }

        // Section to check the minutes.
        int minutes = 1;
        if (hourMinute[3] == '?' && hourMinute[4] == '?') minutes = 60;
        else if (hourMinute[3] == '?') minutes = 6;
        else if (hourMinute[4] == '?') minutes = 10;

        return hours * minutes;
    }
}
