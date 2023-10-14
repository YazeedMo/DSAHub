package org.dsahub;

/*
    LINKED DEQUE
    ------------------------------------------------------------------------------------
    A concrete implementation of the Deque interface using a doubly linked list as its
    underlying storage mechanism. The LinkedDeque supports efficient operations at both
    ends of the collection, allowing for flexibility and diverse applications.

    Advantages:
    - Dynamic Size: The deque can grow or shrink as required without resizing overhead.
    - Efficient Operations: Supports constant-time insertions and deletions at both ends.

*/

public class LinkedDeque<E> implements Deque<E> {

    private DoublyLinkedList<E> list = new DoublyLinkedList<>();  // Doubly linked list for storage

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public E last() {
        return list.last();
    }

    @Override
    public void addFirst(E e) {
        list.addFirst(e);
    }

    @Override
    public void addLast(E e) {
        list.addLast(e);
    }

    @Override
    public E removeFirst() {
        return list.removeFirst();
    }

    @Override
    public E removeLast() {
        return list.removeLast();
    }

    // Assuming you already have a DoublyLinkedList class, otherwise, we'll have to create that as well.
}
