package day60.day11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestArray {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                System.out.println(minHeap);
                minHeap.poll();
                System.out.println(minHeap);// evict the smallest
            }
        }
        System.out.println(minHeap);
        return minHeap.peek();  // root = kth largest
    }
//
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2)); // 5
        Integer i = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).skip(2-1).findFirst().orElse(null);
        System.out.println(i);
    }
}
