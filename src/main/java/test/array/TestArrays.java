package test.array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestArrays {
    public static void main(String[] args) {
        //
        //🤷‍♂️ Array – BASIC to ADVANCED 😊
        //
        //1. Remove duplicates from sorted array (in-place)
        //
        int[] arr = {1, 2, 3, 3, 5, 5, 5, 6, 7, 8,};

        ArrayList<int[]> ints = new ArrayList<>(Arrays.asList(arr));
        Set<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        var collect1 = Arrays.stream(arr).distinct().toArray();
        System.out.print(collect);

        int x = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[x] != arr[i]) {
                x++;
                arr[x] = arr[i];
            }
        }
        for (int y = 0; y < x; y++) {
            System.out.print(arr[y]);
        }
        //2. Remove duplicates from unsorted array
        //
        //
        //3. Print only unique elements
        //
        HashSet<Integer> set = new HashSet<>();
        System.out.print(Arrays.toString(arr));
        int[] array = Arrays.stream(arr).filter(xx -> !set.add(xx)).toArray();
        List<Integer> list = Arrays.stream(arr).filter(xx -> !set.add(xx)).boxed().toList();
        System.out.print(Arrays.toString(array));
        Arrays.stream(arr).filter(xx -> !set.add(xx)).forEach(System.out::println);
        //4. Print duplicates only
        //
        //
        //5. Count frequency of elements
        int[] arr1 = new int[26];
        String name = "laxmikanta";

        char[] charArray = name.toCharArray();
        for (int c = 0; c < charArray.length; c++) {
            int i = charArray[c] - 'a';
            arr1[i]++;
        }
        for (int ddd = 0; ddd < arr1.length; ddd++) {
            if (arr1[ddd] > 0)
                System.out.println((char) (97 + ddd) + " " + arr1[ddd]);
        }
        Map<Character, Long> collect2 = name.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //7. Find first non-repeating element


        Map.Entry<Character, Long> characterLongEntry = name.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(xx -> xx.getValue() == 1).findFirst().orElse(null);
        System.out.print(" Non repeating element is " + characterLongEntry);

        //8. Find second largest
        //
        //
        //9. Find kth largest
        Set<Integer> collect3 = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(5).limit(1).collect(Collectors.toSet());

        //10. Find missing number (1…n)
        //
        int n = arr.length;
        int i1 = n * (n + 1) / 2;
        int sum = Arrays.stream(arr).boxed().mapToInt(xxy -> xxy).sum();
        Integer reduce = Arrays.stream(arr).boxed().reduce(0, (xs, y) -> xs + y);
        System.out.print(sum - i1 + " " + reduce);

        Set<Integer> set1 = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toSet());

        IntStream.rangeClosed(1, n)
                .filter(i -> !set1.contains(i))
                .findFirst()
                .orElse(-1);

        //  Map<Integer, Integer> collect4 = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(Integer::intValue)));

        //11. Find all missing numbers
        //
        //
        //12. Find repeating & missing number together
        //
        //
        //13. Rotate array left by k
        //public static void rotateLeft(List<Integer> list, int k) {
        List<Integer> integerList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(integerList);
        int nn = integerList.size();
        int k = 3 % n;
        Collections.rotate(integerList, -k);// Negative for left rotation

        System.out.println();
        System.out.println(integerList);
        Collections.rotate(integerList, k);// for Right  rotation
        System.out.println(integerList);


        //
        //14. Rotate array right by k
        //
        //
        //15. Reverse array in-place
        // used swape of Collections.reverse();
        //
        //==================================================❤️❤️❤️❤️❤️❤️===========================================
//        // 16. Move zeros to end
//        int[] arr16 = {0, 1, 0, 3, 12, 0, 5};
//
//        int left = 0;
//
//
//        for (int right = 0; right < arr16.length; right++) {
//            if (arr16[right] != 0) {
//                int temp = arr16[left];
//                arr16[left] = arr16[right];
//                arr16[right] = temp;
//                left++;
//            }
//        }
//        System.out.println("  Zero " + Arrays.toString(arr16));
//        left = 0;
//        int right = arr16.length - 1;
//        while (left < right) {
//
//            if (arr16[left] == 0 && arr16[right] != 0) {
//                int temp = arr16[left];
//                arr16[left] = arr16[right];
//                arr16[right] = temp;
//                left++;
//                right--;
//            } else if (arr16[left] != 0 && arr16[right] == 0) {
//                left++;
//                right--;
//            } else if (arr16[left] == 0) {
//                right--;
//            } else {
//                left++;
//            }
//        }
//
//        System.out.println("  Zero " + Arrays.toString(arr16));
//// 17. Move negatives to one side
//        int[] arr17 = {-12, 11, -13, -5, 6, -7, 5, -3, 11};
//
//// 18. Sort 0s, 1s, 2s (Dutch flag)
//        int[] arr18 = {2, 0, 1, 2, 1, 0, 1, 2, 0};
//
//// 19. Find majority element
//        int[] arr19 = {3, 3, 4, 2, 4, 4, 2, 4, 4};
//
//        Arrays.stream(arr19).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
//
//        Arrays.stream(arr19)
//                .boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet()
//                .stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse(null);
//
//        Integer result = Arrays.stream(arr19)
//                .boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet()
//                .stream()
//                .max(Comparator.comparing(Map.Entry::getValue))
//                .map(Map.Entry::getKey)
//                .orElse(null);
//// 20. Find subarray with given sum
//        int[] arr20 = {1, 4, 20, 3, 10, 5};
//        int targetSum = 33;
//
//        int begin = 0;
//        int currentSum = 0;
//
//        for (int end = 0; end < arr.length; end++) {
//            currentSum += arr[end];
//
//            // Shrink window from left if sum exceeds target
//            while (currentSum > targetSum && begin <= end) {
//                currentSum -= arr[begin];
//                begin++;
//            }
//// need to
//            if (currentSum == targetSum) {
//                System.out.println("Subarray found from index " + begin + " to " + end);
//                System.out.print("Elements: ");
//                for (int i = begin; i <= end; i++) {
//                    System.out.print(arr[i] + " ");
//                }
//
//                // Approach 2 best for all Negative number also
//                Map<Integer, Integer> map = new HashMap<>();
//                int prefixSum = 0;
//
//                // Base case if some are start  from zero
//                map.put(0, -1);
//
//                for (int i = 0; i < arr.length; i++) {
//
//                    prefixSum += arr[i];
//
//                    if (map.containsKey(prefixSum - targetSum)) {
//                        int start = map.get(prefixSum - targetSum) + 1;
//                        System.out.println("Subarray found from index " + start + " to " + i);
//                        break;
//                    }
//
//                    map.putIfAbsent(prefixSum, i);
//                }
//
//// 21. Maximum subarray sum (Kadane)
//                int[] arr21 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//
//// 22. Longest consecutive sequence
//                int[] arr22 = {100, 4, 200, 1, 3, 2};
//
//// 23. Intersection of two arrays
//                int[] arr23a = {1, 2, 2, 1};
//                int[] arr23b = {2, 2};
//
//// 24. Union of two arrays
//                int[] arr24a = {1, 2, 3, 4, 5};
//                int[] arr24b = {1, 2, 3, 6, 7};
//
//// 25. Merge two sorted arrays
//                int[] arr25a = {1, 3, 5, 7};
//                int[] arr25b = {2, 4, 6, 8};
//
//// 26. Check if array is sorted
//                int[] arr26 = {1, 2, 3, 4, 5};
//
//// 27. Rearrange array alternately
//                int[] arr27 = {1, 2, 3, 4, 5, 6};

// 28. Product of array except self
        int[] arr28 = {1, 2, 3, 4};

// 29. Trapping rain water
        int[] arr29 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

// 30. Stock buy & sell (max profit)
        int[] arr30 = {7, 1, 5, 3, 6, 4, 9, 8};
        // 1 time //multiple time

        int max = 0;
        int min = arr30[0];

        for (int a = 1; a < arr30.length - 1; a++) {
            max = Math.max(max, arr30[a] - min);
            min = Math.min(min, arr30[a]);


        }
        System.out.println("max+"+max);
    }


//            }
//
//        }
}

