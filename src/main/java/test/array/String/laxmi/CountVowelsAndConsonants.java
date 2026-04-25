package test.array.String.laxmi;

public class CountVowelsAndConsonants {

    public static void main(String[] args) {
        String input = "Hello World";

        int vowels = 0;
        int consonants = 0;

        input = input.toLowerCase();

        for (Character c : input.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                // if ("aeiou".indexOf(c) != -1) {
                if (c == 'a' || c == 'e' || c == 'i'
                        || c == 'o' || c == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        // in Java 8
        long count = input.toLowerCase().chars().filter(ch -> "aeiou".indexOf(ch) != -1)
                .count();
        long consonant= input.toLowerCase()
                .chars()
                .filter(ch -> ch >= 'a' && ch <= 'z')
                .filter(ch -> "aeiou".indexOf(ch) == -1)
                .count();
    }
}
