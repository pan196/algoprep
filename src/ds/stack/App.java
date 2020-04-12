package ds.stack;

public class App {
    public static void main(String[] args) {
        System.out.println(reverseString("Hello!"));
    }

    public static String reverseString(String str) {
        Stack stringStack = new Stack(str.length());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stringStack.push(c);
        }

        while (!stringStack.isEmpty()) {
            result.append(stringStack.pop());
        }

        return result.toString();
    }
}
