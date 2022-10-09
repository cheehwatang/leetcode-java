package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given an integer of 'candies' and a row of people 'num_people', distribute the candies in the following manner:
 * Give 1 candy to the first person, 2 candies to the second person, and so on until we give n = num_people of candies
 * to the last person. Then we repeat the row by giving n + 1 candies to the first person and so on.
 * If the remaining candies are less than the number of candies that should be given to the person,
 * that person will receive all the remaining candies.
 * Return an array representing the final distribution of the candies.
 *
 *
 * Example 1:
 * Input    : candies = 7, num_people = 3
 * Output   : [2,2,3]
 * Explanation:
 * 1. Index 0 receives 1 candy, the array is [1,0,0].
 * 2. Index 1 receives 2 candies, the array is [1,2,0].
 * 3. Index 2 receives 3 candies, the array is [1,2,3].
 * 4. Return to Index 0, receives the remaining 1 candy, the array is [2,2,3].
 *
 *
 * Example 2:
 * Input    : candies = 15, num_people = 3
 * Output   : [5,7,3]
 * Explanation:
 * 1. Index 0 receives 1 candy, the array is [1,0,0].
 * 2. Index 1 receives 2 candies, the array is [1,2,0].
 * 3. Index 2 receives 3 candies, the array is [1,2,3].
 * 4. Return to Index 0, receives 4 candies, the array is [5,2,3].
 * 5. Index 1 receives 5 candies, the array is [5,7,3].
 *
 *
 * @author Chee Hwa Tang
 */

public class DistributeCandiesToPeople {

    // Approach:
    // Use two variables, one to track the index of the person and another to track the candy that should be given.
    // Then rotate the index while slowly reduce the total number of candies, while increasing the candy count.
    // Record the result in an int[].

    public int[] distributeCandies(int candies, int num_people) {

        // Integer array to record the distribution of candies.
        int[] distribution = new int[num_people];

        int person = 0;
        int candy = 1;

        // While the still have candies, add the candy count to the int[], and reduce the candies.
        // Each iteration increase the candy and people by 1.
        while (candies > 0) {
            // If candies is more than candy, return candy.
            // However, if the remaining candies is less than candy, distribute the remaining candies.
            distribution[person] += Math.min(candies, candy);
            candies -= candy++;
            person = (person + 1) % num_people;
        }
        return distribution;
    }

}
