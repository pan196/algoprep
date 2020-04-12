package algo.sort.quick;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] notSortedInts = new int[]{23, 42, 2, 53, 11, 56, 25, 3, 101, 205, 2, 29, 88};
        QuickSort.sort(notSortedInts);

        System.out.println(Arrays.toString(notSortedInts));
    }
}
