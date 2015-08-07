package com.sort.bubble;

import com.sort.enums.Order;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int list[] = {59, 19, 23, 119, 11, 2, 53, 28, 33};
        System.out.println(Arrays.toString(BubbleSort(list, Order.DESC)));
    }

    private static int[] BubbleSort(int[] list, Order direction) {
        int temp;

        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 1; j < list.length - i; j++) {
                if (direction == Order.ASC) {
                    if (list[j - 1] > list[j]) {
                        temp = list[j];
                        list[j] = list[j - 1];
                        list[j - 1] = temp;
                    }
                } else {
                    if (list[j - 1] < list[j]) {
                        temp = list[j];
                        list[j] = list[j - 1];
                        list[j - 1] = temp;
                    }
                }
            }
        }

        return list;
    }
}