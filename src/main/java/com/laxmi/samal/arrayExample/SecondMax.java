package com.laxmi.samal.arrayExample;

import java.util.Arrays;

public class SecondMax {

    public static void main(String[] args) {

        int[] arr = {1, 5, 10, 7, 40, 50,80,33,44};

        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;

        for (int a = 0; a < arr.length; a++) {
            if (arr[a] > max) {
                secondMax = max;
                max = arr[a];
            } else if (arr[a] < max && arr[a] > secondMax) {
                secondMax = arr[a];

            }
        }
        System.out.println(secondMax);

        // Reverse array using two pointer

        int x = 0, y = arr.length - 1;
        //int[] arr = {1, 5, 10, 7, 40, 50};
        //if you want to specific element to replace
        for( int z=0;z<arr.length/2;z++){

            int temp=arr[z];
            arr[x]=arr[y];
            arr[y]=temp;
            x++;
            y--;
        }
        System.out.println(Arrays.toString(arr));
//        while(x<y){
//            int temp=arr[x];
//            arr[x]=arr[y];
//            arr[y]=temp;
//            x++;
//            y--;
//        }
//        System.out.println(Arrays.toString(arr));
    }
}
