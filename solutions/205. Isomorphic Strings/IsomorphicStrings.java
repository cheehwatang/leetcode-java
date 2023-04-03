package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n),
// where 'n' is the length of string 's' and string 't'.
// We iterate through every character in both input strings to check if they are isomorphic.
//
// Space Complexity : O(n),
// where 'n' is the length of string 's' and string 't'.
// The worst-case scenario is when each character is unique,
// resulting in the space used by the HashMap to be the length of string 's' and 't'.

public class IsomorphicStrings {

    // Approach:
    // Use two HashMap to map the character pairs for strings 's' and 't' in both directions,
    // to ensure the characters are correctly mapped to one another.
    //
    // For example, if only using one HashMap, string 's' = "cat", string 't' = "dad",
    // both 'c' and 't' in "cat" is mapped to 'd', which is wrong.
    // Thus, we need another map for string 't' to check otherwise.

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            // Map to the HashMaps if both characters are not mapped.
            if (!mapS.containsKey(charS) && !mapT.containsKey(charT)) {
                mapS.put(charS, charT);
                mapT.put(charT, charS);
            }
            // If the characters are mapped incorrectly, then the strings are not isomorphic.
            else if (!mapS.containsKey(charS) || !mapT.containsKey(charT) || !mapS.get(charS).equals(charT)) {
                return false;
            }
        }
        // If we successfully traverse both strings, then the strings are isomorphic.
        return true;
    }
}
