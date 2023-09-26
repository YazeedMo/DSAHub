package org.dsahub;

/*
    ArrayStack
    ------------------------------------------------------------------------------------
    A concrete implementation of the Stack interface using an array as its underlying
    storage mechanism. The ArrayStack offers constant time performance for basic operations
    such as push, pop, and top assuming the array does not require resizing

    Advantages:
    - Predictable Performance: Memory is allocated contiguously, which can be cache-friendly
      leading to efficient access times.
    - Memory Overhead: Typically lower than that of a LinkedStack since there's no need to
      store additional pointers

    Disadvantages:
    - Fixed Capacity: While it has a dynamic resizing mechanism, the resizing operation
      (if not implemented) can b costly. This means that the stack has either a fixed
      maximum size or can occasionally experience a higher cost for push operations when
      a resize is required.
    - Space Inefficiency: If the array is much larger than the actual number of stored elements,
      it can lead to wasted memory.

    In practice, ArrayStack is suitable for scenarios where the maximum size of the stack
    is relatively predictable and where the advantages of contiguous memory access outweigh
    the potential inefficiencies of occasional resizing or unused capacity.


 */

public class ArrayStack<E> implements Stack<E> {

    public static final int CAPACITY = 1000;            // Default array capacity
    private E[] data;                                   // Generic array used for storage
    private int t = -1;                                 // Index of the top element in stack

    public ArrayStack() {                               // Constructs stack with default capacity
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {                   // Constructs stack with given capacity
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return (t + 1);
    }

    @Override
    public boolean isEmpty() {
        return (t == -1);
    }

    @Override
    public void push(E e) {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        else {
            data[++t] = e;                                  // Increment t before storing new item
        }
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        else {
            return data[t];
        }
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        else {
            E answer = data[t];
            data[t] = null;                                 // Dereference to help garbage collection
            t--;
            return answer;
        }
    }
}
