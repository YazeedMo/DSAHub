package org.dsahub;

/*
    INSERTION SORT ALGORITHM
    ------------------------------------------------------------------------------------
    Simple comparison-based sorting algorithm that works by dividing the input array
    into two sections: a sorted section and an unsorted section. The algorithm iterates
    through the unsorted section, picking one element at a time and inserting it into
    its correct position in the sorted section.

    STEP BY STEP:
    ------------------------------------------------------------------------------------
    1. Start with the first element as the sorted section (since a single element is
       already considered sorted).

    2. Iterate through the unsorted section of the array, starting from the second
       element (index 1) up to the last element.

    3. For each element in the unsorted section, compare it with the elements in the
       sorted section, moving from right to left.

    4. If the currrent element is smaller than the element being compared in the sorted
       section, shift the compared element one position to the right.

    5. Repeat this process until you find the correct positon in the sorted section.

    6. Insert the current element into its correct position in the sorted section.

    7. Repeat steps 3-6 for each element in the insorted section unitl the entire array
       is sorted.

    8. The algorithm terminates when all elements have been inserted into their correct
       positions, resulting in a sorted array.


    COMPLEXITY ANALYSIS:
    ------------------------------------------------------------------------------------
    - Time Complexity:  O(n^2)
    - Space Complexity: O(1)
    - Less efficient compared to more advanced sorting algorithms like Merge Sort or Quick Sort
    - Performs well on small input sizes or partially sorted arrays
    - Insertion Sort is an "in-place" sorting algorithm - it operates directly on the input
      array without requiring additional memory

*/

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
