package day60.day12;

import java.util.PriorityQueue;

public class TopKElements {
    public static void main(String[] args) {

        int[] arr = {45, 12, 56, 15, 24, 75, 31, 89};
        int k = 3;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num:arr){
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest
            }
        }
        System.out.println(minHeap);

    }
}
