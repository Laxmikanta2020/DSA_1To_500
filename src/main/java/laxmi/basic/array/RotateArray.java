package laxmi.basic.array;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 50, 50, 60, 70, 80};
        int k = 3;
        //  k = k % numbers.length; // if k is more than arr.length
        rotateLeft(numbers, k);
        System.out.println(Arrays.toString(numbers));

    }

    // Rotate array to the left by k positions
    private static void rotateLeft(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // handle k > n

        reverse(arr, 0, k - 1);     // Step 1
        reverse(arr, k, n - 1);     // Step 2
        reverse(arr, 0, n - 1);     // Step 3
    }

    // Reverse array between start and end
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}

