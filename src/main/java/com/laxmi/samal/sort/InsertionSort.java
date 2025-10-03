package com.laxmi.samal.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        //split the array with 0 index and other element and later increase
        //first 1 index compare with 0 index if less then swap the element
        //if j is 5 the i compare 5-1 and the i is 4 and keep decreasing until i =1
        int[] arr = {20, 3, 56, 6, 2, 12};
        for (int j = 1; j < arr.length; j++) {
            for (int i = j; i < arr.length; i--) {

                if (i > 0 && arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;

                }
            }
        }

        //using while loop


        for (int j = 1; j < arr.length; j++) {
            int x = j;
            while (x > 0 && arr[x] < arr[x - 1]) {
                int temp = arr[x];
                arr[x] = arr[x - 1];
                arr[x - 1] = temp;
                x--;

            }
        }
        System.out.print(Arrays.toString(arr));

    }
}


////Laxmikanat 03-10-2025#Bengaluru/hood
//Time Complexity: O(n²)
