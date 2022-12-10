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

public class SinglyLinkedList {

    // For Singly Linked List, all the nodes are connected in one direction that ends in null.
    // For example A -> B -> C -> D -> null.
    // Thus, all the nodes has the 'val' field and the 'next' variable which points to the next node.
    private class Node {
        private int val;
        private Node next;

        // Constructor of the Node.
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // For Singly Linked List, we use a 'head' node to represent the whole linked list,
    // as we can get to all the nodes using the 'head' node.
    // Here, we use a 'size' variable to keep track of the size of the Linked List for fast operations
    // for adding and deleting nodes.
    private Node head;
    private int size;

    // Constructor of the Singly Linked List, with a null 'head' and 'size' of 0.
    public SinglyLinkedList() {
        this.head = null;
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

    // Function to add a new node of 'val' value to the head of the linked list.
    public void addAtHead(int val) {
        // Simply create the new node, point the 'next' to the 'head', and set the new node as the 'head'.
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;

        // After adding the node, increase the size by 1.
        size++;
    }

    // Function to add a new node of 'val' value to the tail of the linked list.
    public void addAtTail(int val) {
        // If there are no nodes in the linked list, we can use the addAtHead(val) function.
        if (size == 0) {
            addAtHead(val);
            return;
        }

        // Else, we traverse the linked list until the very last node and point the 'next' to the new node.
        Node current = head;
        while (current.next != null)
            current = current.next;
        current.next = new Node(val);

        // After adding the node, increase the size by 1.
        size++;
    }

    // Function to add a new node of 'val' value to the position 'index' in the linked list.
    public void addAtIndex(int index, int val) {
        // If the 'index' is out of bound, exit the function.
        if (index > size || index < 0) return;

        // If the index is 0, meaning that we add the node to the head of the linked list
        // using the addAtHead(val) function.
        // As it is an edge case, we handle it differently from the other nodes.
        if (index == 0) {
            addAtHead(val);
            return;
        }

        // Traverse the linked list, noting on the 'parent' of the position to add the new node.
        // Note that this is a singly linked list,
        // so we can only get the parent of a node by traversing the linked list from the head.
        Node parent = head;
        for (; index > 1; index--) {
            parent = parent.next;
        }
        // Change the pointers accordingly when adding the new node.
        // For Example, Linked List == A -> B -> null, index to add is 1, value is C.
        Node newNode = new Node(val);
        // So parent == A, parent.next == B, newNode == C,
        // making C -> B -> null, the linked list remains as A -> B -> null.
        newNode.next = parent.next;
        // Then, parent -> newNode, making A -> C -> B -> null.
        parent.next = newNode;

        // After adding the node, increase the size by 1.
        size++;
    }

    // Function to delete the node at position 'index' in the linked list.
    public void deleteAtIndex(int index) {
        // If the 'index' is out of bound, exit the function.
        if (index > size - 1 || index < 0) return;

        // If the index is 0, meaning that we remove the node to the head of the linked list.
        // As it is an edge case, we handle it differently from the other nodes.
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        // Traverse the linked list, noting on the 'parent' of the position to add the new node.
        // Note that this is a singly linked list,
        // so we can only get the parent of a node by traversing the linked list from the head.
        Node parent = head;
        for (; index > 1; index--) {
            parent = parent.next;
        }

        // To delete the node, simply set the 'next' node pointer to skip the node to delete.
        // Note that the node "deleted" still remains in memory, as well as its 'next' pointer,
        // but it no longer remains in the linked list.
        parent.next = parent.next.next;

        // After deleting the node, decrease the size by 1.
        size--;
    }
}
