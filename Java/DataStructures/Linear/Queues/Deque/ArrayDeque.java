package org.dsahub;


/*
    ARRAY DEQUE
    ------------------------------------------------------------------------------------
    Description:
    - A double-ended queue (deque) implementation using a generic array for storage.
    - Supports adding and removing elements from both the front and the back.

    Characteristics:
    - Time complexity:
        * Access: O(n)
        * Search: O(n)
        * Insertion: O(1) for head, O(n) for tail (unless tail pointer is used)
        * Deletion: O(1) for head, O(n) for tail or specific node
     - Space complexity: O(n)
     - Use cases: When dynamic size and frequent insertions/deletions at both ends are needed.

     - Advantages: Dynamic size, efficient insertions/deletions at both ends.
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


public class ArrayDeque<E> implements DequeInterface<E> {


    // INSTANCE VARIABLES

    public static final int CAPACITY = 1000;    // Default array capacity
    private E[] data;                           // Generic array used for storage
    private int f = 0;                          // Index of the front element
    private int size = 0;                       // Current number of elements


    // CONSTRUCTORS

    // Constructs deque with default capacity
    public ArrayDeque() {
        this(CAPACITY);
    }

    // Constructs deque with given capacity
    public ArrayDeque(int capacity) {
        data = (E[]) new Object[capacity];     // Safe cast; compiler may give warning
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

    @Override
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return data[(f + size - 1) % data.length];
    }

    @Override
    public void addFirst(E e) {
        if (size == data.length) {
            throw new IllegalStateException("Deque is full");
        }
        f = (f - 1 + data.length) % data.length;
        data[f] = e;
    }

    @Override
    public void addLast(E e) {
        if (size == data.length) {
            throw new IllegalStateException("Deque is full");
        }
        int avail = (f + size) % data.length;
        data[avail] = e;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E answer = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        size--;
        return answer;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        int index = (f + size - 1) % data.length;
        E answer = data[index];
        data[index] = null;
        size--;
        return answer;
    }
}
