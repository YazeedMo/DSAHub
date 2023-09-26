package org.dsahub;

/*
    STACK INTERFACE
    ------------------------------------------------------------------------------------
    A collection of objects that are inserted and removed according to the last-in-first-out
    principle. Although similar in purpose, this interface differs from java.util.stack

    The Stack interface provides a level of abstraction that allows multiple concrete implementations,
    ensuring a consistent set of behaviours regardless of the underlying details. In ths context,
    there are two main implementations: ArrayStack and LinkedStack. The ArrayStack, as the
    name suggests, uses an array as its underlying storage mechanism, while the LinkedStack
    would use a Linked list structure

 */

public interface Stack<E> {

    // Returns the number of elements in the stack
    int size();

    // Test whether the stack is empty
    boolean isEmpty();

    // Inserts an element at the top of the stack
    void push(E e);

    // Returns, but does not remove, the element at the tops of the stack
    E top();

    // Removes and returns he top element from the stack
    E pop();

}

