package algo.sortone.insertion;

import algo.helper.enums.SortOrder;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] list = {59, 19, 23, 119, 11, 2, 53, 28, 33};
        System.out.println(Arrays.toString(list));
        System.out.println(Arrays.toString(InsertionSort(list, SortOrder.ASC)));
    }

    private static int[] InsertionSort(int[] list, SortOrder direction) {
        int temp;

        for (int i = 1; i < list.length; i++) {

            for (int j = i; j > 0; j--) {
                if (direction == SortOrder.ASC) {
                    if (list[j] < list[j - 1]) {
                        temp = list[j];
                        list[j] = list[j - 1];
                        list[j - 1] = temp;
                    }
                } else {
                    if (list[j] > list[j - 1]) {
                        temp = list[j];
                        list[j] = list[j - 1];
                        list[j - 1] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(list));
        }

        return list;
    }
}