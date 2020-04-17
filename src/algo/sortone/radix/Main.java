package algo.sortone.radix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] list = {1234, 234, 233, 1546, 2357, 9432, 2347, 5424, 7493};
        System.out.println(Arrays.toString(radixSort(list)));
    }

    private static int[] radixSort(int[] list) {
        int maxDigitLength = 0;
        for (int i: list) {
            int length = (int) Math.log10(i) + 1;
            if (length > maxDigitLength) {
                maxDigitLength = length;
            }
        }

        for (int i = 0; i < maxDigitLength; i++) {

            int[] tempDigitArray = new int[10];
            Arrays.fill(tempDigitArray, 0);

            for (int value : list) {
                int digit = extractDigit(value, i);
                tempDigitArray[digit]++;
            }

            for (int j = 1; j < tempDigitArray.length; j++) {
                tempDigitArray[j] = tempDigitArray[j] + tempDigitArray[j - 1];
            }

            int[] tempNumberArray = new int[list.length];
            Arrays.fill(tempNumberArray, 0);

            for (int j = list.length - 1; j >= 0; j--) {
                tempNumberArray[tempDigitArray[extractDigit(list[j], i)] - 1] = list[j];
                tempDigitArray[extractDigit(list[j], i)]--;
            }

            System.arraycopy(tempNumberArray, 0, list, 0, tempNumberArray.length);
        }

        return list;
    }

    private static int extractDigit(int number, int position) {
        int digit = (int)Math.floor(number / Math.pow(10, position));
        return digit % 10;
    }
}