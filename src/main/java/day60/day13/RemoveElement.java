package day60.day13;

import java.util.Stack;

public class RemoveElement {

    public static void main(String[] args) {

        String s = "lee*cod*e";
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        System.out.println(stack);
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        System.out.println(result);
    }
}
