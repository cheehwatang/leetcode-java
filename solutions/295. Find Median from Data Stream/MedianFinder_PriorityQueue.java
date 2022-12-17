package com.cheehwatang.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// Time Complexity  : O(n logn),
// where 'n' is the number of 'num' added, or the number of times the 'addNum(num)' function is called.
// The offer(num) and poll() function call on the priority queue has a time complexity of O(logn).
// Note: the findMedian() function has a time complexity of O(1),
// because both the size() and peek() functions have constant time complexity.
//
// Space Complexity : O(n),
// where 'n' is the number of 'num' added, or the number of times the 'addNum(num)' function is called.
// We have a maximum of size 'n' for both 'minHeap' and 'maxHeap'.

public class MedianFinder_PriorityQueue {

    // Approach:
    // Using both Minimum Heap and Maximum Heap, with:
    // - the 'minHeap' storing the half with the greater numbers, and
    // - the 'maxHeap' storing the half with the lesser numbers.
    // From there, we always have access to the middle 2 numbers,
    // by getting the minimum number in the 'minHeap' and the maximum number in the 'maxHeap'.

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder_PriorityQueue() {
    }

    // Function to add the number.
    public void addNum(int num) {
        // Here, we set the 'maxHeap' to always has equal or more elements than the 'minHeap'.
        // This is to ensure that we can easily access the median number when we have odd number of elements.
        // By adding 'num' to the 'maxHeap' first, then take the maximum to the 'minHeap',
        // we are ensuring the 'maxHeap' contains all the lesser numbers,
        // and the 'minHeap' contains all the greater numbers.
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        // We balance the priority queues when necessary,
        // to ensure 'maxHeap' always has equal or more elements than 'minHeap'.
        if (minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
    }

    // Function to find the median of the numbers.
    public double findMedian() {
        // If we have odd number of elements, then the maximum number in the 'maxHeap' is the median.
        if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
        // If we have even number of elements, we get the average of the middle 2 elements.
        return (maxHeap.peek() + minHeap.peek()) / 2d;
    }
}
