package algo.sortone.counting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] list = {13, 6, 12, 1, 14, 7, 2, 9, 15};
        System.out.println(Arrays.toString(countingSort(list)));
    }

    public static int[] countingSort(int[] list) {
        int max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        int[] array = new int[max + 1];
        Arrays.fill(array, 0);
        int[] result = new int[list.length];
        Arrays.fill(array, 0);

        for (int i : list) {
            array[i]++;
        }

        for (int i = 1; i < array.length; i++) {
            array[i] = array[i] + array[i - 1];
        }

        for (int i = list.length - 1; i >= 0; i--) {
            result[array[list[i]] - 1] = list[i];
        }

        return result;
    }
}