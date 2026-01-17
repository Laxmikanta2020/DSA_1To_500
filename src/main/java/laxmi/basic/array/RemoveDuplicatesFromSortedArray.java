package laxmi.basic.array;

import java.util.*;
import java.util.stream.Collectors;

class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] sortedArray = {10, 20, 30, 40, 50, 50, 50, 60, 70, 80};
        int j = 0;

        for (int i = 1; i < sortedArray.length; i++) {

            if (sortedArray[j] != sortedArray[i]) {
                j++;
                sortedArray[j] = sortedArray[i];
            }
        }
        System.out.println(Arrays.toString(sortedArray));

        //If Array is unsorted then used set
        var uniqueSet = Arrays.stream(sortedArray).boxed().collect(Collectors.toSet());
        var uniqueSetWithOrder = Arrays.stream(sortedArray).boxed().collect(Collectors.toCollection(LinkedHashSet::new));

        // Print duplicates only
        HashSet<Integer> hset = new HashSet<Integer>();
        Arrays.stream(sortedArray).boxed().filter(x -> !hset.add(x)).forEach(System.out::println);

        //Print first duplicate

        Integer firstDuplicate = Arrays.stream(sortedArray).boxed().filter(x -> !hset.add(x)).findFirst().orElse(null);
        System.out.println(firstDuplicate);


    }

}
