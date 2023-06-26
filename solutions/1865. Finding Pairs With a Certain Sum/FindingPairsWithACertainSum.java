package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums1' or 'nums2'.
// During instantiation, we traverse 'nums2' once to record the frequency of the elements, with O(n) time complexity.
// The add() function has a constant time complexity, since we are using index to get the element.
// The count() function has a linear time complexity, as we traverse 'nums1' to count the pairs.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums1' or 'nums2'.
// The HashMap used has a maximum size 'n', with each element being unique.

class FindSumPairs {

    // Approach:
    // As the count() function is the same as the two sum problem,
    // we can use HashMap to record the frequency of the numbers in 'nums2'.
    // Thus, we perform the mapping of 'nums2' in the constructor when 'FindSumPairs' is instantiated.
    // In the add() function, update the frequency by reducing the nums2[index],
    // and increasing the new number after addition.

    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> map2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        // Create and count the element frequency in 'nums2' in the HashMap 'map2'.
        this.map2 = new HashMap<>();
        for (int number : nums2) map2.put(number, map2.getOrDefault(number, 0) + 1);
    }

    public void add(int index, int val) {
        // Decrease the count of the current number (nums2[index]).
        map2.put(nums2[index], map2.get(nums2[index]) - 1);
        nums2[index] += val;
        // Increase the count of the new number (nums2[index] + val).
        map2.put(nums2[index], map2.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        // Check if the corresponding number is in the map.
        for (int number : nums1) count += map2.getOrDefault(tot - number, 0);
        return count;
    }
}
