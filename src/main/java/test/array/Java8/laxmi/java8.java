//package test.array.Java8.laxmi;
//
//import com.byterasulla.Java8.Employee;
//
//import java.util.*;
//import java.util.function.Function;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
//public class java8  implements Runnable{
//    public static void main(String[] args) {
//        List<Integer> marks = Arrays.asList(60, 70, 80, 90, 100);
//        Map<Integer, Double> collect = marks.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.averagingInt(Integer::intValue)));
//        System.out.println(collect);
//        List<Employee> employees = Employee.getSampleEmployees();
//        //87. Find duplicates using streams
//        List<Integer> list = Arrays.asList(5, 3, 2, 5, 1, 2, 8, 8);
//
////88. Count occurrences using streams
//        String str = "character";
//
////89. First non-repeating using streams
//        String str2 = "swiss";
//
////90. Second highest using streams
//        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
//
////91. Kth highest using streams
//        List<Integer> numbers2 = Arrays.asList(7, 4, 9, 1, 6, 3);
//        int k = 3;
//
////92. Sort list using streams
//        List<Integer> unsortedList = Arrays.asList(9, 2, 5, 1, 8);
//        Collections.sort(unsortedList);
//        unsortedList.sort(Comparator.reverseOrder());
//        List<Integer> list1 = unsortedList.stream().sorted(Comparator.nullsLast(Comparator.reverseOrder())).toList();
////93. Sort map using streams
//        Map<Integer, String> map = Map.of(
//                3, "Banana",
//                1, "Apple",
//                2, "Orange"
//        );
//        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(x,y)->x,LinkedHashMap::new));
////94. Filter null & empty values
//        List<String> names = Arrays.asList("Java", "", null, "Spring", "Boot");
//
////95. Group by property
//        List<String> items = Arrays.asList("Java", "Spring", "SQL", "Go", "Rust");
//
////96. Grouping with counting
//        List<String> letters = Arrays.asList("A", "B", "A", "C", "B", "A");
//        letters.stream()
//                .collect(Collectors.groupingBy(
//                        Function.identity(),
//                        Collectors.counting()
//                ));
////97. Grouping with summing
//        List<Integer> salaries = Arrays.asList(50000, 60000, 70000, 50000, 60000);
//        salaries.stream()
//                .collect(Collectors.groupingBy(Function.identity(),
//                        Collectors.summingInt(Integer::intValue)
//                ));
////98. Grouping with averaging
////        List<Integer> marks = Arrays.asList(60, 70, 80, 90, 100);
////        Map<Integer, Double> collect = marks.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.averagingInt(Integer::intValue)));
////        System.out.println(collect);
////99. Max element per group
//        List<Integer> nums = Arrays.asList(10, 15, 20, 25, 30);
//
////100. Min element per group
//        List<Integer> nums2 = Arrays.asList(8, 3, 12, 5, 1);
//        Integer i = nums2.stream().max(Comparator.naturalOrder()).orElse(null);
//        nums2.stream()
//                .mapToInt(Integer::intValue)
//                .min()
//                .orElse(Integer.MAX_VALUE);
//        Optional<Integer> max = nums2.stream().max(Integer::compareTo);
//        Optional<Integer> max1 = nums2.stream().max(Comparator.naturalOrder());
//        Optional<Integer> max2 = nums2.stream().max((a, b) -> a.compareTo(b));
//
////101. Partition even & odd
//        List<Integer> partitionList = Arrays.asList(1, 2, 3, 4, 5, 6);
//
////102. flatMap nested lists
//        List<List<Integer>> nestedLists = Arrays.asList(
//                Arrays.asList(1, 2),
//                Arrays.asList(3, 4),
//                Arrays.asList(5, 6)
//        );
//        Runnable r =new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hi this time ");
//            }
//        };
//        r.run();
//        java8 j=new java8();
//        j.run();
//        Runnable ru=()->{
//            System.out.println("Hi laxmi this is your torn ");
//        };
//        ru.run();
//
//
////103. Collectors.toMap conflict handling
//        List<String> duplicateKeys = Arrays.asList("A", "B", "A", "C");
//
////104. Function.identity() real usage
//        List<String> identityList = Arrays.asList("Java", "Spring", "Java", "SQL");
//
////105. Stream pipeline optimization
//        List<Integer> pipelineList = Arrays.asList(10, 15, 20, 25, 30);
//
////106. Parallel stream example
//        List<Integer> parallelList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//
////107. Custom comparator in streams
//        List<String> customSortList = Arrays.asList("apple", "Banana", "cherry", "Date");
//
//    }
//
//    @Override
//    public void run() {
//        System.out.println("Welcome to run method");
//    }
//}
