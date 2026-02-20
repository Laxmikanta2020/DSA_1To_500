package com.laxmi.samal.hashMap;

import java.util.HashMap;
import java.util.Map;

public class MaxFrequency {
    public static void main(String[] args) {

        String str = "aabbcc";
        // Count frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        // Find max frequency and lexicographically smallest character
        char result = '\0';
        int maxFreq = 0;

        for (char c : freqMap.keySet()) {
            int freq = freqMap.get(c);

            if ((maxFreq < freq) || (maxFreq == freq && c < result)) {
                result = c;
                maxFreq = freq;
            }

        }
        System.out.println(result);
    }
}
