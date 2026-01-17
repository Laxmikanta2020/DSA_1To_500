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
        numbers = new int[]{1, 2, 3, 0, 1, 0, 3, 5, 6, 0, 5};
        numbers = new int[]{0, 0, 2, 3, 0, 1, 0, 3, 5, 6, 0, 5};


        int j = 0;
        for (int i = 0; i < numbers.length; i++) {


            if (i > j && numbers[i] > 0) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                j++;
            } else if (numbers[i] > 0) {

                j++;

            }
        }

        System.out.println(Arrays.toString(numbers));
    }
}
