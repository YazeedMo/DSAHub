package org.dsahub.datastructures;

public class SinglyLinkedList<E> {

    //-------------- nested Node class ---------------
    private static class Node<E> {
        private final E element;                // Reference to the element stores at this Node
        private Node<E> next;                   // Reference to the subsequent Node in the list
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) { next = n; }
    }
    //---------- end of nested Node class ------------


    // Instance variables of the SinglyLinkedList
    private Node<E> head = null;                // Head node of the list (or null if empty)
    private Node<E> tail = null;                // Last node of the list (or null if empty)
    private int size = 0;                       // Number of nodes in the list

    public SinglyLinkedList() { }               // Constructs and initially empty list

    // Access methods
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public E first() {                          // Returns (but does not remove) the first element
        if (isEmpty()) { return null; }
        return head.getElement();
    }
    public E last() {
        if (isEmpty()) { return null; }
        return tail.getElement();
    }

    // Update methods
    public void addFirst(E e) {                 // Adds element e to the front of te list
        head = new Node<>(e, head);             // Create and link a new Node
        if (size == 0) {
            tail = head;                        // Special case: new node becomes tail also
        }
        size++;
    }

    public void addLast(E e) {                  // Adds element e to the end of the list
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

    public E removeFirst() {                    // Removes and returns the firs element
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
