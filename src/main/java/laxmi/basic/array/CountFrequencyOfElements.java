package laxmi.basic.array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountFrequencyOfElements {

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 50, 50, 60, 70, 80};
        HashMap<Integer, Integer> hmap = new HashMap<>();
        // Using foreach loop

        for (Integer number : numbers) {
            hmap.put(number, hmap.getOrDefault(number, 0) + 1);
        }
        System.out.println(hmap);

        Map<Integer, Long> collect = Arrays.stream(numbers).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

        //Max occurrence
        // return values
        Long max = Arrays.stream(numbers).boxed().collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting())).values().stream().max(Comparator.naturalOrder()).orElse(null);
        //.max(Long::compareTo).orElse(0L);
        //.stream().mapToLong(Long::longValue).max().orElse(0);


        System.out.println(max);
        // Return keys
        Integer i = Arrays.stream(numbers).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
                entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(0);

        System.out.println(i);

        //First Non-repeating  element
        Map<Integer, Integer> freq = new LinkedHashMap<>();

        for (int num : numbers) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                break;
            }
        }

        // jaVa 8 ways

       var integerLongEntry = Arrays.stream(numbers).boxed().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
        System.out.println(integerLongEntry);


        //If it is String

        String name="HiBoddy";

        name.chars().mapToObj(c->(char)c) .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,   // preserves order
                        Collectors.counting()
                )).entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
    }
}
