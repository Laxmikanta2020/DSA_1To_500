package com.laxmi.samal.arrayExample;

import java.util.Arrays;

public class MoveALLZeroToLast {

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            if (arr[i] == 0 && arr[j] != 0) {
                arr[i] = arr[j];
                arr[j] = 0;
                i++;
                j--;
            } else if (arr[j] == 0) {
                j--;

            } else {
                i++;
            }
        }

        System.out.print(Arrays.toString(arr));

        int[] arr1 = {0,0,1, 2, 0, 4, 3, 0, 5, 0};
        int x = 0;

        for (int y = 0; y < arr1.length; y++) {

            if (arr1[y] != 0) {
                if (x < y) {
                    int temp = arr1[x];
                    arr1[x] = arr1[y];
                    arr1[y] = temp;

                }
                x++;

            }

        }
        System.out.print(Arrays.toString(arr1));

    }

}
