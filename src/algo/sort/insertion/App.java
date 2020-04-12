package algo.sort.insertion;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // Initialize unsorted array
        int[] notSortedInts = new int[]{23, 42, 53, 11, 56, 25, 3, 101, 205, 29, 88};

        // Print into the console sorted array
        System.out.println(Arrays.toString(insertionSort(notSortedInts)));
    }

    public static int[] insertionSort(int[] a) {
        // Keeps the last sorted element
        int sortedIndex = 0;

        // Iterate until the last sorted element matches the last element of the array
        while (sortedIndex != a.length - 1) {
            // Keeps the index of the first unsorted element
            int firstUnsortedIndex = sortedIndex + 1;
            // Backward iteration over the sorted part of the array
            for (int i = sortedIndex; i >= 0; i--) {
                // Checks if the first unsorted is less than the last sorted
                if (a[firstUnsortedIndex] < a[i]) {
                    // Switch the elements
                    int temp = a[i];
                    a[i] = a[firstUnsortedIndex];
                    a[firstUnsortedIndex] = temp;
                    // Update the index of the first unsorted element
                    firstUnsortedIndex = i;
                }
            }
            // Move the index of the last sorted element forward
            sortedIndex++;
        }

        // Return sorted array
        return a;
    }
}
