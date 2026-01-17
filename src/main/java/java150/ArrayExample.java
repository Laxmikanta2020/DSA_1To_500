package java150;

import java.util.HashSet;
import java.util.Set;

public class ArrayExample {

//Input: nums = [2,20,4,10,3,4,5]
//Output: 4

    public static void main(String[] args) {
        int[] nums = {2, 20, 4, 10, 3, 4, 5};


        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int max = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }
                max = Math.max(max, count);
            }
//        Arrays.sort(nums);
//        int max=0;
//        int count=0;
//        for(int i=0;i<nums.length-1;i++){
//
//            if(nums[i]==nums[i+1])continue;
//            if(nums[i]+1==nums[i+1]){
//                count++;
//            }else {
//                max=Math.max(max,count);
//                count=1;
//            }
//        }
//        max = Math.max(max, count) + 1;
//        System.out.println(max);
        }
    }
}
