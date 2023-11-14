package org.dsahub;


/*
    ARRAY STACK
    ------------------------------------------------------------------------------------
    Description:
    - Implementation of a stack using an array.

    Characteristics:
    - Time complexity:
        * Access (top): O(1)
        * Search: O(n)
        * Insertion (push): O(1)
        * Deletion (pop): O(1)
    - Space complexity: O(n)
    - Use cases: When the size of the stack is known, and constant-time access and
      insertion/removal at the top are required.

    - Advantages: Efficient access and insertion/removal at the top.
    - Disadvantages: Fixed capacity, potential wasted space or need for resizing.

    Operation/Methods:
    - size(): Returns the number of elements in the stack.
    - isEmpty(): Tests whether the stack is empty.
    - push(E e): Inserts an element at the top of the stack.
    - top(): Returns (but does not remove) the element at the top of the stack.
    - pop(): Removes and returns the top element from the stack.
*/


public class ArrayStack<E> implements StackInterface<E> {


    // INSTANCE VARIABLES

    public static final int CAPACITY = 1000;    // Default array capacity
    private E[] data;                           // Generic array used for storage
    private int t = -1;                         // Index of top element in stack


    // CONSTRUCTORS

    // Constructs stack with default capacity
    public ArrayStack() {
        this(CAPACITY);
    }

    // Constructs stack with given capacity
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];      // safe cast; compiler may give warning
    }


    // ACCESS METHODS

    public int size() {
        return (t + 1);
    }
    public boolean isEmpty() {
        return (t == -1);
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return data[t];
    }

    // PUBLIC UPDATE METHODS

    @Override
    public void push(E e) {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[++t] = e;                          // Increment t before storing new item
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E answer = data[t];
        data[t] = null;                         // Dereference to help garbage collection
        t--;
        return answer;
    }
}
