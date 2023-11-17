package org.dsahub;


/*
    POSITIONAL LIST INTERFACE
    ------------------------------------------------------------------------------------
    Description:
    - An interface for positional lists.

    Characteristics:
    - Represents a positional list, providing methods for position-based access.
    - Allows insertion, retrieval, and removal of elements based on positions.

    Operation/Methods:
    - size(): Returns the number of elements in the list
    - isEmpty(): Tests whether the list is empty
    - first(): Returns the first Position in the list (or null if empty)
    - last(): Returns the last Position in the list (or null if empty)
    - before(PositionInterface<E> p): Returns the Position immediately before p (or null if p is first)
    - after(PositionInterface<E> p): Returns the Position immediately after p (or null if p is last)
    - addFirst(E e): Inserts element e at the front of the list and returns its new Position
    - addLast(E e): Inserts element e at the back of the list and returns its new Position
    - addBefore(PositionInterface<E> p, E e): Inserts element e before Position p and returns its new Position
    - addAfter(PositionInterface<E> p, E e): Inserts element e after Position p and returns its new Position
    - set(PositionInterface<E> p, E e): Replaces the element stored at Position p and returns the replaced element
    - remove(PositionInterface<E> p): Removes the element stored at Position p and returns it (invalidating p)
 */


// An interface for positional lists
public interface PositionalListInterface<E> {

    // Returns the number of elements in the list
    int size();

    // Tests whether the list is empty
    boolean isEmpty();

    // Returns the first Position in the list (or null, if empty)
    PositionInterface<E> first();

    // Returns the last Position in the list (or null, if empty)
    PositionInterface<E> last();

    // Returns the Position immediately before Position p (or null, if p is first)
    PositionInterface<E> before(PositionInterface<E> p) throws IllegalArgumentException;

    // Returns the Position immediately after Position p (or null, if p is last)
    PositionInterface<E> after(PositionInterface<E> p) throws IllegalArgumentException;

    // Inserts element e at the front of the list and returns its new Position
    PositionInterface<E> addFirst(E e);

    // Inserts element e at the back of the list and returns its new Position
    PositionInterface<E> addLast(E e);

    // Inserts element e immediately before Position p and returns its new Position
    PositionInterface<E> addBefore(PositionInterface<E> p, E e) throws IllegalArgumentException;

    // Inserts element e immediately after Position p and returns its new Position
    PositionInterface<E> addAfter(PositionInterface<E> p, E e) throws IllegalArgumentException;

    // Replaces the element stored at Position p and returns the replaces element
    E set(PositionInterface<E> p, E e) throws IllegalArgumentException;

    // Removes the element stored at Position p and returns it (invalidating p)
    E remove(PositionInterface<E> p) throws IllegalArgumentException;

}
