package org.dsahub;


/*
    LINKED STACK (USING ADAPTER PATTERN)
    ------------------------------------------------------------------------------------
    Description:
    - Implementation of a stack using a singly linked list.

    Characteristics:
    - Time complexity:
        * Access (top): O(1)
        * Search: O(n)
        * Insertion (push): O(1)
        * Deletion (pop): O(1)
    - Space complexity: O(n)
    - Use cases: When dynamic size and constant-time access and insertion/removal
      at the top are required.

    - Advantages: Dynamic size, efficient insertions/removals at the top.
    - Disadvantages: O(n) search time, higher memory overhead compared to arrays.

    Operation/Methods:
    - size(): Returns the number of elements in the stack.
    - isEmpty(): Tests whether the stack is empty.
    - push(E e): Inserts an element at the top of the stack.
    - top(): Returns (but does not remove) the element at the top of the stack.
    - pop(): Removes and returns the top element from the stack.
*/


public class LinkedStack<E> implements StackInterface<E> {


    // INSTANCE VARIABLES

    // This implementation uses the adapter pattern to adapt
    // the SinglyLinkedList to the StackInterface
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();    // An empty list


    // CONSTRUCTORS

    public LinkedStack() {}                   // New stack relies on the initially empty list


    // ACCESS METHODS

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public E top() {
        return list.first();
    }


    // PUBLIC UPDATE METHODS

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }
}
