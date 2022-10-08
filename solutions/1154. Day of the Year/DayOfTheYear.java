package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given a string 'date' representing a Gregorian calendar date formatted as 'YYYY-MM-DD',
 * return the number of days of the year.
 *
 *
 * Example 1:
 * Input    : date = "2018-01-10"
 * Output   : 10
 * Explanation: The date is the 10th day of 2018.
 *
 *
 * Example 2:
 * Input    : date = "2018-03-01"
 * Output   : 60
 * Explanation: The date is the 60th day of 2018.
 *
 *
 * Example 3:
 * Input    : date = "2016-03-01"
 * Output   : 61
 * Explanation: The date is the 61st day of 2016.
 *
 *
 * @author Chee Hwa Tang
 */

public class DayOfTheYear {

    // Approach:
    // Use a database of day in the months. Check for leap year and adjust the day in February accordingly.

    public int dayOfYear(String date) {

        // Split the date String to the year, month and day.
        String[] str = date.split("-");

        // Data for the day of the month.
        int[] dayOfMonth = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};

        // If the year is a leap year, increase the day in February (index 1) by 1.
        if (isLeapYear(Integer.parseInt(str[0]))) dayOfMonth[1] = 29;

        // Sum all the days in the previous months.
        int day = 0;
        for (int i = 0; i < Integer.parseInt(str[1]) - 1; i++) {
            day += dayOfMonth[i];
        }
        // Add the day to the total sum and return.
        return day + Integer.parseInt(str[2]);
    }

    // Method to check if the year is a leap year in the Gregorian calendar.
    private boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        return year % 100 != 0 && year % 4 == 0;
    }
}
