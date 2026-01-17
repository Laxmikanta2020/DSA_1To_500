package laxmi.basic.array;

import java.util.Arrays;
import java.util.Comparator;

public class FindLargest {

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 50, 50, 60, 70, 80};
        // Find Second Largest

        var secondLargest = Arrays.stream(numbers).boxed().distinct().sorted(Comparator.reverseOrder())
                .skip(1).findFirst().orElse(null);
        System.out.println(secondLargest);

        //Find K largest number
        var kLargest = Arrays.stream(numbers).boxed().distinct().sorted(Comparator.reverseOrder())
                .skip(4).findFirst().orElse(null);
        System.out.println(kLargest);

        // Find missing number
        int[] missing = {1, 2, 4, 5};
        int n = missing.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int sum = Arrays.stream(missing).boxed().mapToInt(Integer::intValue).sum();
        var missingNumber = expectedSum - sum;
        System.out.println(missingNumber);
    }
}
