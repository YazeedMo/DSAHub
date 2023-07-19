package org.dsahub;

/*
    DOUBLY LINKED LIST
    ------------------------------------------------------------------------------------
    A doubly linked list is a type of linked list data structure where each node contains
    to pointers (references) instead of one, allowing it to establish links with both the
    previous and the next node in the list. This bidirectional linkage enables traversing
    the list in both forward and backward directions

    In doubly linked list, each node has three main components:
    1. Element: the actual data that the node holds
    2. Next Pointer: A reference to the next node in the list
    3. Previous Pointer: A reference to the previous node in the list

    In order to avoid some special cases when operating near the boundaries of a doubly
    linked list, it helps to add special nodes at both ends of the list: a "header" node
    at the beginning of the list, and a "trailer" node at the end of the list.
    These "dummy" nodes are known as sentinels (or guards), and they do not store elements
    of the primary sequence.

    ADVANTAGES:
    ------------------------------------------------------------------------------------
    - Bidirectional traversal: You can easily traverse the list in both forward and backward
      directions, making it useful for certain applications
    - Efficient insertion and deletion: Insertions and deletions can be more efficient
      compared to singly linked lists since you have direct access to both the previous
      and next nodes

    DISADVANTAGES:
    ------------------------------------------------------------------------------------
    - Extra memory overhead: Each node requires an additional pointer to store the previous
      reference, increasing memory usage compared to singly linked lists
    - More complex implementation: Maintaining both next and previous pointers requires
      additional complexity when inserting or deleting nodes

 */

public class DoublyLinkedList<E> {

    //-------------- nested Node class ---------------
    private static class Node<E> {
        private final E element;                // Reference to the element stored at this Node
        private Node<E> prev;                   // Reference to the previous Node in the list
        private Node<E> next;                   // Reference to the subsequent Node in the list
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        public E getElement() {
            return element;
        }
        public Node<E> getPrev() {
            return prev;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setPrev(Node<E> p) {
            prev = p;
        }
        public void setNext(Node<E> n) {
            next = n;
        }
    }
    //---------- end of nested Node class ------------

    // Instance variables of the DoublyLinkedList
    private final Node<E> header;               // Header sentinel
    private final Node<E> trailer;              // Trailer sentinel
    private int size = 0;                       // Number of elements in the list

    // Constructs a new empty list
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);     // Create header
        trailer = new Node<>(null, header, null);     // Trailer is preceded by header
        header.setNext(trailer);                            // Header is followed by trailer
    }

    // Public Access Methods:
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
        return header.getNext().getElement();               // First element is after header sentinel
    }
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getElement();              // Last element is before trailer
    }

    // Public Update Methods:
    // Adds element e to the front of the list
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());    // Place just after the header
    }
    // Adds element e to the end of the list
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);  // Place just before the trailer
    }
    // Removes and returns the first element of the list
    public E removeFirst() {
        if (isEmpty()) {
            return null;                        // Nothing to remove
        }
        return remove(header.getNext());        // First element is after header
    }
    // Removes and returns the last element of the last
    public E removeLast() {
        if (isEmpty()) {
            return null;                        // Nothing to return
        }
        return remove(trailer.getPrev());       // Last element is before the trailer
    }


    // Private Update Methods:
    // Adds element e to the linked list in between the given nodes
    private void addBetween(E e, Node<E> predecessor, Node <E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);     // Create and link a new Node
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    // Removes the given node from the list and returns its element
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

}
