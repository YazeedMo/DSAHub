package org.dsahub;

/*
    CIRCULARLY LINKED LIST
    ------------------------------------------------------------------------------------
    Description:
    - A variation of the singly linked list where the tail node points to the head node,
      creating a circular structure.

    Characteristics:
    - Time complexity:
        * Access: O(n)
        * Search: O(n)
        * Insertion: O(1) for head, O(n) for tail (unless tail pointer is used)
        * Deletion: O(1) for head, O(n) for tail or specific node
    - Space complexity: O(n)
    - Use cases: When a circular structure is required, and frequent rotations are needed.

    - Advantages: Supports constant-time rotations.
    - Disadvantages: O(n) access/search time, higher memory overhead compared to arrays.

    Operation/Methods:
    - size()
    - isEmpty()
    - first(): Returns (but does not remove) the first element
    - last(): Returns (but does not remove) the last element
    - rotate(): Rotate the first element to the back of the list
    - addFirst(E e): Adds element e to the front of the list
    - addLast(E e): Adds element e to the end of the list
    - removeFirst(): Removes and returns the first element
*/

public class CircularlyLinkedList <E> {

    //-------------- NESTED NODE CLASS --------------
    private static class Node<E> {
        private E element;                      // Reference to the element stored at this Node
        private Node<E> next;                   // Reference to the subsequent Node in the list
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        public E getElement() {
            return element;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setNext(Node<E> n) {
            next = n;
        }
    }
    //-------------- END OF NESTED NODE CLASS --------

    // INSTANCE VARIABLES OF CIRUCLARLY LINKED LIST
    private Node<E> tail = null;                // We store tail (but not head)
    private int size = 0;                       // Number of node in the list
    public CircularlyLinkedList() { }           // Constructs and initially empty list

    // ACCESS METHODS
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public E first() {                          // Returns (but does not remove) the first element
        if (isEmpty()) {
            return null;
        }
        return tail.getNext().getElement();     // The head is *after* the tail
    }
    public E last() {                           // Returns (but does not remove) the last element
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    // PUBLIC UPDATE METHODS

    // Rotates the first element to the back of the list
    public void rotate() {
        if (tail != null) {                     // if empty, do nothing
            tail = tail.getNext();              // The old head becomes the new tail
        }
    }

    // Adds element e to the front of the list
    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);                 // Link to itself circularly
        }
        else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    // Adds element e to the end of the list
    public void addLast(E e) {
        addFirst(e);                            // Insert new element at front of list
        tail = tail.getNext();                  // Now new element becomes the tail
    }

    // Removes and returns the first element of the list
    public E removeFirst() {
        if (isEmpty()) {
            return null;                        // Nothing to remove
        }
        Node<E> head = tail.getNext();
        if (head == tail) {
            tail = null;                        // Must be the only Node left
        }
        else {
            tail.setNext(head.getNext());       // Removes "head" from the list
        }
        size--;
        return head.getElement();
    }

}
