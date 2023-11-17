package org.dsahub;


/*
    LIST INTERFACE
    ------------------------------------------------------------------------------------
    Description:
    - A simplified version of the java.util.List interface.

    Characteristics:
    - Time complexity:
        * Access: O(n)
        * Search: O(n)
        * Insertion: O(n)
        * Deletion: O(n)
    - Space complexity: O(n)

    - Advantages: General-purpose interface for list-based data structures.
    - Disadvantages: The time complexity may vary depending on the underlying implementation.

    Operation/Methods:
    - size(): Returns the number of elements in the list
    - isEmpty(): Returns whether the list is empty
    - get(int i): Returns (but does not remove) the element at index i
    - set(int i, E e): Replaces the element at index i with e and returns the replaced element
    - add(int i, E e): Inserts element e to be at index i, shifting all subsequent elements later
    - remove(int i): Removes/returns the element at index i, shifting subsequent elements earlier
 */


public interface ListInterface<E> {

    // Returns the number of elements in the list
    int size();

    // Returns whether the list is empty
    boolean isEmpty();

    // Returns (but does not remove) the element at index i
    E get(int i) throws IndexOutOfBoundsException;

    // Replaces the element at index i with e, and returns the replaced element
    E set(int i, E e) throws IndexOutOfBoundsException;

    // Inserts element e to be at index i, shifting all subsequent elements later
    void add(int i, E e) throws IndexOutOfBoundsException;

    // Removes/returns the element at index i, shifting subsequent elements earlier
    E remove(int i) throws IndexOutOfBoundsException;

}
