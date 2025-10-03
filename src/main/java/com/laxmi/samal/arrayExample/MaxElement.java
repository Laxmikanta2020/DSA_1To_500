package com.laxmi.samal.arrayExample;

import java.util.Arrays;

public class MaxElement {

    public static void main(String[] args) {
        int[] arr = {1, 5, 10, 7, 40};

        int max = arr[1];

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > max) max = arr[i];

        }
        System.out.println("Max element is "+max);


        //Sum of element

        int sum = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
        }
        System.out.print("Sum of element is "+sum);


        //Multiply  the  odd index with 2 and add even index with 10;

        for (int k = 0; k < arr.length; k++) {

            if (k % 2 == 0)
                arr[k] = arr[k] + 10;
            else {
                arr[k] = arr[k] * 2;
            }
        }
        System.out.println(" After change new array "+Arrays.toString(arr));

        //Element exit or not

        int valu = 10;
        int exit = -1;
        for (int e = 0; e < arr.length; e++) {
            if (arr[e] == valu) {
                exit = arr[e];
            }
        }
        if (exit > 1) {
            System.out.println("Value present in index " + exit);
        } else {
            System.out.println("Value  not present in array ");
        }
        // two sum
        int sumValue=30;
        for( int x=0;x<arr.length;x++){
            for(int y=x;y<arr.length;y++){
                if(arr[x]+arr[y]==sumValue)
                    System.out.print(" Pair exit "+arr[x]+" "+arr[y]);
            }
        }

    }
}
