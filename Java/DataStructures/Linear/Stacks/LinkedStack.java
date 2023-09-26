package org.dsahub;

/*
    LinkedStack
    ------------------------------------------------------------------------------------
    A concrete implementation of the Stack interface using a singly linked list as its
    underlying mechanism. LinkedStack offers dynamic sizing, growing and shrinking as
    elements are added or removed. It provides constant-time performance for its basic
    operations without the need for any resizing operations.

    Advantages:
    - Dynamic Sizing: Automatically grows and shrinks without the need for manual resizing.
    - Consistent Performance: Operations like push, pop, and top are consistently fast
      regardless of the size of the stack.

    Disadvantages:
    - Memory Overhead: Each element in the linked list introduces an overhead of storing an
      additional pointer for the next node. This makes LinkedStack generally consume more
      memory per element that ArrayStack.

    Adapter Pattern:
    The LinkedStack serves as an example of the Adapter Pattern, where the underlying
    SinglyLinkedList class provides a rich interface with various methods. However,
    the LinkedStack adapts this interface to provide only the specific methods required
    for the Stack behaviour (push, pop, top). By doing so, it 'adapts' the more general
    encapsulation and separation of concerns.

    In practice, LinkedStack is suitable for scenarios where dynamic growth and shrinkage
    are anticipated and where the consistent performance of stack operations is preferred
    over potential memory overhead concerns.

 */

public class LinkedStack<E> implements Stack<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>();        // An empty list
    private LinkedStack() { }                                           // New stack relies on the initially empty list

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E top() {
        return list.first();
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }
}
