package com.laxmi.samal.hashMap;

import java.util.*;

public class pairWithDiffrence {

    public static void main(String[] args) {

        int[] arr = {1, 4, 1, 4, 5};
        int k = 3;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;
        for (int ele : arr) {
            freqMap.put(ele, freqMap.getOrDefault(ele, 0) + 1);
        }

        for (int ele : freqMap.keySet()) {
            int complement = ele + k;
            if (freqMap.containsKey(complement)) {
                count += freqMap.get(ele) * freqMap.get(complement);
            }
            if (k == 0 && freqMap.get(ele) > 1) {
                count = freqMap.get(ele) * (freqMap.get(ele) - 1) / 2;
            }
        }

        System.out.println(count);

    }
}
