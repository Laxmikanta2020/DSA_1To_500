package com.laxmi.samal.sort;

import java.util.Arrays;

public class BasicBobblesort {


    public static void main(String[] args) {
        //it basic meaning swap next element
        int[] arr = {7, 1, 9, 3, 0, 5};

        //if want to swap arr[i] to arr[i+1] element if arr[i+1] is less then the element

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.print(Arrays.toString(arr));
        Arrays.stream(arr).forEach(System.out::print);//in java 8 convert to array to stream

        //array few element are sorted but not all element are sort for all we need to run multiple time
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        System.out.println("After adding the loop it is sorted ");
        System.out.print(Arrays.toString(arr));
        // write in better ways if array is sorted no need to swap
        arr = new int[]{7, 1, 9, 3, 0, 5};
        boolean swapped;
        for (int j = 0; j < arr.length; j++) {
            swapped = true;
            for (int i = 0; i < arr.length - 1 - j; i++) { //why we put -j ,in simple Every single loop we gat one index is sort
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = false;
                }
            }
            if (!swapped)
                break;
        }
        System.out.print(Arrays.toString(arr));


    }
}
//Time Complexity: O(n²)
//Laxmikanat 03-10-2025#Bengaluro/hoodi