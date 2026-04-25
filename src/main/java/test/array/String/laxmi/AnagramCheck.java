package test.array.String.laxmi;

import java.util.Arrays;

public class AnagramCheck {

    public static void main(String[] args) {

        String s1 = "silent";
        String s2 = "listen";
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            System.out.println("Not Anagrams");
            return;
        }

        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        boolean isAnagram = Arrays.equals(a1, a2);
        System.out.println(isAnagram ? "Anagrams" : "Not Anagrams");

    }
}
