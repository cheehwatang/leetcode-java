package com.cheehwatang.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// Time Complexity  : O(n),
// where 'n' is the maximum size of the 'secondaryQueue', when either the top() or pop() is called on an empty 'mainQueue'.
// The push() and empty() methods have O(1) time complexity.
//
// Space Complexity : O(m + n),
// where 'n' is the maximum size of the 'secondaryQueue' and 'm' is the maximum size of the 'mainQueue'.

public class ImplementStackUsingQueues {

    // Approach:
    // A stack is last in first out (LIFO), meaning the last element pushed to the stack is the
    // first element to pop from the stack.
    // A queue is first in first out (FIFO), meaning the first element offered to the queue is the
    // first element to poll from the queue.
    // To achieve the behavior of a stack, we can use a queue ('mainQueue') to maintain the top element of the stack,
    // and another queue ('secondaryQueue') to store the other elements in the stack.
    //
    // When push() is called, we shift the top element in the 'mainQueue' (if any) to the 'secondaryQueue',
    // then only we push the new element to the 'mainQueue'.
    // In this case, the 'secondaryQueue' acts as a storage for the elements.
    //
    // Each time pop() or top() is called, we return the top element from the 'mainQueue'.
    // However, if the 'mainQueue' is empty, we shift all the elements except one from 'secondaryQueue' to the 'mainQueue',
    // then swap the two queues, before performing the pop() or top() operation.

    // Set both 'mainQueue' and 'secondaryQueue' to private
    // as only the constructor and the push(), pop(), peek() and empty() methods is accessible by other classes.
    private Queue<Integer> mainQueue;
    private Queue<Integer> secondaryQueue;

    // Constructor to create new queue for the class variables.
    // Note that we can keep the constructor empty, and declare the new queue directly for the class variables.
    public ImplementStackUsingQueues() {
        mainQueue = new LinkedList<>();
        secondaryQueue = new LinkedList<>();
    }

    public void push(int x) {
        // If there is an element in the 'mainQueue', shift the element to the 'secondaryQueue'.
        if (!mainQueue.isEmpty()) secondaryQueue.offer(mainQueue.poll());

        // Offer the new element to the 'mainQueue'.
        mainQueue.offer(x);
    }

    public int pop() {
        // If there is no elements in the 'mainQueue', shift the elements for the 'mainQueue' to have the top element.
        if (mainQueue.isEmpty()) shiftElements();

        // Return the top element from the 'mainQueue'.
        return mainQueue.poll();
    }

    public int top() {
        // If there is no elements in the 'mainQueue', shift the elements for the 'mainQueue' to have the top element.
        if (mainQueue.isEmpty()) shiftElements();

        // Get the value of the top element from the 'mainQueue'.
        return mainQueue.peek();
    }

    public boolean empty() {
        return mainQueue.isEmpty() && secondaryQueue.isEmpty();
    }

    // Since both pop() and top() share the same method if the 'mainQueue' is empty,
    // extract the method to a private method.
    private void shiftElements() {
        // Swap the 'mainQueue' and the 'secondaryQueue'.
        Queue<Integer> temp = mainQueue;
        mainQueue = secondaryQueue;
        secondaryQueue = temp;

        // Shift all the elements except one from the 'mainQueue' to the 'secondaryQueue'.
        while (mainQueue.size() > 1) secondaryQueue.offer(mainQueue.poll());
    }
}
