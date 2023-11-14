package org.dsahub.datastructures;

/*
    SINGLY LINKED LIST
    ------------------------------------------------------------------------------------
    Description:
    - A linear data structure where elements are stored in nodes. Each node points to the
      next node.

    Characteristics:
    - Time complexity:
        * Access: O(n)
        * Search: O(n)
        * Insertion: O(1) for head, O(n) for tail (unless tail pointer is used)
        * Deletion: O(1) for head, O(n) for tail or specific node
     - Space complexity: O(n)
     - Use cases: When dynamic size and frequent insertions/deletions at the beginning are needed.

     - Advantages: Dynamic size, efficient insertions/deletions at the start.
     - Disadvantages: O(n) access/search time, higher memory overhead compared to arrays.

     Operation/Methods:
     - size()
     - isEmpty()
     - first(): Returns (but does not remove) the first element
     - last(): Returns (but does not remove) the last element
     - addFirst(E e): Adds element e to the front of the list
     - addLast(E e): Adds element e to the end of the list
     - removeFirst(): Removes and returns the first element of the list

 */

public class SinglyLinkedList<E> {

    //-------------- NESTED NODE CLASS ---------------
    private static class Node<E> {
        private E element;                      // Reference to the element stored at this Node
        private Node<E> next;                   // Reference to the subsequent Node in the list
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) { next = n; }
    }
    //---------- END OF NESTED NODE CLASS ------------


    // INSTANCE VARIABLES OF SINGLY LINKED LIST
    private Node<E> head = null;                // Head node of the list (or null if empty)
    private Node<E> tail = null;                // Last node of the list (or null if empty)
    private int size = 0;                       // Number of nodes in the list

    public SinglyLinkedList() { }               // Constructs and initially empty list

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
        return head.getElement();
    }
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    // PUBLIC UPDATE METHODS

    // Adds element e to the fron of the list
    public void addFirst(E e) {
        head = new Node<>(e, head);             // Create and link a new Node
        if (size == 0) {
            tail = head;                        // Special case: new node becomes tail also
        }
        size++;
    }

    // Adds element e to the end of the list
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);   // Node will eventually be the tail
        if (isEmpty()) {
            head = newest;                      // Special case: previously empty list
        }
        else {
            tail.setNext(newest);               // New node after existing tail
        }
        tail = newest;                          // New node becomes the tail
        size++;
    }

    // Removes and returns the first element of the list
    public E removeFirst() {
        if (isEmpty()) {                        // Nothing more to remove
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();                  // Will become null if list had only one Node
        size--;
        if (size == 0) {
            tail = null;                        // Special case as list is now empty
        }
        return answer;
    }

}
