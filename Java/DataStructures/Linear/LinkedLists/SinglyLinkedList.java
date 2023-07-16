package org.dsahub.datastructures;

/*
    SINGLY LINKED LIST
    ------------------------------------------------------------------------------------
    A Singly Linked List is a data structure that represents a collection of elements,
    where each element contains a value and a reference (or link) to the next element in
    the list.

    Nodes: Each node in the Singly Linked List holds an element's value and a pointer
    to the next node in the list. The first node in the list is called the head, and the
    last node is called the tail.

    Traversal: To traverse the linked list, starting from the head, you can follow the
    references from one node to the next until you reach the end (tail) or a specific node.

    Insertion: Adding elements to a Singly Linked List involves creating a new node,
    setting its value, and updating the appropriate pointers to maintain the linked structure.
    Common insertion points are at the head or tail of the list.

    Removal: Removing elements from a Singly Linked List requires updating the pointers
    of the preceding node to bypass the removed node. The removed node's memory can be
    freed to reclaim resources.

    Advantages: Singly Linked Lists provide dynamic memory allocation, efficient insertion
    and removal at the head, and a flexible size. They can grow and shrink as needed,
    unlike arrays with fixed sizes.

    Limitations: Accessing elements at arbitrary positions in the list requires traversing
    from the head, which can be slower compared to random access in an array.
    Singly Linked Lists also require more memory due to the need for storing pointers to
    the next node.

 */

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
