package day60.day6;

import java.util.HashMap;

public class LongestSubstringwithKDistinctCharacters {
    public static void main(String[] args) {
        //Input:  s = "eceba", k = 2
        //Output: 3
        //Explanation: "ece"
        String s = "eceba";
        int left = 0;
        int k = 2;
        int maxLength = 0;
        HashMap<Character, Integer> hmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
            while (hmap.size() > k) {
                char leftChar = s.charAt(left);
                hmap.put(leftChar, hmap.get(leftChar) - 1);
                if (hmap.get(leftChar) == 0) {
                    hmap.remove(leftChar);
                }
                left++;
            }
            maxLength = Math.max(maxLength, i - left + 1);

        }
        System.out.println(maxLength);
    }
}
