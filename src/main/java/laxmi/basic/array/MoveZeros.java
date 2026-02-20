package laxmi.basic.array;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {

        int[] numbers = {1, 0, 2, 3, 0, 1, 0, 3, 5, 6, 0, 5};

        int x = 0;
        int y = numbers.length - 1;
        while (x < y) {
            if (numbers[x] == 0 && numbers[y] != 0) {
                int temp = numbers[x];
                numbers[x] = numbers[y];
                numbers[y] = temp;
                x++;
                y--;
            } else if (numbers[x] != 0) {
                x++;
            } else {
                y--;
            }

        }
        System.out.println(Arrays.toString(numbers));
        numbers = new int[]{1, 0, 2, 3, 0, 1, 0, 3, 5, 6, 0, 5};

        int j = 0;
        for (int i = 0; i < numbers.length; i++) {

            if (i > j && numbers[i] != 0) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                j++;
            } else if (numbers[i] != 0) {
                j++;

            }
        }

        System.out.println(Arrays.toString(numbers));
        numbers = new int[]{1, 0, 2, 3, 0, 1, 0, 3, 5, 6, 0, 5};
        j = 0; // index for next non-zero

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] != 0) {

                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;

                j++;
            }
        }
        System.out.println(Arrays.toString(numbers));

        // Move negatives to one side
        numbers = new int[]{1, -20, 2, 3, -10, 1, -9, 3, 5, 6, -11, 5};
        int a = 0;

        for (int c = 0; c < numbers.length; c++) {

            if (numbers[c] < 0) {
                int temp = numbers[c];
                numbers[c] = numbers[a];
                numbers[a] = temp;
                a++;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}
