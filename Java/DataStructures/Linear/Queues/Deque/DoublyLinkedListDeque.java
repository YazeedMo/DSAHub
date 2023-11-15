package org.dsahub;


/*
    DOUBLY LINKED LIST DEQUE
    ------------------------------------------------------------------------------------
    Description:
    - A double-ended queue (deque) implementation using a doubly linked list.
    - Utilizes the DoublyLinkedList class to provide deque functionality.

    Characteristics:
    - Time complexity:
        * Access: O(n)
        * Search: O(n)
        * Insertion: O(1) for head/tail
        * Deletion: O(1) for head/tail
     - Space complexity: O(n)
     - Use cases: When dynamic size and frequent insertions/deletions at both ends are needed.
     - Advantages: Efficient insertions/deletions at both ends.
     - Disadvantages: O(n) access/search time, higher memory overhead compared to arrays.

     Operation/Methods:
     - size()
     - isEmpty()
     - first(): Returns (but does not remove) the first element
     - last(): Returns (but does not remove) the last element
     - addFirst(E e): Adds element e to the front of the deque
     - addLast(E e): Adds element e to the end of the deque
     - removeFirst(): Removes and returns the first element of the deque
     - removeLast(): Removes and returns the last element of the deque

 */


public class DoublyLinkedListDeque<E> implements DequeInterface<E> {


    // INSTANCE VARIABLES

    private DoublyLinkedList<E> list = new DoublyLinkedList<>();


    // CONSTRUCTORS

    public DoublyLinkedListDeque() {}


    // ACCESS METHODS

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public E last() {
        return list.last();
    }


    // PUBLIC UPDATE METHODS

    @Override
    public void addFirst(E e) {
        list.addFirst(e);
    }

    @Override
    public void addLast(E e) {
        list.addLast(e);
    }

    @Override
    public E removeFirst() {
        return list.removeFirst();
    }

    @Override
    public E removeLast() {
        return list.removeLast();
    }
}
