package test.array.String.laxmi;

public class CharacterOccurrence {
    public static void main(String[] args) {
        String input = "Hello World";
        int[] freq = new int[26];

        input = input.toLowerCase(); // normalize

        for (char c : input.toCharArray()) {
            // consider only alphabets
            if (c >= 'a' && c <= 'z') {
                freq[c - 'a']++;
            }
        }

        // print occurrences
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.println((char) (i + 'a') + " -> " + freq[i]);
            }
        }
        //if
    }
}
