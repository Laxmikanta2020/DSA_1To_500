package com.laxmi.samal.slidingWindow;

import java.util.Arrays;

public class Count_Occurrences_Of_Anagrams {

    public static int countAnagrams(String str, String pat) {
        if (str.length() < pat.length()) return 0;

        int[] patCount = new int[26];
        int[] windowCount = new int[26];
        int count = 0;
        int k = pat.length();

        // Count characters in pattern
        for (char c : pat.toCharArray()) {
            patCount[c - 'a']++;
        }

        int left = 0, right = 0;

        while (right < str.length()) {
            // Add current character to window
            char rightChar = str.charAt(right);
            windowCount[rightChar - 'a']++;

            // When window size becomes equal to pattern length
            if (right - left + 1 == k) {
                // Check if current window is an anagram
                if (Arrays.equals(patCount, windowCount)) {
                    count++;
                }

                // Remove leftmost character from window
                char leftChar = str.charAt(left);
                windowCount[leftChar - 'a']--;
                left++; // Slide window forward
            }

            right++; // Expand window
        }

        return count;
    }
    public static void main(String[] args) {

        System.out.println(countAnagrams("cbaebabacd", "abc"));
    }
}


//Laxmikanta-05/10/2025-Bengaluru/hoodi