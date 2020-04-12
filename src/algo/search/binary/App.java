package algo.search.binary;

public class App {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(binarySearch(ints, 4));
        System.out.println(binarySearch(ints, 8));
        System.out.println(binarySearch(ints, 1));
    }

    /**
     * Searching in SORTED list
     * @param a array of integers
     * @param k integer value to be found
     * @return index position of the searched value
     */
    public static int binarySearch(int[] a, int k) {
        // Beginning of the searched array
        int p = 0;
        // End of the searched array
        int r = a.length - 1;

        // Loop until beginning crosses the end
        while (p <= r) {
            // Middle of the searched (flore)
            int q = (r + p) / 2;

            if (a[q] == k) {
                // Return matching index
                return q;
            }

            if (a[q] > k) {
                // Moving end to the middle - 1
                r = q - 1;
            } else {
                // Moving beginning to the middle + 1;
                p = q + 1;
            }
        }
        // Return no matching index
        return -1;
    }
}
