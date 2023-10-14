package org.dsahub;

/*
    LinkedCircularQueue
    ------------------------------------------------------------------------------------
    A concrete implementation of the CircularQueue interface using a circular linked list
    as its underlying storage mechanism. The LinkedCircularQueue benefits from the dynamic
    nature of circularly linked lists, allowing to rotate elements efficiently without
    reallocating or relinking nodes.

    Advantages:
    - Dynamic Size: The queue can grow or shrink as required.
    - Efficient Rotations: The rotate operation is performed in consistent time.

    Disadvantages:
    - Memory Overhead: Each nde requires additional memory for its pointer, which can be
      an overhead when compared to an Array-based CircularQueue.

 */

public class LinkedCircularQueue<E> implements CircularQueue<E> {

    @Override
    public void rotate() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enqueue(E e) {

    }

    @Override
    public E first() {
        return null;
    }

    @Override
    public E dequeue() {
        return null;
    }
}
