package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;

// Time Complexity  : O(k ^ (n ^ m)),
// where 'm' is the length of 'queries', 'n' is the length of 'dictionary', and
// 'k' is the length of each element in 'queries' and 'dictionary'.
// Brute force approach to loop through 'queries' to compare to every letter in every element in 'dictionary'.
//
// Space Complexity : O(m),
// where 'm' is the length of 'queries'.
// The worst case to have all elements in 'queries' satisfying the requirement to add to the result list.

public class WordsWithinTwoEditsOfDictionary {

    // Approach:
    // As the constraints for 'queries', 'dictionary' and queries.length <= 100, we use the brute force approach
    // to compare the elements in 'queries' with every element in 'dictionary'
    // to check if there are more than two letters that is different.

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for (String query : queries) {
            for (String dict : dictionary) {
                // 'count' to keep track on the number of letters that is different, at each index position in the string.
                int count = 0;
                for (int k = 0; k < query.length(); k++) {
                    // Increase the count when the character that the same position is different.
                    if (query.charAt(k) != dict.charAt(k)) {
                        count++;
                        // To improve the performance slightly, stop checking once found count > 2.
                        if (count > 2) break;
                    }
                }
                // Once found word in 'dictionary' with less than 2 letter difference, add the query to the result,
                // and stop checking to rest of the 'dictionary', to improve performance slightly.
                if (count <= 2) {
                    result.add(query);
                    break;
                }
            }
        }
        return result;
    }
}
