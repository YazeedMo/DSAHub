package org.dsahub;

import java.util.Iterator;

@SuppressWarnings("unchecked")                              // Used to suppress compiler warnings related to unchecked type conversions
public class DynamicArray<T> implements Iterable<T> {

    private T[] arr;                                        // Array to store the elements
    private int len = 0;                                    // Length user thinks array is
    private int capacity = 0;                               // Actual array size

    // Default constructor with an initial capacity of 16
    public DynamicArray() {
        this(16);
    }

    // Parameterized constructor with a specific initial capacity
    public DynamicArray(int capacity) {
        if (capacity < 0) { throw new IllegalArgumentException("Illegal Capacity: " + capacity); }
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];                   // Create an array of Object and then cast it ti an array of type T
    }

    // Method to get the number of elements currently in the array
    public int size() { return len; }

    // Method to check if the array is empty
    public boolean isEmpty() { return size() == 0; }

    // Method to get the element at a specific index in the array
    public T get(int index) {
        if (index < 0 || index >= len) {
            throw  new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        return arr[index];
    }

    // Method to set (update) the element at a specific index in the array
    public void set(int index, T element) {
        if (index < 0 || index >= len) {
            throw new IndexOutOfBoundsException("Index: " + index + "Size: " + size());
        }
        arr[index] = element;
    }

    // Method to remove all elements from the array
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            arr[i] = null;
        }
        len = 0;
    }

    // Method to add a new element to the array
    public void add(T elem) {
        if (len + 1 >= capacity) {                          // Check if adding another element would exceed the current capacity
            if (capacity == 0) {
                capacity = 1;
            }
            else {
                capacity *= 2;                              // If the array is already populated, double the capacity for more space
            }
            T[] newArr = (T[]) new Object[capacity];        // Create a new array with the updated capacity
            if (len >= 0) System.arraycopy(arr, 0, newArr, 0, len); // Copy existing elements from the old array to the new array
            arr = newArr;
        }
        arr[len++] = elem;                                  // Add the new element to the array at the current length (len) index
    }

    // Method to remove an element a specific index
    public T removeAt(int rmIndex) {
        if (rmIndex >= len || rmIndex < 0) { throw new IndexOutOfBoundsException(); } // Bounds checking

        T data = arr[rmIndex];
        T[] new_arr = (T[]) new Object[len - 1];            // Create a new array with the updated size (len - 1)

        // Copy elements from old array to the new array, excluding the element at rmIndex
        for (int i = 0, j = 0; i < len; i++, j++) {
            if (i == rmIndex) {
                j--;                                        // Skip the element at rmIndex by decrementing j
            }
            else {
                new_arr[j] = arr[i];                        // Copy other elements from arr to new_arr
            }
        }
        arr = new_arr;
        capacity = --len;
        return data;
    }

    // Method to remove a specific element from the array
    public boolean remove(Object obj) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(obj)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    // Method to find the index of a specific element
    public int indexOf(Object obj) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    // Method to check if the array contains a specific element
    public boolean contains(Object obj) {
        return indexOf((obj)) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

    @Override
    public String toString() {
        if (len == 0) {
            return "[]";
        }
        else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for (int i = 0; i < len; i++) {
                sb.append(arr[i]).append(", ");
            }
            return sb.append(arr[len - 1]).append("]").toString();
        }

    }
}
