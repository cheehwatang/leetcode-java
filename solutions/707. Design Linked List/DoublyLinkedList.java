package com.cheehwatang.leetcode;

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

public class DoublyLinkedList {

    // For Doubly Linked List, all the nodes are connected bi-directionally that ends in null in both ends.
    // However, the 'head' and 'tail' pointer still points to the head and tail of the linked list respectively.
    // For example null <- A <-> B <-> C <-> D -> null, with A being the head and D being the tail.
    // Thus, all the nodes has the 'val' field, the 'next' variable which points to the next node,
    // and the 'prev' variable which points to the previous node.
    private class Node {
        private int val;
        private Node next;
        private Node prev;

        // Constructor of the Node.
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    // For Doubly Linked List, we use a 'head' node and a 'tail' node to represent the whole linked list,
    // so we can traverse the linked list from either the 'head' or the 'tail'.
    // Here, we use a 'size' variable to keep track of the size of the Linked List for fast operations
    // for adding and deleting nodes.
    private Node head;
    private Node tail;
    private int size;

    // Constructor of the Doubly Linked List, with a null 'head', null 'tail' and 'size' of 0.
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Function to get the value of the node at position 'index'.
    public int get(int index) {
        // If the 'index' is out of bound, return -1.
        if (index > size - 1 || index < 0) return -1;

        // Using for-loop to traverse the linked list until the node at position 'index'.
        // We can also use a while-loop to traverse.
        Node current = head;
        for (; index > 0; index--)
            current = current.next;

        // Return the value of the node.
        return current.val;
    }

    // A private function for a simple operation to add a node to an empty list.
    // As all three functions, addAtHead(val), addAtTail(val) and addAtIndex(index, val)
    // have the possibilities of adding a node to an empty linked list.
    // We extract the function out, rather than duplicating the code in all three functions.
    private void addInEmptyList(int val) {
        // Set both the 'head' and 'tail' as the new node, as both are currently null.
        head = new Node(val);
        tail = head;

        // After adding the node, increase the size by 1.
        size++;
    }

    // Function to add a new node of 'val' value to the head of the linked list.
    public void addAtHead(int val) {
        // If we have an empty list, then we use the addInEmptyList(val).
        if (size == 0) {
            addInEmptyList(val);
            return;
        }

        // For doubly linked list, we need to remap both the 'next' and 'prev' pointers.
        Node newNode = new Node(val);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;

        // After adding the node, increase the size by 1.
        size++;
    }

    // Function to add a new node of 'val' value to the tail of the linked list.
    public void addAtTail(int val) {
        // If we have an empty list, then we use the addInEmptyList(val).
        if (size == 0) {
            addInEmptyList(val);
            return;
        }

        // Adding a new node in the 'tail' is similar to adding it to the head of the linked list.
        Node newNode = new Node(val);
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;

        // After adding the node, increase the size by 1.
        size++;
    }

    // Function to add a new node of 'val' value to the position 'index' in the linked list.
    public void addAtIndex(int index, int val) {
        // If the 'index' is out of bound, return -1.
        if (index > size || index < 0) return;

        // If we have an empty list, then we use the addInEmptyList(val).
        if (size == 0) {
            addInEmptyList(val);
            return;
        }

        // If index is 0, we add at the head.
        if (index == 0) {
            addAtHead(val);
        }
        // If index is size, we add at the tail.
        else if (index == size) {
            addAtTail(val);
        }
        // If somewhere in between,
        else {
            // traverse the linked list until the parent position of the 'index' to add.
            Node parent = head;
            for (; index > 1; index--) {
                parent = parent.next;
            }
            // Change the pointers accordingly when adding the new node.
            // For Example, Linked List == A <-> B -> null, index to add is 1, value is C.
            Node newNode = new Node(val);
            // So parent == A, parent.next == B, newNode == C,
            // make C <- B -> null.
            parent.next.prev = newNode;
            // make C <-> B -> null.
            newNode.next = parent.next;
            // make A <- C <-> B -> null.
            newNode.prev = parent;
            // make A <-> C <-> B -> null.
            parent.next = newNode;

            // After adding the node, increase the size by 1.
            size++;
        }
    }

    // Function to delete the node at position 'index' in the linked list.
    public void deleteAtIndex(int index) {
        // If the 'index' is out of bound, return -1.
        if (index > size - 1 || index < 0) return;

        // For the edge case of only one node in the linked list, set both the 'head' and 'tail' pointer as null.
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }

        // If we are deleting the node at the head of the list,
        // set the 'head' to the next node, and remember to set the 'prev' of the new head as null.
        if (index == 0) {
            head = head.next;
            head.prev = null;
        }
        // If we are deleting the node at the tail of the list,
        // set the 'tail' to the previous node, and remember to set the 'next' of the new tail as null.
        else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        }
        // For any other positions,
        else {
            // traverse the linked list until the node at the 'index' to delete.
            Node current = head;
            for (; index > 0; index--) {
                current = current.next;
            }

            // Point the 'prev' node and 'next' node to each other.
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        // After deleting the node, decrease the size by 1.
        size--;
    }
}
