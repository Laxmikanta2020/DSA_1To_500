package com.laxmi.samal.slidingWindow;

import java.util.LinkedList;
import java.util.Queue;


public class NegativeSubArray {

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 50, 60};
        int i = 0, j = 0;
        int k = 3;
        Queue<Integer> queue = new LinkedList<>();

        while (j < arr.length) {
            if (arr[j] < 0) queue.offer(j);
            if (j - i + 1 == k) {
                System.out.print(queue.isEmpty() ? "0 " : arr[queue.peek()] + " ");
                if (!queue.isEmpty() && queue.peek() == i) {
                    queue.poll();
                }
                i++;
            }
            j++;
        }
    }
}

//        while (j < arr.length) {
//            // Add index of negative numbers to queue
//            if (arr[j] < 0) {
//                queue.add(j);
//            }
//
//            // When window size is reached
//            if (j - i + 1 == k) {
//                // Check if queue has negative in current window
//                if (!queue.isEmpty() && queue.peek() >= i) {
//                    System.out.print(arr[queue.peek()] + " ");
//                } else {
//                    System.out.print("0 ");
//                }
//
//                // Remove if the negative is leaving the window
//                if (!queue.isEmpty() && queue.peek() == i) {
//                    queue.poll();
//                }
//
//                i++;
//            }
//            j++;
//        }
//    }
//}


// int [] arr= {12, -1, -7, 8, -15, 30,50,60};
//        int i=0,j=0;
//        int k = 3;
//        List<Integer> linkedList = new LinkedList<>();
//
//        while (j < arr.length) {
//            if (arr[j] < 0) {
//                linkedList.add(j);
//            }
//
//            if (j - i + 1 == k) {
//                // Get first element that's in current window
//                int firstNeg = 0;
//                for (int idx : linkedList) {
//                    if (idx >= i) {
//                        firstNeg = arr[idx];
//                        break;
//                    }
//                }
//                System.out.print(firstNeg + " ");
//
//                // Remove if leaving
//                if (!linkedList.isEmpty() && linkedList.get(0) == i) {
//                    linkedList.remove(0);
//                }
//
//                i++;
//            }
//            j++;
//        }

//Laxmikanta-05/10/2025-Bengaluru/hoodi