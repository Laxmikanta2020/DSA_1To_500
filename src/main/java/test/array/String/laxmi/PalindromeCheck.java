package test.array.String.laxmi;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PalindromeCheck {

    public static void main(String[] args) {

        String name = "madam";

        int x = 0;
        int y = name.length() - 1;

        boolean b = true;

        while (x < y) {

            if (name.charAt(x) != name.charAt(y)) {
                b = false;
            }
            x++;
            y--;
        }

        if (b) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        // java 8
        IntStream range = IntStream.range(0, name.length() / 2);
        System.out.println(range);
        range.forEach(System.out::println);
        boolean isPalindrome = IntStream.range(0, name.length() / 2)
                .allMatch(i -> name.charAt(i) == name.charAt(name.length() - i - 1));
        System.out.println(isPalindrome ? "Palindrome" : "Not Palindrome");

    }

}
