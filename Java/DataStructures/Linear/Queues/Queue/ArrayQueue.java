package org.dsahub;


/*
    ARRAY QUEUE
    ------------------------------------------------------------------------------------
    Description:
    - A linear data structure that follows the First In, First Out (FIFO) principle.
    - Elements are enqueued at the rear and dequeued from the front.

    Characteristics:
    - Time complexity:
        * Enqueue: O(1)
        * Dequeue: O(1)
        * Access: O(1)
        * Search: O(n)
     - Space complexity: O(n)
     - Use cases: When elements need to be processed in a specific order, such as task scheduling.

     - Advantages: Constant time enqueue and dequeue operations.
     - Disadvantages: Limited capacity, dynamic resizing can be costly.

     Operation/Methods:
     - size()
     - isEmpty()
     - first(): Returns (but does not remove) the front element
     - enqueue(E e): Adds element e to the rear of the queue
     - dequeue(): Removes and returns the front element of the queue

 */


public class ArrayQueue<E> implements QueueInterface<E> {

    // INSTANCE VARIABLES

    public static final int CAPACITY = 1000;    // Default array capacity
    private E[] data;                           // Generic array used for storage
    private int f = 0;                          // Index of the front element
    private int size = 0;                       // Current number of elements


    // CONSTRUCTORS

    // Constructs queue with default capacity
    public ArrayQueue() {
        this(CAPACITY);
    }

    // Constructs queue with given capacity
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];      // Safe cast; compiler may give warning
    }


    // ACCESS METHODS

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[f];
    }


    //
    // PUBLIC UPDATE METHODS

    @Override
    public void enqueue(E e) {
        if (size == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        int avail = (f + size) % data.length;
        data[avail] = e;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        size--;
        return answer;
    }

}
