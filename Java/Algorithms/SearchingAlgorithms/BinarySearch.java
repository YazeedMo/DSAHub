package org.dsahub;

/*
    BINARY SEARCH ALGORITHM
    ------------------------------------------------------------------------------------
    The Binary Search Algorithm locates a specific target element within a sorted array
    by repeatedly halving the search range, similar to the way you would search for a
    word in the dictionary. Starting with the whole array, it compares the target with
    the middle element adjusts the search range based on this comparison. With each
    iteration, the algorithm reduces the search range by half, resulting in a logarithmic
    time complexity and making it much faster than linear search methods.
    ------------------------------------------------------------------------------------

 */

public class BinarySearch {

    // Binary Search algorithm function
    static int binarySearch(int[] array, int target) {

        int left = 0;                                   // Index of the leftmost element
        int right = array.length - 1;                   // Index of the rightmost element

        while (left <= right) {

            int mid = left + (right - left) / 2;        // Calculate the middle index

            if (array[mid] == target) {
                return mid;                             // Target found, return the index
            }
            else if (array[mid] < target) {
                left = mid + 1;                         // Target is in the right half, update left index
            }
            else {
                right = mid - 1;                        // Target is in the left half, update right index
            }

        }
        return -1;                                      // Target not found in the array
    }

}
