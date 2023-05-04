package com.cheehwatang.leetcode;

import java.util.*;

// Time Complexity  : O(m),
// where 'm' is the number of characters in 'paths'.
// For each string in 'paths', we perform String.split() method, which in total as a linear time complexity.
// Additionally, the string concatenation to form the file path approximate to linear time complexity as well.
//
// Space Complexity : O(n),
// where 'n' is the number of strings in 'paths' array.
// In the worst-case when no duplicate content is found and each string in 'paths' only contain a file,
// the space of the HashMap used is O(n).
// Additionally, the space used by each re-constructed file path grows linearly with the input length 'n'.

public class FindDuplicateFileInSystem_HashMap {

    // Approach:
    // Using a HashMap to store the list of paths with the same content,
    // with key = content, and value = the list of paths with that content.
    // With each string in 'paths' being a unique directory, we can split each string by whitespace.
    // The first of the array is the directory, while the remaining elements are the filename and content.
    // To get the content, we can extract based on the open bracket "(", as the content is in the format "()".
    // For each file, we format the path with the following format:
    // directory + "/" + filename
    // Once all the paths are mapped to its content in the HashMap, we only add the list of paths with multiple paths.

    public List<List<String>> findDuplicate(String[] paths) {
        // Set up the result list.
        List<List<String>> result = new ArrayList<>();

        // Return an empty list if there is no item in the paths.
        if (paths.length == 0) return result;

        // Use a HashMap to record the content (key) and the file path list (value).
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            // Split each path into the directory and contents.
            // Example:
            // String path = "root/a 1.txt(abcd) 2.txt(efgh)"
            // path.split("\\s+") = ["root/a", "1.txt(abcd)", "2.txt(efgh)"]
            // with split("\\s+") split string separated by whitespace characters " ".
            String[] strings = path.split("\\s+");

            // We know that path[0] is always the directory.
            // So, i = 1, and we check for the content.
            for (int i = 1; i < strings.length; i++) {
                // From "(" onwards, all letters are the contents (including the final ")"), to check for duplicates.
                int index = strings[i].indexOf("(");

                // Example:
                // String.substring(index) results in content = "(abcd)" or "(efgh)".
                String content = strings[i].substring(index);

                // Example:
                // "root/a" + "/" + "1.txt" = "root/a/1.txt"
                // "root/a" + "/" + "2.txt" = "root/a/2.txt"
                String filename = strings[0] + "/" + strings[i].substring(0, index);

                // If the list contains the content (e.g. "(abcd)" or "(efgh)"),
                // we add the 'filename' ("root/a/1.txt") to the list.
                List<String> filenames = map.getOrDefault(content, new ArrayList<>());
                filenames.add(filename);

                // Record the file path list as the key, into the 'map'.
                // Since if content is the same, meaning it is duplicate file in different directories.
                map.put(content, filenames);
            }
        }
        // Check all the key (content) if there are duplicates (size > 1).
        // If there are duplicates, add the list to the result.
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                result.add(map.get(key));
            }
        }
        return result;
    }
}
