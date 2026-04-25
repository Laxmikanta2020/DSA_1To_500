package day60.day11;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
//        map.entrySet().stream()
//                .sorted((a, b) -> b.getValue() - a.getValue())
//                .limit(k)
//                .forEach(e -> System.out.println(e.getKey()));

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .forEach(e -> System.out.println(e.getKey()));
    }
}
//Stream().sorte
