package com.laxmi.samal.bobblesort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        //IN simple section sort : in a array find the min element with swap the element (for swap we need to index)and put
        // in first index and next time find the min element but skip the previous index
        //arr={7,9,4,8,2,50} find the min that is 2 and we put in first index like {2,9,4,8,7,50}
        //next time we slip the 2 and fine the min {9,4,8,7,50} because 2 is already right index we need not to compare again

        /**
         * In selection sort: Find the smallest element in the array and swap it to the first position.
         * Then find the smallest element in the remaining unsorted part and swap it to the second position.
         * Repeat this process, each time ignoring the already sorted elements at the beginning."
         * In simple selection sort: In an array {7,9,4,8,2,50} find the minimum element (which is 2) and put it in the first index to get {2,9,4,8,7,50}.
         * Next time, skip the first index (since 2 is already sorted) and find the minimum from the remaining elements {9,4,8,7,50} (which is 4) and put it in the second position.
         */


        int[] arr = {7, 9, 4, 8, 2,4, 50};

        for(int i=0;i<arr.length;i++) {
            int minIndex = i;//we need to find min and put in 0 to n index
            int min = Integer.MAX_VALUE;//arr[i]
            for (int j = i; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i]; // just swap min value to 0 index and keep increase
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        System.out.print(Arrays.toString(arr));


        //Optimized but not necessary still time complexity   O(n²)
//
//        for(int i=0;i<arr.length;i++) {
//            int minIndex = i;//we need to find min and put in 0 to n index
//            for (int j = i; j < arr.length; j++) {
//                if (arr[minIndex] > arr[j]) {
//                    minIndex = j;
//                }
//            }
//            int temp = arr[i]; // just swap min value to 0 index and keep increase
//            arr[i] = arr[minIndex];
//            arr[minIndex] = temp;
//        }
//
//        System.out.print(Arrays.toString(arr));
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            int minIndex = i;  // Track INDEX only, not value
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[minIndex]) {
//                    minIndex = j;  // Just update index - no swapping yet
//                }
//            }
//            // Single swap after finding the minimum
//            if (minIndex != i) {
//                int temp = arr[i];
//                arr[i] = arr[minIndex];
//                arr[minIndex] = temp;
//            }
//        }
    }


}
//Laxmikanat 03-10-2025#Bengaluru/hood