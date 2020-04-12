package algo.sort.selection;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] notSortedInts = new int[]{23, 42, 53, 11, 56, 25, 3, 101, 205, 29, 88};

        System.out.println(Arrays.toString(selectionSort(notSortedInts)));
    }

    public static int[] selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int currentMin = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[currentMin]) {
                    currentMin = j;
                }
            }
            if (currentMin != i) {
                int temp = a[i];
                a[i] = a[currentMin];
                a[currentMin] = temp;
            }
        }

        return a;
    }
}
