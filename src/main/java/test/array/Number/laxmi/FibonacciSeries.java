package test.array.Number.laxmi;

public class FibonacciSeries {
    public static void main(String[] args) {
        //1,1,2,3,5,8,13,21
        // Iterative Fibonacci
        int i = 0;
        int j = 1;
        int temp;

        for (int x = 1; x < 10; x++) {
            System.out.print(j + " ");
            temp = i + j;
            i = j;
            j = temp;
        }

        System.out.println();

        // Recursive Fibonacci
        int n = 10; // number of terms
        for (int ii = 0; ii < n; ii++) {
            System.out.print(fib(ii) + " ");
        }
    }

    // Recursive method
    static int fib(int n) {
        if (n == 0) return 0;   // base case
        if (n == 1) return 1;   // base case
        return fib(n - 1) + fib(n - 2);
    }
}
