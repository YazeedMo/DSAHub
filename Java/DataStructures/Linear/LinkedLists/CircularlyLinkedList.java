package org.dsahub;

public class CircularlyLinkedList<E> {

    /*
        CIRCULARLY LINKED LIST
        ------------------------------------------------------------------------------------
        A circularly linked list is a type of data structure in which the elements (nodes)
        are connected in a circular fashion, forming a closed loop. Unlike a traditional
        singly linked list or doubly linked list, where the last node points to null,
        the last node in a circularly linked list points back to the first node, creating
        a circular arrangement.

        ADVANTAGES
        ------------------------------------------------------------------------------------
        - You can easily traverse the entire list without requiring a separate "head" or
          "tail" reference.
        - Insertions and deletions can be more efficient at the beginning and end of the list
          compared to traditional singly linked lists, as there's no need to update the "tail"
          reference

        DISADVANTAGES
        ------------------------------------------------------------------------------------
        - It can be more complex to implement and manage than traditional linked list
        - Care must be taken to avoid infinite loops when traversing the list

     */

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


    // Instance variables of the CircularlyLinkedList
    private Node<E> tail = null;                // We store the tail (but not head)
    private int size = 0;                       // Number of nodes in the list

    public CircularlyLinkedList() { }           // Constructs an initially empty list

    // Access methods
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return tail.getNext().getElement();        // The head is *after* the tail
    }
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    // Update methods
    public void rotate() {                      // Rotate the first element to the back of the list
        if (tail != null) {                     // If empty, do nothing
            tail = tail.getNext();              // The old head becomes the new tail
        }
    }
    public void addFirst(E e) {                 // Adds element e to the front of the list
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

    public void addLast(E e) {                  // Adds element e to the end of the list
        addFirst(e);                            // Insert new element at the front of the list
        tail = tail.getNext();                  // Now new element becomes the tail
    }

    public E removeFirst() {                    // Removes and returns the first element
        if (isEmpty()) {                        // Nothing to remove
            return null;
        }

        Node<E> head = tail.getNext();
        if (head == tail) {
            tail = null;                        // Must be the only node left
        }
        else {
            tail.setNext(head.getNext());       // Removes "head" from the list
        }

        size--;
        return head.getElement();
    }

}
