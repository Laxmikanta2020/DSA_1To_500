package com.laxmi.samal.hashMap;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        //Input: nums = [2, 7, 11, 15], target = 9
        //Output: [0, 1]

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (hashMap.containsKey(left)) {
                System.out.println(hashMap.get(left) + " " + i);
            }
            hashMap.put(nums[i], i);
        }


    }
}
