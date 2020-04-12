package algo.sort.quick;

/**
 * Example implementation of QuickSort
 */
public class QuickSort {
    /**
     * Sorts the provided array
     * @param a array of integers
     */
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    /**
     * Sorting the provided array (with start and end parameters)
     * @param a the array in sort
     * @param start the starting index of the sort operation
     * @param end the end index
     */
    public static void sort(int[] a, int start, int end) {
        if (start < end) {
            int q = partition(a, start, end, end);
            sort(a, start, q - 1);
            sort(a, q + 1, end);
        }
    }

    /**
     * Partitioning array around pivot element
     * @param a the array in sort
     * @param start the starting index of the sort part
     * @param end the end index of the sort part
     * @param pivotIndex the start index of the pivot element
     * @return final index of the pivot element
     */
    private static int partition(int[] a, int start, int end, int pivotIndex) {
        // Pivot element value
        int pivot = a[pivotIndex];
        // The comparison index start point
        int comparisonIndex = start;
        // The swap index start point
        int swapIndex = comparisonIndex - 1;

        // Iterating until comparison index matches the end (pivot index)
        while (comparisonIndex <= end) {
            // If comparison element is less than or equal to the pivot -> swap
            if (a[comparisonIndex] <= pivot) {
                swapIndex++;
                int temp = a[comparisonIndex];
                a[comparisonIndex] = a[swapIndex];
                a[swapIndex] = temp;
            }
            // Move comparison index further
            comparisonIndex++;
        }

        // Return the final pivot index
        return swapIndex;
    }
}
