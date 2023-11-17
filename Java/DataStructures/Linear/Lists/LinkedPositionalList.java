package org.dsahub;


/*
    LINKED POSITIONAL LIST
    ------------------------------------------------------------------------------------
    Description:
    - Implements the PositionalListInterface using a doubly linked list.

    Characteristics:
    - Uses a doubly linked list to represent a positional list.
    - Provides methods for position-based access and manipulation.

    Operation/Methods:
    - size(): Returns the number of elements in the list
    - isEmpty(): Tests whether the list is empty
    - first(): Returns the first Position in the list (or null if empty)
    - last(): Returns the last Position in the list (or null if empty)
    - before(PositionInterface<E> p): Returns the Position immediately before p (or null if p is first)
    - after(PositionInterface<E> p): Returns the Position immediately after p (or null if p is last)
    - addFirst(E e): Inserts element e at the front of the list and returns its new Position
    - addLast(E e): Inserts element e at the back of the list and returns its new Position
    - addBefore(PositionInterface<E> p, E e): Inserts element e before Position p and returns its new Position
    - addAfter(PositionInterface<E> p, E e): Inserts element e after Position p and returns its new Position
    - set(PositionInterface<E> p, E e): Replaces the element stored at Position p and returns the replaced element
    - remove(PositionInterface<E> p): Removes the element stored at Position p and returns it (invalidating p)
 */


public class LinkedPositionalList<E> implements PositionalListInterface<E> {


    //-------------- NESTED NODE CLASS ---------------
    private static class Node<E> implements PositionInterface<E> {

        private E element;                      // Reference to the element stored at this node
        private Node<E> prev;                   // Reference to the previous node in the list
        private Node<E> next;                   // Reference to the subsequent node in the list

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        @Override
        public E getElement() throws IllegalStateException {
            if (next == null) {                 // Convention for defunct node
                throw new IllegalStateException("Position is no longer valid");
            }
            return element;
        }
        public Node<E> getPrev() {
            return prev;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setElement(E e) {
            element = e;
        }
        public void setPrev(Node<E> p) {
            prev = p;
        }
        public void setNext(Node<E> p) {
            next = p;
        }
    }
    //---------- END OF NESTED NODE CLASS ------------


    // INSTANCE VARIABLES OF LINKED POSITIONAL LIST

    private Node<E> header;                     // Header sentinel
    private Node<E> trailer;                    // Trailer sentinel
    private int size = 0;                       // Number of elements in the list


    // CONSTRUCTORS

    // Constructs a new empty list
    public LinkedPositionalList() {
        header = new Node<>(null, null, null);  // Create header
        trailer = new Node<>(null, header, null);   // Trailer is preceded by header
        header.setNext(trailer);                // Header is followed by trailer
    }


    // PUBLIC ACCESSOR METHODS

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public PositionInterface<E> first() {
        return position(header.getNext());
    }

    @Override
    public PositionInterface<E> last() {
        return position(trailer.getPrev());
    }

    // Returns the Position immediately before Position p (or null, if empty)
    @Override
    public PositionInterface<E> before(PositionInterface<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    // Returns the position immediately after Position p (or null, if p is first)
    @Override
    public PositionInterface<E> after(PositionInterface<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    // Inserts element e at the front of the linked list and returns its new Position
    @Override
    public PositionInterface<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }

    // Inserts element e at the back of the linked list and returns its new Position
    @Override
    public PositionInterface<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }

    // Inserts element e immediately before Position p, and returns its new Position
    @Override
    public PositionInterface<E> addBefore(PositionInterface<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    // Inserts element e immediately after Position p, and returns its new Position
    @Override
    public PositionInterface<E> addAfter(PositionInterface<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    // Replaces the element stored at Position p and returns the replaced element
    @Override
    public E set(PositionInterface<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }

    // Removes the element stored at Position p and returns it (invalidating p)
    @Override
    public E remove(PositionInterface<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setNext(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null);                          // Help with garbage collection
        node.setNext(null);                             // And convention for defunct node
        node.setPrev(null);
        return answer;
    }


    // PRIVATE UTILITY METHODS

    // Validates the position and returns it as a node
    private Node<E> validate(PositionInterface<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Invalid p");
        }
        Node<E> node = (Node<E>) p;             // Safe cast
        if (node.getNext() == null) {           // Convention for defunct node
            throw new IllegalArgumentException("p is no longer in the list");
        }
        return node;
    }

    // Returns the given node as a Position (or null, if it is a sentinel)
    private PositionInterface<E> position(Node<E> node) {
        if (node == header || node == trailer) {
            return null;                        // Do not expose user to the sentinels
        }
        return node;
    }

    // Adds element e to the linked list between the given nodes
    private PositionInterface<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }

}
