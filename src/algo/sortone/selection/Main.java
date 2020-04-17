package algo.sortone.selection;

import algo.helper.enums.SortOrder;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] list = {59, 19, 23, 119, 11, 2, 53, 28, 33};
        System.out.println(Arrays.toString(SelectionSort(list, SortOrder.ASC)));
    }

    private static int[] SelectionSort(int[] list, SortOrder direction) {
        int temp;


        for (int i = 0; i < list.length; i++) {
            int extreme = list[i];
            int indexMin = i;

            for (int j = i; j < list.length - 1; j++) {
                if (direction == SortOrder.ASC) {
                    if (list[j + 1] < extreme) {
                        extreme = list[j + 1];
                        indexMin = j + 1;
                    }
                } else {
                    if (list[j + 1] > extreme) {
                        extreme = list[j + 1];
                        indexMin = j + 1;
                    }
                }
            }
            temp = list[i];
            list[i] = list[indexMin];
            list[indexMin] = temp;
        }

        return list;
    }
}
