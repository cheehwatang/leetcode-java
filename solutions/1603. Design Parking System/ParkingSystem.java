package com.cheehwatang.leetcode;

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */

// Time Complexity  : O(1).
// The addCar method has a constant time complexity.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input size.

public class ParkingSystem {

    // Approach:
    // Create a counting array 'lots' to keep track of the available lot for big, medium and small cars.
    // Each time the car is added, return true if the lot for the carType is greater than 0,
    // and reduce the count by 1 for that carType.

    // The counting array 'lots' is declared as a field in this 'ParkingSystem' class.
    int[] lots;
    public ParkingSystem(int big, int medium, int small) {
        // Instantiate the 'lots' array with big, medium and small.
        lots = new int[]{big, medium, small};
    }

    // Return true if the carType in 'lots' is greater than 0,
    // and reduce the count by 1.
    public boolean addCar(int carType) {
        return lots[carType - 1]-- > 0;
    }
}
