package algo.sort.merge;

/**
 * Example implementation of MergeSort
 */
public class MergeSort {
    /**
     * Sorts the provided array
     * @param a array of integers
     */
    public static void sort(int[] a) {
        // Pass the range of the initial array to the recursive method
        sort(a, 0, a.length-1);
    }

    /**
     * Sorting the provided array (with start and end parameters)
     * @param a the array in sort
     * @param start the starting index of the sort operation
     * @param end the end index
     */
    public static void sort(int[] a, int start, int end) {
        // Proceed with splitting when the start index is less then end one
        if (start < end) {
            // Find the middle of the array
            int mid = (start + end) / 2;
            // Pass the range of the left part
            sort(a, start, mid);
            // Pass the range of the right part
            sort(a, mid + 1, end);
            // Merge sorted sub arrays
            merge(a, start, mid, end);
        }
    }

    /**
     * Merging two sorted parts into single
     * @param a the array in sort
     * @param start the starting index of the sort operation
     * @param mid the ~ middle index
     * @param end the end index
     */
    private static void merge(int[] a, int start, int mid, int end) {
        // Create left array
        int[] leftArray = new int[2 + (mid - start)];
        // Create right array
        int[] rightArray = new int[1 + (end - mid)];

        // Fill the new arrays
        for (int i = start; i <= end; i++) {
            if (i <= mid) {
                leftArray[i - start] = a[i];
            } else {
                rightArray[i - (mid + 1)] = a[i];
            }
        }
        // Add for max values to the last elements for comparision reasons
        leftArray[leftArray.length - 1] = Integer.MAX_VALUE;
        rightArray[rightArray.length - 1] = Integer.MAX_VALUE;

        // Init current tracker indexes for left, right and output arrays
        int lIndex = 0;
        int rIndex = 0;
        int oIndex = start;

        // Insert new values for the range specified
        while (oIndex <= end) {
            if (leftArray[lIndex] < rightArray[rIndex]) {
                // The value for the left index is taken
                a[oIndex] = leftArray[lIndex];
                // Increasing left index
                lIndex++;
            } else {
                // The value for the right index is taken
                a[oIndex] = rightArray[rIndex];
                // Increasing right index
                rIndex++;
            }

            // Increasing output index
            oIndex++;
        }
    }
}
