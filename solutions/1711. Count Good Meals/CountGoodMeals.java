package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Problem:
 * Given an array of integers 'deliciousness', return the number of different good meals you can make (modulo 1e9 + 7).
 * A good meal is a meal that contains exactly two different food items with a sum of deliciousness equal to a power of two.
 * Do note that items with different indices are considered different food items even if they have the same deliciousness value.
 *
 *
 * Example 1:
 * Input    : deliciousness = [1,2,3,4,5,6]
 * Output   : 3
 * Explanation:
 * The good meals are (1,3) = 4, (2,6) = 8 and (3,5) = 8.
 *
 *
 * Example 2:
 * Input    : deliciousness = [0,0,1,1,2,2]
 * Output   : 10
 * Explanation:
 * The good meals are (0,1) = 1 in 4 ways, (0,2) = 4 in 4 ways, (1,1) = 2, and (2,2) = 4.
 *
 *
 * @author Chee Hwa Tang
 */

public class CountGoodMeals {

    // Approach:
    // Using a HashMap to record the frequency of the food items with a certain deliciousness.
    // Then use an Iterator for the HashMap, to check if the corresponding pairs to get the count.

    public int countPairs(int[] deliciousness) {

        // Use a HashMap to record the frequency of the food items with a certain deliciousness.
        // Key = deliciousness of the food, Value = frequency of food with that deliciousness.
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : deliciousness) {
            // Increase the frequency if the key is already in the map, or put a new Key-Value entry into the map.
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        long count = 0;
        // Using an iterator for the map entries. The for-loop continues until the map is empty.
        // After checking each map entry, we use the iterator to remove it from the map.
        // Note that this method of iterator is required as we are removing item from the map,
        // as we are iterating through the map.
        for (Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext();) {

            // Check each element (key-value pair).
            Map.Entry<Integer, Integer> element = iterator.next();
            int item = element.getKey();
            long frequency = element.getValue();

            // With the constraint for each item's deliciousness being 2^20,
            // the largest possible sum of two items are 2^20 + 2^20 = 2^21.
            // Thus, we will subtract the deliciousness from all the possible 'good meals' to check if it is in the map.
            for (int i = 0; i <= 21; i++) {
                int pair = (1 << i) - item;
                // If we found the pair,
                if (map.containsKey(pair)) {
                    // and if the item is the same as itself, i.e. in the case of 1 + 1 = 2, or 2 + 2 = 4.
                    // The count increases by the equation below, similar to Example 2 above.
                    if (item == pair) {
                        count += ((frequency - 1) * frequency) / 2;
                    }
                    // If the pair has a different deliciousness value,
                    // the count increases by the multiplications of both values, just like in Example 2 above.
                    else {
                        count += frequency * map.get(pair);
                    }
                }
            }
            // Remove the deliciousness, so it will not be double counted.
            iterator.remove();
        }
        // We only perform the modulo last since we used long to store the count.
        return (int) (count % (1e9 + 7));
    }
}
