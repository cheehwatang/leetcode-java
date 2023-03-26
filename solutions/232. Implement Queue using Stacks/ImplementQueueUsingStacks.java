package com.cheehwatang.leetcode;

import java.util.Stack;

// Time Complexity  : O(n),
// where 'n' is the maximum size of the 'pushStack', when either the peek() or pop() is called on an empty 'popStack'.
// push() and empty() have O(1) time complexity.
//
// Space Complexity : O(m + n),
// where 'n' is the maximum size of the 'pushStack' and 'm' is the maximum size of the 'popStack'.

public class ImplementQueueUsingStacks {

    // Approach:
    // A queue is first in first out (FIFO), meaning the first element offered to the queue is the
    // first element to poll from the queue.
    // A stack is last in first out (LIFO), meaning the last element pushed to the stack is the
    // first element to pop from the stack.
    // To achieve the behavior of a queue, we can use a stack ('pushStack') for the input of the elements,
    // and another stack ('popStack') for the output of the elements.
    // When shifting the elements from the 'pushStack' to the 'popStack', the whole 'pushStack' is inverted
    // so the first element pushed to the 'pushStack' is the top element at the 'popStack'.
    // However, we would shift the elements only if the 'popStack' is empty.
    // Shifting the elements while the 'popStack' is not empty would result in incorrect ordering of the elements.

    // Set both 'pushStack' and 'popStack' to private
    // as only the constructor and the push(), pop(), peek() and empty() methods is accessible by other classes.
    // 'pushStack' is responsible for integer input to the queue.
    // 'popStack' is responsible for integer output from the queue, either for peek() or pop().
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    // Constructor to create new stack for the class variables.
    // Note that we can keep the constructor empty, and declare the new stack directly for the class variables.
    public ImplementQueueUsingStacks() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int x) {
        // When push() is called, push the integer to the 'pushStack'.
        pushStack.push(x);
    }

    public int pop() {
        // If the 'popStack' is empty, shift all the elements in the 'pushStack' over to the 'popStack'.
        if (popStack.empty()) shiftStack();

        // Remove the top element from the 'popStack'.
        return popStack.pop();
    }

    public int peek() {
        // If the 'popStack' is empty, shift all the elements in the 'pushStack' over to the 'popStack'.
        if (popStack.empty()) shiftStack();

        // Get the value of the top element from the 'popStack'.
        return popStack.peek();
    }

    public boolean empty() {
        // Only return true if both 'pushStack' and 'popStack' is empty.
        return pushStack.empty() && popStack.empty();
    }

    // Since both pop() and peek() share the same method if the 'popStack' is empty,
    // extract the method to a private method.
    private void shiftStack() {
        // Shift the whole 'pushStack' to the 'popStack'.
        while (!pushStack.empty()) popStack.push(pushStack.pop());
    }
}
