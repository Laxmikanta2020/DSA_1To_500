package day60.day3;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        String word = "silent";
        String input = "listen";
        if (word.length() != input.length()) {
            System.out.println("It is not an anagram");
            return;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }
        System.out.println(map);
        if(!map.isEmpty()){
            System.out.println("It is not a anagram");
        }else {
            System.out.println("It is a anagram");
        }
    }
}
