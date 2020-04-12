package algo.sort.merge;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] notSortedInts = new int[]{23, 42, 53, 11, 56, 25, 3, 101, 205, 29, 88};
        MergeSort.sort(notSortedInts);

        System.out.println(Arrays.toString(notSortedInts));
    }
}
