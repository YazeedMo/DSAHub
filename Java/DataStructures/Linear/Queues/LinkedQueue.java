package org.dsahub;

/*
    LinkedQueue
    ------------------------------------------------------------------------------------
    A concrete implementation of the Queue interface using a singly Linked List as its
    underlying storage mechanism. The LinkedQueue benefits from its dynamic nature of
    linked lists, which allows it to grow or shrink in size without the need for resizing
    operations like in an ArrayQueue.

    Advantages:
    - Dynamic Size: The queue can grow or shrink as required without any additional cost
      for resizing.
    - Memory Allocation: Memory is allocated only when a new element in enqueued, ensuring
      there's no wasted memory from unused capacity.

    Disadvantages:
    - Memory Overhead: Each node in the Linked List requires additional memory for its
      pointer, which can be an overhead when compared to the ArrayQueue.
    - Non-contiguous Memory: Memory for nodes is not allocated contiguously, which can
      lead to cache misses and, therefore, slower access times.

    In practice, LinkedQueue is suitable for scenarios where the queue size is unpredictable
    or can grow/shrink considerable and where memory overhead of the pointers in the
    linked list in not a concern.

 */

public class LinkedQueue<E> implements Queue<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>();        // An empty list

    // Constructor: New queue relies on the initial empty list
    public LinkedQueue() { }                                            // New queue relies on the initial empty list

    // Returns the number of elements in the queue
    @Override
    public int size() {
        return list.size();
    }

    // Tests whether the queue is empty
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Inserts an element at the rear end of the queue
    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    // Returns, but does not remove the first element of the queue (null if empty)
    @Override
    public E first() {
        return list.first();
    }

    // Removes and returns the first element of the queue (null if empty)
    @Override
    public E dequeue() {
        return list.removeFirst();
    }
}
