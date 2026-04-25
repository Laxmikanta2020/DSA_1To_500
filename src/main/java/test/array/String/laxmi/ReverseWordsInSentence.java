package test.array.String.laxmi;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWordsInSentence {

    public static void main(String[] args) {

        String str = "Reverse Words In Sentence";
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(new StringBuilder(word).reverse()).append(" ");
        }
        System.out.println(sb);

        // Without revers method
        for (String word : words) {
            for (int i = word.length() - 1; i >= 0; i--) {
                sb.append(word.charAt(i));
            }
            sb.append(" ");
        }

        // In java 8
        String collect = Arrays.stream(words).map(w -> new StringBuilder(w).reverse()).collect(Collectors.joining(" "));
        System.out.println(collect);
        // we cannot convert character[] to stream directly because character is primitive type
        // String(charArray).chars().mapToObj(c -> (char) c); or new String(charArray).chars()
    }
}

//┌────────────────────┐
//  Software Developer
//         @LK
//      18-01-2026
//└────────────────────┘

