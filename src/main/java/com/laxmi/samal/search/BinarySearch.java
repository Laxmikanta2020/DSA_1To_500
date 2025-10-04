package com.laxmi.samal.search;

public class BinarySearch {
    public static void main(String[] args) {

        //binary search must array must br sorted then only this approach will work .
        //time complexity O(log N)
        //First find the mid using o index is low and n index is high  low+(high-low)/2
        // very simple first find the mid and check is that mid is element then if < or > of mid
        // if it is < to mid then just update the high and continue
        // if it is > to mid then just update the low and continue

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //find 5 and return index
        int traget = 5;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (mid == traget) {
                System.out.print("Value is present ");
                return;
            } else if (mid < traget) {
                low = mid + 1;

            } else if (mid > traget) {
                high = mid - 1;
            }

        }


    }
}
//Laxmikanta-04/10/2025-Bengaluru/hoodi



