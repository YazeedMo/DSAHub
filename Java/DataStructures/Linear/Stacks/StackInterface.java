package org.dsahub;

/*
    STACK INTERFACE
    ------------------------------------------------------------------------------------
    Description:
    - An interface representing the basic operations of a stack, including size, emptiness,
      pushing, popping, and accessing the top element.

    Methods:
    - size(): Returns the number of elements in the stack.
    - isEmpty(): Tests whether the stack is empty.
    - push(E e): Inserts an element at the top of the stack.
    - top(): Returns (but does not remove) the element at the top of the stack.
    - pop(): Removes and returns the top element from the stack.
*/

public interface StackInterface<E> {

    // Returns the number of elements in the stack
    int size();

    // Tests whether the stack is empty
    boolean isEmpty();

    // Inserts an element at the top of the stack
    void push(E e);

    // Returns (but does not remove) the element at the top of the stack
    E top();

    // Removes and returns the top element from the stack
    E pop();

}
