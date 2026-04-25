package test.array.Number.laxmi;

public class PalindromeNumber {

    public static void main(String[] args) {
        int number = 121;
        int value = number;
        int reverse = 0;
        int digit = 0;
        while (value > 0) {
            digit = value % 10;
            reverse = reverse * 10 + digit;
            value = value / 10;
        }
        if (number == reverse) {
            System.out.println("Palindrome Number");
        } else {
            System.out.println("Not a Palindrome Number");
        }
        boolean isPalindrome = String.valueOf(number)
                .equals(new StringBuilder(String.valueOf(number)).reverse().toString());
        boolean isPalindrome1 = String.valueOf(number)
                .contentEquals(new StringBuilder(String.valueOf(number)).reverse());
    }
}
