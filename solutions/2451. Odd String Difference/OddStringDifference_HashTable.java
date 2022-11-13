package com.cheehwatang.leetcode;

import java.util.*;

// Time Complexity  : O(m ^ n),
// where 'm' is the length of the words in 'words', and 'n' is the length of the string array 'words'.
// For each word in 'words' (of length n), we check the differences between the letters, in the word of length m.
//
// Space Complexity : O(m ^ n),
// where 'm' is the length of the words in 'words', and 'n' is the length of the string array 'words'.
// Complexity 'm ^ n' as we create an int array of length 'm' for each word that we check in the string array 'words' of length 'n',
// to record the differences.
// There is actually an additional complexity of 'n', as we created a List<String> function to record the words.
// The HashMap<>() has only 2 key-value pairs in this problem, so it is negligible.

public class OddStringDifference_HashTable {

    // Approach:
    // As the words have their own difference integer array,
    // thus we can use a HashMap to record the occurrences of the difference integer array to see which is the odd one out.
    // Rather than recording the occurrences in count, we use a list to keep track of the words.
    // If the list only contains one word, then we know that word is the odd one out.

    public String oddString(String[] words) {
        // As we will be converting the difference integer array into its hash code, the key is the hash code of the array,
        // while the value is the list storing the string with that difference integer array hash code.
        // The reason for a hash code is that int[] as an array is a unique object even with the same elements in it.
        // Thus, we need to either convert it into its hash code (using Arrays.hashCode()) or String Arrays.toString())
        // for the int[] to be comparable.
        Map<Integer, List<String>> map = new HashMap<>();

        for (String word : words) {
            // Store the differences in an array.
            int[] difference = new int[word.length() - 1];
            for (int i = 0; i < word.length() - 1; i++) {
                difference[i] = word.charAt(i + 1) - word.charAt(i);
            }
            // Once we got the difference integer array, we convert it into a hash code, and
            // store together with the string in the HashMap.
            int hashCode = Arrays.hashCode(difference);
            // Note to create a new list for the strings if it is a new hash code.
            if (!map.containsKey(hashCode)) {
                map.put(hashCode, new ArrayList<>());
            }
            map.get(hashCode).add(word);
        }

        String oddString = "";
        // For this problem, there will only be two keys and one will only contain an element in the list.
        for (Integer key : map.keySet()) {
            if (map.get(key).size() == 1) {
                oddString = map.get(key).get(0);
            }
        }
        return oddString;
    }
}
