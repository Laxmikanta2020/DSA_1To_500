package com.laxmi.samal.arrayExample;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {1, 5, 10, 7, 40, 50, 80, 33, 44};

        //10 5 1 44 40 33 80 50 40 7
        int d = 3;
        d = d % arr.length;
        rotate(0, d - 1, arr);
        rotate(d, arr.length - 1, arr);
        rotate(0, arr.length - 1, arr);
        System.out.print(Arrays.toString(arr));
    }

    static void rotate(int x, int y, int[] arr) {


        while (x < y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
            x++;
            y--;
        }
    }
}
