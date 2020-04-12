package algo.search.recursion;

public class App {
    public static void main(String[] args) {
        int[] notSortedInts = new int[]{23, 42, 53, 56, 25, 29, 88};
        System.out.println(
            "Recursive linear search: " +
                recursiveLinearSearch(
                    notSortedInts,
                    0,
                    101
                )
        );

        int[] sortedInts = new int[]{23, 42, 53, 56, 75, 89, 188, 212, 402, 552, 1001};
        System.out.println(
            "Recursive binary search: " +
            recursiveBinarySearch(
                sortedInts,
                0,
                sortedInts.length - 1,
                1001
            )
        );
    }

    public static void reduceByOne(int n) {
        if (n > 0) {
            reduceByOne(n-1);
        }
        System.out.println(n);
    }

    /**
     * Implementation of recursive linear search
     * @param ints array of integers
     * @param i start index of search
     * @param x value to be searched for
     * @return index of searched value or -1 if not in array
     */
    public static int recursiveLinearSearch(int[] ints, int i, int x) {
        int n = ints.length-1;

        if (i > n) {
            return -1;
        } else if (ints[i] == x) {
            return i;
        } else {
            return recursiveLinearSearch(ints, i+1, x);
        }
    }

    /**
     * Implementation of recursive binary search
     * @param ints array of sorted integers
     * @param p start index of searched range
     * @param r end index of searched range
     * @param x value to be searched for
     * @return index of searched value or -1 if not in array
     */
    public static int recursiveBinarySearch(int[] ints, int p, int r, int x) {
        int q = (p + r) / 2;

        if (p > r) {
            return -1;
        } else if (ints[q] == x) {
            return q;
        } else {
            if (ints[q] < x) {
                p = q + 1;
            } else {
                r = q - 1;
            }
            return recursiveBinarySearch(ints, p, r, x);
        }
    }
}
