package day60.day7;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String input = "{[]}";

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {

            if (c == '{' || c == '[' || c == '(') {

                stack.push(c);

            } else {

                if (stack.isEmpty()) {
                    System.out.println("Not Valid");
                    return;
                }

                char top = stack.pop();

                if ((c == '}' && top != '{') ||
                        (c == ']' && top != '[') ||
                        (c == ')' && top != '(')) {

                    System.out.println("Not Valid");
                    return;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Valid");
        } else {
            System.out.println("Not Valid");
        }
    }
}
