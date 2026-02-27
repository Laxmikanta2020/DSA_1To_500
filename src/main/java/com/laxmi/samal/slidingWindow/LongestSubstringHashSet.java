package com.laxmi.samal.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringHashSet {

    public static void main(String[] args) {
        String str = "pwwkew";
        //Map<Character, Integer> hmap = new HashMap<>();
        Set<Character> hmap = new HashSet<>();
        int i = 0;
        int j = 0;
        int max = 0;
        int startIndex = 0;
        int endIndex = 0;
//        while (j < str.length()) {
//            char c = str.charAt(j);
//            if (!hmap.contains(c)) {
//                hmap.add(c);
//                j++;
//                if (j - i > max) {
//                    max = j - i;
//                    startIndex = i;
//                }
//            } else {
//                hmap.remove(str.charAt(i));
//                i++;
//            }
//        }

        while (j < str.length()) {
            char c = str.charAt(j);
            while (hmap.contains(c)) {
                hmap.remove(str.charAt(i));
                i++;
            }
            hmap.add(c);

            if (j - i > max) {
                max = j - i;
                startIndex = i;
                endIndex = j;
            }
            j++;
        }
        System.out.println(max);
        System.out.print(str.substring(startIndex, startIndex + max));
        System.out.print(str.substring(startIndex, endIndex));
    }


//    public static String longestUniqueSubstringHashSet(String s) {
//        if (s == null || s.length() == 0) return "";
//
//        Set<Character> window = new HashSet<>();
//        int left = 0, maxLen = 0;
//        int start = 0, end = 0;
//
//        for (int right = 0; right < s.length(); right++) {
//            char currentChar = s.charAt(right);
//
//            while (window.contains(currentChar)) {
//                window.remove(s.charAt(left));
//                left++;
//            }
//            window.add(currentChar);
//            if (right - left + 1 > maxLen) {
//                maxLen = right - left + 1;
//                start = left;
//                end = right;
//            }
//        }
//        return s.substring(start, end + 1);
//
//    }
}
