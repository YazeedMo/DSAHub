package org.dsahub;

/*
    DEQUE INTERFACE (Double-Ended Queue)
    ------------------------------------------------------------------------------------
    A Deque, pronounced as "deck", represents a double-ended queue, a collection of elements
    that supports the insertion and removal of elements from both its ends. It combines
    the characteristics of both stacks and queues, allowing for more flexible and generalized
    operations.

    The Deque interface allows for efficient insertion and removal at the front and back,
    thus enabling it to be used in scenarios where elements need to be processed from both
    ends of a collection.

    Advantages:
    - Flexibility: Can be used as a queue or a stack, or both, offering diverse operations.
    - Efficient Operations: Supports constant-time insertions and deletions at both ends.

    Common Use Cases:
    - Browser History: Where the back and forward buttons navigate through the history.
    - Undo and Redo operations in software applications.
    - Palindrome checkers, where elements are compared from both ends.

 */

public interface Deque<E> {

    // Returns the number of elements in the deque
    int size();

    // Tests whether the deque is empty
    boolean isEmpty();

    // Returns, but does not remove, the first element of the deque (null if empty)
    E first();

    // Returns, but does not remove, the last element of the deque (null if empty)
    E last();

    // Inserts an element at the front of the deque
    void addFirst(E e);

    // Inserts an element at the back of the deque
    void addLast(E e);

    // Removes and return the first element of the deque (null if empty)
    E removeFirst();

    // Removes and return the last element of the deque (null ie empty)
    E removeLast();

}
