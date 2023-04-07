package com.cheehwatang.leetcode;

// Time Complexity  : O(1),
// as the number of operations performed is independent of the input 'time'.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input 'time'.

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
        // ?? = 24 possibilities.
        if (hourMinute[0] == '?' && hourMinute[1] == '?') hours = 24;
        else if (hourMinute[0] == '?') {
            // ?3 (0 to 3) = 3 possibilities where ? = 0, 1 or 2.
            if (hourMinute[1] - '0' <= 3) hours = 3;
            // ?9 (4 to 9) = 2 possibilities where ? = 0 or 1.
            else hours = 2;
        } else if (hourMinute[1] == '?') {
            // 2? = 4 possibilities where ? = 0, 1, 2 or 3.
            if (hourMinute[0] == '2') hours = 4;
            // (0 or 1) 1? = 10 possibilities where ? = 0 to 9.
            else hours = 10;
        }

        // Section to check the minutes.
        int minutes = 1;
        // ?? = 60 possibilities.
        if (hourMinute[3] == '?' && hourMinute[4] == '?') minutes = 60;
        // ?0 = 6 possibilities where ? = 0 to 5.
        else if (hourMinute[3] == '?') minutes = 6;
        // 0? = 10 possibilities where ? = 0 to 9.
        else if (hourMinute[4] == '?') minutes = 10;

        return hours * minutes;
    }
}
