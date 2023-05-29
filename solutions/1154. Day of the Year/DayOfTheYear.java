package com.cheehwatang.leetcode;

// Time Complexity  : O(n + m),
// where 'n' is the length of string 'date', and 'm' is the month.
// We split the string which has a linear time complexity to the length of the string.
// Then, we traverse the 'dayOfMonth' array for the number of months to get the day sum of the previous months.
//
// Space Complexity : O(n + 12),
// where 'n' is the length of string 'date'.
// The String.split() method results in creation of strings with total length of 'date'.
// The 'dayOfMonth' array has length of 12.

public class DayOfTheYear {

    // Approach:
    // Use an array of day in the months.
    // For each year, check for leap year and adjust the day in February accordingly.
    // Then, iterate from 0 to the previous month to sum the days in the previous month.
    // For that month, we sum the day of the month.

    public int dayOfYear(String date) {
        // Split the date String to the year, month and day.
        String[] str = date.split("-");

        // Array for the day of the month.
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
