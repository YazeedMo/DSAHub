package org.dsahub.algorithms;

public class InsertionSort {

    // Insertion-sort of an array of integers into ascending order
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {                   // Begin with second element

            int key = arr[i];                           // Current element to be inserted
            int j = i;

            // Find correct index j for current
            while (j > 0 && arr[j - 1] > key) {
                arr[j] = arr[j - 1];                    // Slide arr[j - 1] to the right
                j--;
            }
            arr[j] = key;                               // Insert current element at its correct position
        }
    }
}
