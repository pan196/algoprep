package algo.search.linear;

public class App {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(linearSearch(ints, 4));
        System.out.println(linearSearch(ints, 8));
        System.out.println(linearSearch(ints, 1));
    }

    public static int linearSearch(int[] a, int k) {
        int result = -1;

        for (int i = 0; i < a.length; i++) {
            int current = a[i];
            if (current == k) {
                result = i;
                break;
            }
        }
        return result;
    }
}
