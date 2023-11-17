package org.dsahub;


/*
    ARRAY LIST
    ------------------------------------------------------------------------------------
    Description:
    - Implements the ListInterface using a dynamic array.

    Characteristics:
    - Time complexity:
        * Access: O(1)
        * Search: O(n)
        * Insertion: O(n)
        * Deletion: O(n)
    - Space complexity: O(n)

    - Advantages: Dynamic resizing, constant-time access, and efficient appends.
    - Disadvantages: Costly insertions and deletions, higher memory overhead.

    Operation/Methods:
    - size(): Returns the number of elements in the list
    - isEmpty(): Returns whether the list is empty
    - get(int i): Returns (but does not remove) the element at index i
    - set(int i, E e): Replaces the element at index i with e and returns the replaced element
    - add(int i, E e): Inserts element e to be at index i, shifting all subsequent elements later
    - remove(int i): Removes/returns the element at index i, shifting subsequent elements earlier
 */


public class ArrayList<E> implements ListInterface<E> {


    // INSTANCE VARIABLES

    public static final int CAPACITY = 16;          // Default array capacity
    private E[] data;                               // Generic array used for storage
    private int size = 0;                           // Current number of elements


    // CONSTRUCTORS

    // Constructs list with default capacity
    public ArrayList() {
        this(CAPACITY);
    }

    // Constructs list with given capacity
    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];          // Safe cast; compiler may give warning
    }


    // ACCESS METHODS

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns (but does not remove) the element at index i
    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }


    // PUBLIC UPDATE METHODS

    // Replaces the element at index i with e, and returns the replaced element
    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    // Inserts element e to be at index i, shifting all subsequent elements later
    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {

        checkIndex(i, size + 1);
        if (size == data.length) {
            resize(2 + data.length);
        }

    }

    // Removes/returns the element at index i, shifting subsequent elements earlier
    @Override
    public E remove(int i) throws IndexOutOfBoundsException {

        checkIndex(i, size);
        E temp = data[i];

        for (int k = i; k < size - 1; k++) {        // Shift elements to fill hole
            data[k] = data[k + 1];
        }
        data[size - 1] = null;                      // Help garbage collection
        size--;
        return temp;

    }


    // PRIVATE UTILITY METHODS

    // Checks whether the given index is in the range [0, n - 1]
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
    }

    // Resizes internal array to have given capacity >= size
    protected void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];      // Safe cast, compiler may give warning
        for (int k = 0; k < size; k++) {
            temp[k] = data[k];
        }
        data = temp;                                // Start using the new array
    }
}
