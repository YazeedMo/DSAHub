package org.dsahub;


/*
    POSITION INTERFACE
    ------------------------------------------------------------------------------------
    Description:
    - An interface for positions within a positional list.

    Characteristics:
    - Represents a position in a positional list.
    - Provides a method to retrieve the element stored at this position.

    Operation/Methods:
    - getElement(): Returns the element stored at this position.
 */


public interface PositionInterface<E> {

    // Returns the element stored at this position
    E getElement() throws IllegalStateException;

}
