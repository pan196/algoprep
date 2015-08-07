package com.sort.selection;

import com.sort.enums.Order;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int list[] = {59, 19, 23, 119, 11, 2, 53, 28, 33};
        System.out.println(Arrays.toString(SelectionSort(list, Order.ASC)));
    }

    private static int[] SelectionSort(int[] list, Order direction) {
        int temp;


        for (int i = 0; i < list.length; i++) {
            int extreme = list[i];
            int indexMin = i;

            for (int j = i; j < list.length - 1; j++) {
                if (direction == Order.ASC) {
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
