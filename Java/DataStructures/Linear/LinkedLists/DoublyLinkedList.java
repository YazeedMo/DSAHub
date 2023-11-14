package org.dsahub;

/*
    DOUBLY LINKED LIST
    ------------------------------------------------------------------------------------
    Description:
    - A linear data structure where elements are stored in nodes. Each node has a reference
      to the previous and next nodes, forming a doubly linked structure.

    Characteristics:
    - Time complexity:
        * Access: O(n)
        * Search: O(n)
        * Insertion: O(1) for head/tail, O(n) for middle
        * Deletion: O(1) for head/tail, O(n) for middle
    - Space complexity: O(n)
    - Use cases: When frequent insertions/deletions at both ends are required.

    - Advantages: Supports efficient insertions/deletions at both ends.
    - Disadvantages: Higher memory overhead compared to singly linked lists.

    Operation/Methods:
    - size()
    - isEmpty()
    - first(): Returns (but does not remove) the first element
    - last(): Returns (but does not remove) the last element
    - addFirst(E e): Adds element e to the front of the list
    - addLast(E e): Adds element e to the end of the list
    - removeFirst(): Removes and returns the first element
    - removeLast(): Removes and returns the last element
*/


public class DoublyLinkedList<E> {

    //-------------- NESTED NODE CLASS --------------
    private static class Node<E> {
        private E element;                      // reference to the element stored at this node
        private Node<E> prev;                   // reference to the previous node in the list
        private Node<E> next;                   // reference to the subsequent node in the last
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
    //-------------- END OF NESTED NODE CLASS --------------

    // INSTANCE VARIABLES OF DOUBLY LINKED LIST
    private Node<E> header;                     // header sentinel
    private Node<E> trailer;                    // trailer sentinel
    private int size = 0;                       // number of element in the list

    // Constructs a new empty list
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    // ACCESS METHODS
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public E first() {                          // Returns (but does not remove) the first element of the list
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElement();   // First element is after header sentinel
    }
    public E last() {                           // Returns (but does not remove) the last element of the list
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getElement();  // Last element is before trailer sentinel
    }

    // PUBLIC UPDATE METHODS

    // Adds element e to the front of the list
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());    // Place just after the header sentinel
    }

    // Adds element e to the end of the list
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);  // Place just after the trailer sentinel
    }

    // Removes and returns the first element of the list
    public E removeFirst() {
        if (isEmpty()) {
            return null;                        // Nothing to remove
        }
        return remove(header.getNext());        // First element is after header sentinel
    }

    // Removes and return the last element of the list
    public E removeLast() {
        if (isEmpty()) {
            return null;                        // Nothing to remove
        }
        return remove(trailer.getPrev());       // Last element is before trailer sentinel
    }

    // PRIVATE UPDATE METHODS

    // Adds element e to the linked list in between the given nodes
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // Create and link new Node
        Node<E> newest = new Node<>(e, predecessor, successor);
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
