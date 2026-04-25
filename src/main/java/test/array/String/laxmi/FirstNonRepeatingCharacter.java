package test.array.String.laxmi;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String word = "character";

        /* Time Complexity: O(n²)
         *chars() gives IntStream of character codes
         * (indexOf and lastIndexOf each scan the string)
         */
        char result = word.chars()
                .filter(c -> word.indexOf(c) == word.lastIndexOf(c))
                .mapToObj(c -> (char) c)
                .findFirst()
                .orElse('\0');

        System.out.println(result);
        /* Time Complexity: O(n)
         * Space Complexity: O(n)
         */
        LinkedHashMap<Character, Long> frequencyMap =
                word.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()));

        Character firstUnique = frequencyMap.entrySet().stream().filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().orElse(null);

        System.out.println(firstUnique);
        char[] charArray = word.toCharArray();
        LinkedHashMap<Character, Integer> charCountMap = new LinkedHashMap<>();
        for (char ch : charArray) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                break;
            }
        }


    }
}
