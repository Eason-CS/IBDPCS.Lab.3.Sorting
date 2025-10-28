package org.example;

/**
 * Sorting Algorithms Implementation
 *
 * Name: Eason
 * Date: 2025.10.28
 *
 * This class implements bubble sort and selection sort algorithms.
 * Complete the implementation and analyze the time complexity.
 */
public class SortingAlgorithms {

    /**
     * Bubble Sort Algorithm
     * The bubble sort algorithm uses pairs to check if the next element in the list 
     * is larger than the current element (assuming you are sorting lowest to highest).
     * If the items are in the wrong order then they swap.
     *
     * Time Complexity: O(n^2) - explain: the outer loop runs n times, and the inner loop runs n - i - 1 times (roughly n times).
     * As such, the total time will be n x n = n^2
     *
     * Space Complexity: O(1) - explain: the algorithm does not require additional data structure.
     * It only needs a constant amount of additional memory space.
     *
     * @param arr The array to be sorted
     */
    public static void bubbleSort(int[] arr) {
        // TODO: Implement bubble sort
        // Hint 1: You'll need nested loops
        // Hint 2: The outer loop controls the number of passes
        // Hint 3: The inner loop performs comparisons and swaps
        // Hint 4: After each pass, the largest element "bubbles" to its correct position

        int n = arr.length;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {

            // Add a boolean flag to optimize (optional enhancement)
            boolean swapped = false;

            // Inner loop for comparisons in each pass
            // Note: Why do we use (n - i - 1)? Think about what happens after each pass
            for (int k = 0; k < n - i - 1; k++){
                if(arr[k] > arr[k+1]){
                    int temp = arr[k];
                    arr[k] = arr[k+1];
                    arr[k+1] = temp;
                    swapped =true;
                }
            }
            // YOUR CODE HERE

            // Optional optimization: if no swaps occurred, array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Selection Sort Algorithm  
     * The selection sort algorithm uses a variable to track the index of the highest value
     * element (sorting lowest to highest). At the end of the pass, the highest value is
     * moved into the correct space.
     *
     * Time Complexity: O(n^2) - explain: the total comparison is (n-1) + (n-2) + ... + 1 = n(n-1)/2
     * This is represented as n^2
     * Space Complexity: O(1) - explain: Same as the bubble sort, the selection sort uses a fixed amount of extra memory.
     * Therefore, its time complexity is 1
     *
     * @param arr The array to be sorted
     */
    public static void selectionSort(int[] arr) {
        // TODO: Implement selection sort
        // Hint 1: Find the minimum element in the unsorted portion
        // Hint 2: Swap it with the element at the beginning of unsorted portion
        // Hint 3: Move the boundary between sorted and unsorted portions

        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {

            // Find the minimum element in unsorted array
            // YOUR CODE HERE

            int SmallestIndex = i;

            for (int k = i+1; k < n; k++){
                if(arr[k] < arr[SmallestIndex]){
                    SmallestIndex = k;
                }
            }

            int temp = arr[SmallestIndex];
            arr[SmallestIndex] = arr[i];
            arr[i] = temp;

            // Swap the found minimum element with the first element
            // YOUR CODE HERE

        }
    }

    /**
     * Helper method to swap two elements in an array
     * @param arr The array
     * @param i First index
     * @param j Second index
     */
    private static void swap(int[] arr, int i, int j) {
        // TODO: Implement swap
        // Remember: You need a temporary variable

        // YOUR CODE HERE

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =  temp;
    }

    /**
     * Helper method to print an array
     * @param arr The array to print
     * @param message Optional message to display before the array
     */
    public static void printArray(int[] arr, String message) {
        System.out.print(message + ": ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * Creates a copy of an array (useful for testing both sorts on same data)
     * @param original The array to copy
     * @return A new array with the same values
     */
    public static int[] copyArray(int[] original) {
        int[] copy = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }
        return copy;
    }

    /**
     * Main method for testing your implementations
     */
    public static void main(String[] args) {
        // Test Case 1: Small unsorted array
        int[] testArray1 = {10, 8, 349, 3, 39, 1};

        System.out.println("=== Test Case 1: Basic Array ===");
        int[] bubbleArray1 = copyArray(testArray1);
        int[] selectionArray1 = copyArray(testArray1);

        printArray(testArray1, "Original array");

        // Test bubble sort
        bubbleSort(bubbleArray1);
        printArray(bubbleArray1, "After bubble sort");

        // Test selection sort
        selectionSort(selectionArray1);
        printArray(selectionArray1, "After selection sort");

        System.out.println();

        // Test Case 2: Already sorted array
        int[] testArray2 = {1, 2, 3, 4, 5};

        System.out.println("=== Test Case 2: Already Sorted ===");
        int[] bubbleArray2 = copyArray(testArray2);
        int[] selectionArray2 = copyArray(testArray2);

        printArray(testArray2, "Original array");
        bubbleSort(bubbleArray2);
        printArray(bubbleArray2, "After bubble sort");
        selectionSort(selectionArray2);
        printArray(selectionArray2, "After selection sort");

        System.out.println();

        // Test Case 3: Reverse sorted array
        int[] testArray3 = {5, 4, 3, 2, 1};

        System.out.println("=== Test Case 3: Reverse Sorted ===");
        int[] bubbleArray3 = copyArray(testArray3);
        int[] selectionArray3 = copyArray(testArray3);

        printArray(testArray3, "Original array");
        bubbleSort(bubbleArray3);
        printArray(bubbleArray3, "After bubble sort");
        selectionSort(selectionArray3);
        printArray(selectionArray3, "After selection sort");

        System.out.println();

        // Test Case 4: Array with duplicates
        int[] testArray4 = {3, 5, 3, 2, 5, 1, 2};

        System.out.println("=== Test Case 4: With Duplicates ===");
        int[] bubbleArray4 = copyArray(testArray4);
        int[] selectionArray4 = copyArray(testArray4);

        printArray(testArray4, "Original array");
        bubbleSort(bubbleArray4);
        printArray(bubbleArray4, "After bubble sort");
        selectionSort(selectionArray4);
        printArray(selectionArray4, "After selection sort");

        // Performance comparison
        System.out.println("\n=== Performance Analysis ===");
        System.out.println("Complete the following analysis:");
        System.out.println("1. Which algorithm performed fewer comparisons on an already sorted array?");
        System.out.println("   Answer: bubble sort");
        System.out.println("2. Which algorithm performed fewer swaps on a reverse sorted array?");
        System.out.println("   Answer: selection sort");
        System.out.println("3. What is the worst-case time complexity for bubble sort? n^2");
        System.out.println("4. What is the worst-case time complexity for selection sort? n^2");
        System.out.println("5. What is the best-case time complexity for bubble sort? n");
        System.out.println("6. What is the best-case time complexity for selection sort? n");

        System.out.println();

        // Algorithm Tracing Exercise
        System.out.println("\n=== Algorithm Tracing ===");
        System.out.println("1. Trace through the following array step by step for BOTH algorithms:");
        System.out.println("Array: [5, 2, 8, 1, 9]");
        System.out.println();
        System.out.println("Bubble Sort Trace:");
        System.out.println("Pass 1: 52819 --> 25819 --> 25189");
        System.out.println("Pass 2: 25189 --> 21589");
        System.out.println("Pass 3: 21589 --> 12589");
        System.out.println("Pass 4: 12589");
        System.out.println();
        System.out.println("Selection Sort Trace:");
        System.out.println("Pass 1: 52819 --> 12859");
        System.out.println("Pass 2: 12859 --> 12859");
        System.out.println("Pass 3: 12859 --> 12589");
        System.out.println("Pass 4: 12589");
        System.out.println();
        System.out.println("2. Explain why bubble sort can be optimized but selection sort cannot:");
        System.out.println("This is because if no swaps occur in bubble sort, it means that the array is already sorted.");
        System.out.println("In this case, the bubble sort can stop and thus optimize its efficiency");
        System.out.println("Selection sort, however, needs to scan the unsorted part to find the smallest index and value.");
        System.out.println("This process can not be skipped.");
        System.out.println("3. Explain how you would implement this optimisation within your bubble sort algorithm:");
        System.out.println("We can set up a boolean flag to be false.");
        System.out.println("If the array is swapped, the flag turns to true. Then, the sort will keep going on as the flag is not false");
        System.out.println("On the other hand, if no array is swapped. The flag will remain false.");
        System.out.println("In this case, flag==false indicates that the array is already sorted. Then, the program can stop.");
    }
    
}
