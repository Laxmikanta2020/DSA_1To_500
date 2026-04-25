package test.array.Number.laxmi;

public class PrimeNumberCheck {
    public static void main(String[] args) {

        int number = 7;
        if (number <= 1) {
            System.out.println("It is not a prime No");
            return;
        }
        boolean isPrime = true;
        for (int x = 2; x < number / 2; x++) {
            if (number % x == 0) {
                isPrime = false;
                break;
            }
        }

        System.out.println(isPrime ? "it prime No" : "not prime No ");
        //  print 1 to 100 all prime no


        for (int i = 3; i < 100; i++) {
            isPrime = true;
            for (int x = 2; x * x <= i; x++) {
                if (i % x == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println("Prime No " + i);
            }
        }

    }
}
