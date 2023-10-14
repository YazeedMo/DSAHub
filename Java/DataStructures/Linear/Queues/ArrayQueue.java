package org.dsahub;

/*
    ArrayQueue
    ------------------------------------------------------------------------------------
    A concrete implementation of the Queue interface using an array as its underlying
    storage mechanism. The ArrayQueue employs a circular array structure and uses modular
    arithmetic to ensure efficient usage of space, allowing for a cyclic rotation of its
    elements.

    Advantages:
    - Predictable Performance: Memory is allocated continuously, making accesses cache-friendly
      and therefore, efficient.
    - Memory Overhead: Typically lower than that of a LinkedQueue since there's no need to
      store additional pointers.

    Disadvantages:
    - Fixed Capacity: The queue has a maximum size or occasionally experiences a higher cost
      for enqueue operations when a resize would be required (if resizing is implemented).
    - Space Inefficiency: If the array is much larger than the actual number of stored elements,
      it can result in wasted memory.

    In practice, ArrayQueue is suitable for scenarios where the maximum size fo the queue
    is fairly predictable and the benefits of contiguous memory access outweigh the occasional
    inefficiencies from unused capacity or the resizing operation.

 */

public class ArrayQueue<E> implements Queue<E> {

    // Instance variables
    private static final int CAPACITY = 10;
    private E[] data;                               // Generic array used for storage
    private int f = 0;                              // Index of the front element
    private int sz = 0;                             // Current number of elements

    // Constructors
    public ArrayQueue() {                           // Constructs queue with default capacity
        this(CAPACITY);
    }
    public ArrayQueue(int capacity) {               // Constructs queue with given capacity
        data = (E[]) new Object[capacity];          // Safe cast; compiler may give warning
    }

    // Methods

    // Returns the number of elements in the queue
    @Override
    public int size() {
        return sz;
    }

    // Tests whether the queue is empty
    @Override
    public boolean isEmpty() {
        return (sz == 0);
    }

    // Inserts an element at the rear of the queue
    @Override
    public void enqueue(E e) {

        if (sz == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        int avail = (f + sz) % data.length;         // Use modular arithmetic
        data[avail] = e;
        sz++;

    }

    // Returns, but does not remove the first element of the queue (null if empty)
    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[f];
    }

    // Removes and return the first element of the queue (null if empty)
    @Override
    public E dequeue() {

        if (isEmpty()) {
            return null;
        }
        E answer = data[f];
        data[f] = null;                             // Dereference to help garbage collection
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }
}
