package org.dsahub;


/*
    LINKED QUEUE
    ------------------------------------------------------------------------------------
    Description:
    - A linear data structure that follows the First In, First Out (FIFO) principle.
    - Implemented using the adapter pattern to adapt a SinglyLinkedList to the QueueInterface.

    Characteristics:
    - Time complexity:
        * Enqueue: O(1)
        * Dequeue: O(1)
        * Access: O(1)
        * Search: O(n)
     - Space complexity: O(n)
     - Use cases: When elements need to be processed in a specific order, and dynamic resizing is not a concern.

     - Advantages: Constant time enqueue and dequeue operations, flexibility through adapter pattern.
     - Disadvantages: Limited capacity, dynamic resizing handled by the underlying SinglyLinkedList.

     Operation/Methods:
     - size()
     - isEmpty()
     - first(): Returns (but does not remove) the front element
     - enqueue(E e): Adds element e to the rear of the queue
     - dequeue(): Removes and returns the front element of the queue

 */


public class LinkedQueue<E> implements QueueInterface<E> {


    // INSTANCE VARIABLES

    // This implementation uses the adapter pattern to adapt
    // the SinglyLinkedList to the QueueInterface
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();    // An empty list


    // CONSTRUCTORS

    public LinkedQueue() {}                     // New queue relies on the initially empty list


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
    public E first() {
        return list.first();
    }


    // PUBLIC UPDATE METHODS

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

}
