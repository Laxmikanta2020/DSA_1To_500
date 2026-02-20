package laxmi.basic.array;

import java.util.*;
import java.util.stream.Collectors;

public class Sort0s1s2s {
    public static void main(String[] args) {

        int[] arr = {2, 0, 1, 2, 1, 0};

        //sort012(arr);
        //// Output → [0, 0, 1, 1, 2, 2]

        int x = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[x];
                arr[x] = temp;
                x++;
            }
        }
        x = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                x++;
                continue;
            }
            if (arr[i] == 1) {
                int temp = arr[i];
                arr[i] = arr[x];
                arr[x] = temp;
                x++;
            }
        }

        System.out.println(Arrays.toString(arr));

        List<String> names = Arrays.asList("java", null, "Spring","","Spring", "boot","java",null," ");

         var collect = names.stream().filter(Objects::nonNull).filter(s->!s.isBlank())
                 .map(String::toUpperCase)
                 .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(collect);
    }
}
