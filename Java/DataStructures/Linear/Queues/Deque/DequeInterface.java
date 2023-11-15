package org.dsahub;


/*
    DEQUE INTERFACE
    ------------------------------------------------------------------------------------
    Description:
    - An interface defining the behavior of a deque (double-ended queue).
    - Extends basic queue functionality to include operations at both ends.

    Characteristics:
    - Represents a double-ended queue data structure.
    - Combines features of both stacks and queues.

    Operation/Methods:
    - size(): Returns the number of elements in the deque
    - isEmpty(): Tests whether the deque is empty
    - first(): Returns (but does not remove) the first element of the deque (null if empty)
    - last(): Returns (but does not remove) the last element of the deque (null if empty)
    - addFirst(E e): Inserts an element at the front of the deque
    - addLast(E e): Inserts an element at the back of the deque
    - removeFirst(): Removes and returns the first element of the deque (null if empty)
    - removeLast(): Removes and returns the last element of the deque (null if empty)

 */


public interface DequeInterface<E> {

    // Returns the number of elements in the deque
    int size();

    // Tests whether the queue is empty
    boolean isEmpty();

    // Returns (but does not remove) the first element of the deque (null if empty
    E first();

    // Returns (but does not remove) the last element of the deque (null of empty)
    E last();

    // Inserts an element at the front of the queue
    void addFirst(E e);

    // Inserts an element at the back of the queue
    void addLast(E e);

    // Removes and returns the first element of the deque (null if empty)
    E removeFirst();

    // Removes and returns the last element of the deque (null if empty)
    E removeLast();

}
