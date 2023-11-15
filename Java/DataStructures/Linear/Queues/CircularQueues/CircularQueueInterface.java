package org.dsahub;


/*
    CIRCULAR QUEUE INTERFACE
    ------------------------------------------------------------------------------------
    Description:
    - An interface that extends QueueInterface, introducing a rotate() method.
    - The rotate() method rotates the front element of the queue to the back.

    Characteristics:
    - Extends the basic functionality of QueueInterface.
    - Introduces a rotate() method for circular rotation.

    Operation/Methods:
    - size()
    - isEmpty()
    - first(): Returns (but does not remove) the front element
    - enqueue(E e): Adds element e to the rear of the queue
    - dequeue(): Removes and returns the front element of the queue
    - rotate(): Rotates the front element of the queue to the back

 */


public interface CircularQueueInterface<E> extends QueueInterface<E> {

    // Rotates he front element of the queue to the back of the queue
    // Does nothing if the queue is empty
    void rotate();

}
