package test.array.Number.laxmi;

public class SumOfDigits {
    public static void main(String[] args) {
        int number = 1245;
        int value = number;
        int sum = 0;
        while (value > 0) {
            sum = sum + value % 10;
            value = value / 10;
        }
        System.out.println(sum);
    }
}
