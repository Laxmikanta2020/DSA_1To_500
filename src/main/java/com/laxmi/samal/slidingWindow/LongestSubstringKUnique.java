package com.laxmi.samal.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKUnique {
    public static void main(String[] args) {

        int result1 = longestSubstringWithKUnique("aabacbebebe", 3);
    }

    public static int longestSubstringWithKUnique(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }

        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0, right = 0;
        int maxLength = 0;
        int n = s.length();

        while (right < n) {

            char rightChar = s.charAt(right);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);

            while (charCount.size() > k) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);

                // Remove character from map if count becomes 0
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }

            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

}

