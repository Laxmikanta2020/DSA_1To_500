package day60.day14;

import java.util.Comparator;
import java.util.stream.IntStream;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {

        String s = "babad";

        String result =
                IntStream.range(0, s.length())
                        .boxed()
                        .flatMap(i -> IntStream.range(i + 1, s.length() + 1)
                                .mapToObj(j -> s.substring(i, j)))
                        .filter(LongestPalindromicSubstring::isPalindrome)
                        // .max((a, b) -> a.length() - b.length())
                        .max(Comparator.comparingInt(String::length))
                        .orElse("");

        System.out.println(result);
         //s = "babad";

        System.out.println(longestSubString(s));

    }

    static boolean isPalindrome(String str) {
        return str.contentEquals(new StringBuilder(str).reverse());
    }

        public static String longestSubString(String input) {
            if (input == null || input.isEmpty()) {
                return "";
            }
            int start = 0, end = 0;
            for (int i = 0; i < input.length(); i++) {
                int len1 = expandFromCenter(input, i, i);       // odd
                int len2 = expandFromCenter(input, i, i + 1);   // even
                int max = Math.max(len1, len2);
                if (max > end - start) {
                    start = i - (max - 1) / 2;
                    end = i + max / 2;
                }
            }
            return input.substring(start, end + 1);
        }

        public static int expandFromCenter(String input, int i, int j) {
            while (i >= 0 && j < input.length()
                    && input.charAt(i) == input.charAt(j)) {
                i--;
                j++;
            }
            return j - i - 1;
        }
    }
//static void expand(String s, int left, int right) {
//
//        while (left >= 0 &&
//               right < s.length() &&
//               s.charAt(left) == s.charAt(right)) {
//            if (right - left + 1 > maxLen) {
//                start = left;
//                maxLen = right - left + 1;
//            }
//            left--;
//            right++;
//        }

