package org.dsahub;

/*
    QUEUE INTERFACE
    ------------------------------------------------------------------------------------
    A collection of objects that are inserted and removed according to the first-in-first-out
    principle. Unlike the stack, which operates based on the LIFO principle, the QUEUE operates
    on FIFO where the earliest added element is the first one to be removed.

    The QUEUE interface provides a level of abstraction that allows multiple concrete implementations,
    ensuring a consistent set of behaviours regardless of the underlying details. In this context,
    there can be multiple implementations, such as ArrayQueue and LinkedQueue. The ArrayQueue,
    as the name suggests, uses an array as its underlying storage mechanism, while the LinkedQueue
    would use a Linked List structure.

 */

public interface Queue<E> {

    // Returns the number of elements in the queue
    int size();

    // Tests whether the queue is empty
    boolean isEmpty();

    // Inserts an element at the rear end of the queue
    void enqueue(E e);

    // Returns but does not remove the first element of the queue (null if empty)
    E first();

    // Removes and return the first element of the queue (null if empty)
    E dequeue();

}
