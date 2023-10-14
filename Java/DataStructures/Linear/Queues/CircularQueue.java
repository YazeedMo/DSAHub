package org.dsahub;

/*
    CircularQueue Interface
    ------------------------------------------------------------------------------------
    An extension of the basic Queue interface to support the rotation of its elements.
    A CircularQueue is particularly useful when the first element need to be cyclically
    moved to the end of the queue, allowing for efficient rotations in specific scenarios,
    especially when using a circular linked list as the underlying data structure.

    In addition to the standard Queue operations, a CircularQueue introduces the rotate()
    method, which moves the front element to the back of the queue. This operation can be
    performed in constant time when using a circular linked list, making it an efficient
    operation without the need for dequeueing and then enqueueing the front element.

    Usage:
    - Multiplayer, turn-based games where players take turns in a cyclic order.
    - Round-robin scheduling for computing processes where tasks are assigned in a cyclic manner.
    - Algorithms like hte Josephus problem which involve cyclic operations on a collection.

 */

public interface CircularQueue<E> extends Queue<E> {

    // Rotates the front element of te queue to the back of the queue
    // This does nothing if the queue is empty
    void rotate();

}
