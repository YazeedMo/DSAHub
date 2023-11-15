package org.dsahub;

/*
    QUEUE INTERFACE
    ------------------------------------------------------------------------------------
    Description:
    - An interface representing the basic operations of a queue, including size, emptiness,
      enqueue, dequeue, and accessing the first element.

    Methods:
    - size(): Returns the number of elements in the queue.
    - isEmpty(): Tests whether the queue is empty.
    - enqueue(E e): Inserts an element at the rear of the queue.
    - first(): Returns (does not remove) the first element of the queue (null if empty).
    - dequeue(): Removes and returns the first element of the queue (null if empty).
*/


public interface QueueInterface<E> {

    // Returns the number of elements in the queue
    int size();

    // Tests whether the queue is empty
    boolean isEmpty();

    // Returns (does not remove) the first element of the queue (null if empty)
    E first();

    // Inserts an element at the rear of the queue
    void enqueue(E e);

    // Removes and returns the first element of the queue (null if empty)
    E dequeue();

}
