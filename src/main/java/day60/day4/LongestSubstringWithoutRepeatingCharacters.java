package day60.day4;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        String input = "abcabcbb";
        int left = 0;

        Set<Character> set = new HashSet<>();
        char[] charArray = input.toCharArray();
        int max = 0;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            while (set.contains(c)) {
                set.remove(charArray[left]);
                left++;
            }
            set.add(c);
            max = Math.max(max, i - left+1);
        }
        System.out.println(max);

    }
}
