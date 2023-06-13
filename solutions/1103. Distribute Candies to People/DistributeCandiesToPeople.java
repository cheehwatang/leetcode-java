package com.cheehwatang.leetcode;

// Time Complexity  : O(sqrt(n)),
// where 'n' is 'candies'.
// For each person, the number of candies given increases by one.
// Thus, the total number distributed candies is "n * (n + 1) / 2", resulting in time complexity of O(sqrt(n)).
//
// Space Complexity : O(m),
// where 'm' is 'num_people'.
// The result array has the length of 'num_people'.

public class DistributeCandiesToPeople {

    // Approach:
    // Use two variables,
    // 1. 'person' to track the index of the person, and
    // 2. 'candy' to track the number of candies that should be given.
    // Then rotate the index while slowly reduce the total number of candies, while increasing the candy count.
    // Record the result in an int[].

    public int[] distributeCandies(int candies, int num_people) {
        // Integer array to record the distribution of candies.
        int[] result = new int[num_people];

        int person = 0;
        int candy = 1;

        // While we still have candies, add the candy count to the int[], and reduce the candies.
        // Each iteration increase the candy and people by 1.
        while (candies > 0) {
            // If candies is more than candy, return candy.
            // However, if the remaining candies is less than candy, distribute the remaining candies.
            result[person] += Math.min(candies, candy);
            candies -= candy++;
            // With the remainder operator %, the person will restart at index 0 once we reach the 'num_people'.
            person = (person + 1) % num_people;
        }
        return result;
    }
}
