package test.array.String.laxmi;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {


    public static void main(String[] args) {

        String word = "bbbbb";
        int j = 0;
        int max = 0;
        Set<Character> subString = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {

            while (subString.contains(word.charAt(i))) {
                subString.remove(word.charAt(j));
                j++;
            }
            max = Math.max(max, i - j + 1);
            subString.add(word.charAt(i));
        }
        System.out.println(max);


    }
}
