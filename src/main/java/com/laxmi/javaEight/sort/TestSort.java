package com.laxmi.javaEight.sort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestSort {
    public static void main(String[] args) {

        List<Employee> employees = Employee.getSampleEmployees();
        int[] numbers = {2, 3, 1, 4, 33, 5, 22, 8, 19};
        String[] nameArray = {"java", "Sql", "Springboot", "Microservice", "Amazon webapplication"};

        //Convert to Arrays to list and stream.
        // ❌ IMMUTABLE - Cannot be modified
        //Cannot use: add(), remove(), set(), sort(), reverse()\n"
        List<Integer> immutableList1 = Arrays.stream(numbers).boxed().toList(); // Java 16+
        List<Integer> immutableList2 = List.of(1, 4, 7);
        List<String> immutableList3 = List.of(nameArray);
        //if we used list.of then we can not modify the list and null not allowed in run time get null pointer exception

        List<Integer> mutableList1 = new ArrayList<>(Arrays.stream(numbers).boxed().toList());
        List<Integer> numbersList1 = Arrays.stream(numbers).boxed().collect(Collectors.toList());//Collectors.toList() is mutable but .toList()  this immutable
        List<String> strings = new ArrayList<>(Arrays.asList(nameArray));
        List<String> mutableList4 = Arrays.asList(nameArray); // Fixed-size, can modify but not add/remove
        // mutableList4.add("Lax"); give error
        // List<String> list1 = Arrays.stream(strArray).boxed().toList(); for string boxed not required
        List<String> nlist1 = Arrays.stream(nameArray).toList(); //for string boxed not required
       // nlist1.add("asd");
        numbersList1.add(12);


        List<String> collect4=  new ArrayList<>(Arrays.asList(nameArray));//- wraps the array in an ArrayList
        List<String> collect3 = Arrays.stream(nameArray).collect(Collectors.toList());
        // we will perfume sort ,max,min,sum,average,count ,
        //summingInt(), averagingInt(), maxBy(), minBy(), mapping()

        //SORT by Collections
        Collections.reverse(numbersList1);
        System.out.println(numbersList1);
        Collections.sort(numbersList1);
        Collections.sort(numbersList1, Collections.reverseOrder());
        System.out.println(numbersList1);
        Integer max = Collections.max(numbersList1);
        Integer min = Collections.min(numbersList1);
        System.out.println(max + " " + min);
        int index = Collections.binarySearch(numbersList1, 22);
        System.out.println("Collections.binarySearch(22): " + index);
        var max1 = Collections.max(strings, Comparator.comparing(String::length));
        System.out.println(max1);

        // Collections.rotate() - Rotate elements
        List<Integer> rotateList = new ArrayList<>(Arrays.asList(1, 9, 3, 4, 5));
        Collections.rotate(rotateList, 2);
        System.out.println("Collections.rotate(2): " + rotateList);

        List<Integer> replaceList = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 2));
        Collections.replaceAll(replaceList, 2, 99);
        System.out.println("Collections.replaceAll(2->99): " + replaceList);


        // Collections.copy() - Copy one list to another
        List<Integer> source = Arrays.asList(10, 20, 30);
        List<Integer> dest = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Collections.copy(dest, source);
        System.out.println("Collections.copy(): " + dest);

        // Collections.swap() - Swap two elements
        List<Integer> swapList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Collections.swap(swapList, 0, 4);
        System.out.println("Collections.swap(0,4): " + swapList);


        System.out.println("\n========== FREQUENCY & DISJOINT ==========\n");

        // Collections.frequency() - Count occurrences
        List<Integer> freqList = Arrays.asList(1, 2, 2, 3, 2, 4, 2);
        int freq = Collections.frequency(freqList, 2);
        System.out.println("Collections.frequency(2): " + freq);

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(3, 4, 5);
        boolean disjoint1 = Collections.disjoint(list1, list2);
        boolean disjoint2 = Collections.disjoint(list1, list3);
        System.out.println("Collections.disjoint([1,2,3], [4,5,6]): " + disjoint1);
        System.out.println("Collections.disjoint([1,2,3], [3,4,5]): " + disjoint2);


        //Sort
        var collect = strings.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        var collect1 = strings.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());

        List<Employee> collect2 = employees.stream().sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getSalary).reversed()).filter(Objects::isNull).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect2);

        List<Employee> byGeneration = employees.stream()
                .sorted(Comparator
                        .comparingInt((Employee e) -> {
                            if (e.getAge() < 27) return 1; // Gen Z
                            if (e.getAge() < 43) return 2; // Millennial
                            return 3; // Gen X
                        })
                        .thenComparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        System.out.println(byGeneration);

        byGeneration.forEach(e -> {
            String gen = e.getAge() < 27 ? "[Gen Z]     " :
                    e.getAge() < 43 ? "[Millennial]" : "[Gen X]     ";
            System.out.println(gen + " " + e);
        });

        Optional<Integer> first = numbersList1.stream().sorted().findFirst();

        if (first.isPresent()) {
            System.out.println(first.get());
        }


        /////////////////// MAX //////////////////////////////

        // ==================== FOR NUMBERS ====================
        System.out.println("===== FOR NUMBERS =====\n");

        Integer maxChain = numbersList1.stream()
                .max(Integer::compareTo)
                .orElse(0);
        System.out.println("\n3. max(Integer::compareTo): " + maxChain);
        Optional<Integer> max22 = numbersList1.stream().max(Comparator.comparing(Integer::intValue));
        Optional<Integer> max72 = numbersList1.stream().max(Comparator.naturalOrder());
        System.out.println(max72 + " " + max22);
        // 1. Using Collections.max() - NON-STREAM approach
        Integer max11 = Collections.max(numbersList1);
        System.out.println("1. Collections.max(numbersList1): " + max1);

        // 2. Using sorted().findFirst() - Get max by sorting descending
        Integer max2 = numbersList1.stream()
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElse(0);
        System.out.println("2. sorted(reverseOrder).findFirst(): " + max2);

        // 3. Using sorted().skip() - Skip to last element
        Integer max3 = numbersList1.stream()
                .sorted()
                .skip(numbersList1.size() - 1)
                .findFirst()
                .orElse(0);
        System.out.println("3. sorted().skip(size-1).findFirst(): " + max3);

        // 4. Using reduce with Integer::max method reference
        Integer max4 = numbersList1.stream()
                .reduce(Integer::max)
                .orElse(0);
        System.out.println("4. reduce(Integer::max): " + max4);

        // 5. Using reduce with Math.max
        Integer max5 = numbersList1.stream()
                .reduce((a, b) -> Math.max(a, b))
                .orElse(0);
        System.out.println("5. reduce(Math.max): " + max5);

        // 6. Using reduce with initial value
        Integer max6 = numbersList1.stream()
                .reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("6. reduce(MIN_VALUE, Integer::max): " + max6);

        // 7. Using summaryStatistics()
        IntSummaryStatistics stats = numbersList1.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println("7. summaryStatistics().getMax(): " + stats.getMax());

        // 8. Using parallel stream for large datasets
        Integer max8 = numbersList1.parallelStream()
                .max(Comparator.naturalOrder())
                .orElse(0);
        System.out.println("8. parallelStream().max(): " + max8);

        // 9. Using takeWhile with sorted (Java 9+)
        Integer max9 = numbersList1.stream()
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .findFirst()
                .orElse(0);
        System.out.println("9. sorted(reverse).limit(1).findFirst(): " + max9);
        // ==================== FOR STRINGS ====================
        System.out.println("\n\n===== FOR STRINGS (Max by Length) =====\n");

        // 1. Collections.max with custom comparator
        String maxStr1 = Collections.max(strings, Comparator.comparingInt(String::length));
        System.out.println("1. Collections.max(comparingInt(length)): " + maxStr1);

        // 2. Using reduce to get longest string
        String maxStr2 = strings.stream()
                .reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2)
                .orElse("");
        System.out.println("2. reduce(compare lengths): " + maxStr2);

        // 3. Using sorted by length descending
        String maxStr3 = strings.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .findFirst()
                .orElse("");
        System.out.println("3. sorted(length desc).findFirst(): " + maxStr3);

        // 4. Using max with comparing
        String maxStr4 = strings.stream()
                .max(Comparator.comparing(s -> s.length()))
                .orElse("");
        System.out.println("4. max(comparing(s->s.length())): " + maxStr4);

        // 5. Get max length as number, then find that string
        int maxLen = strings.stream().mapToInt(String::length).max().orElse(0);
        String maxStr5 = strings.stream()
                .filter(s -> s.length() == maxLen)
                .findFirst()
                .orElse("");
        System.out.println("5. Find max length, then filter: " + maxStr5);

        // 6. Using for-each loop
        String maxStr6 = "";
        for (String s : strings) {
            if (s.length() > maxStr6.length()) maxStr6 = s;
        }
        System.out.println("6. For-each loop: " + maxStr6);

        // ==================== FOR EMPLOYEES ====================
        System.out.println("\n\n===== FOR EMPLOYEES =====\n");

        // 1. Collections.max with comparator
        Employee maxEmp1 = Collections.max(employees, Comparator.comparingDouble(Employee::getSalary));
        System.out.println("1. Collections.max(comparingDouble(salary)):");
        System.out.println("   " + maxEmp1);

        // 2. Using sorted descending
        Employee maxEmp2 = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .findFirst()
                .orElse(null);
        System.out.println("\n2. sorted(salary desc).findFirst():");
        System.out.println("   " + maxEmp2);

        // 3. Using reduce with Employee comparison
        Employee maxEmp3 = employees.stream()
                .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2)
                .orElse(null);
        System.out.println("\n3. reduce(salary comparison):");
        System.out.println("   " + maxEmp3);

        // 4. Find max salary first, then get employee
        double maxSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0);
        Employee maxEmp4 = employees.stream()
                .filter(e -> e.getSalary() == maxSalary)
                .findFirst()
                .orElse(null);
        System.out.println("\n4. Find max salary, then filter employee:");
        System.out.println("   " + maxEmp4);

        // 5. Using DoubleSummaryStatistics
        DoubleSummaryStatistics salaryStats = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("\n5. summarizingDouble(salary).getMax(): " + salaryStats.getMax());

        // 6. Top N - Get top 3 highest paid
        System.out.println("\n6. Top 3 highest paid employees:");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .forEach(e -> System.out.println("   " + e));

        // 7. Max by multiple criteria - Highest salary in IT department
        System.out.println("\n7. Max salary in IT department:");
        Employee maxIT = employees.stream()
                .filter(e -> e.getDepartment() == Employee.Department.IT)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
        System.out.println("   " + maxIT);

        // 8. Oldest employee
        System.out.println("\n8. Oldest employee:");
        Employee oldest = employees.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .orElse(null);
        System.out.println("   " + oldest);

        // 9. Most senior (earliest joining date)
        System.out.println("\n9. Most senior (earliest joining):");
        Employee mostSenior = employees.stream()
                .min(Comparator.comparing(Employee::getJoiningDate))
                .orElse(null);
        System.out.println("   " + mostSenior);

        // 10. Group by department and find max in each
        System.out.println("\n10. Highest paid in EACH department:");
        Map<Employee.Department, Optional<Employee>> maxByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));
        maxByDept.forEach((dept, emp) ->
                System.out.println("   " + dept + ": " + emp.orElse(null)));

        // 11. Using custom comparator with multiple fields
        System.out.println("\n11. Max by salary, if equal then by age:");
        Employee maxCustom = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary)
                        .thenComparingInt(Employee::getAge))
                .orElse(null);
        System.out.println("   " + maxCustom);

        // 12. Using traditional loop
        Employee maxEmpLoop = employees.get(0);
        for (Employee e : employees) {
            if (e.getSalary() > maxEmpLoop.getSalary()) {
                maxEmpLoop = e;
            }
        }
        System.out.println("\n12. Traditional for loop:");
        System.out.println("   " + maxEmpLoop);


        // ==================== ADVANCED TECHNIQUES ====================
        System.out.println("\n\n===== ADVANCED MAX TECHNIQUES =====\n");

        // 1. Max with null safety
        List<Integer> withNulls = Arrays.asList(1, null, 5, null, 3);
        Integer maxNullSafe = withNulls.stream()
                .filter(Objects::nonNull)
                .max(Comparator.naturalOrder())
                .orElse(0);
        System.out.println("1. Null-safe max: " + maxNullSafe);

        // 2. Max of calculated values - Total compensation (salary + bonus assumed 10%)
        Employee maxTotalComp = employees.stream()
                .max(Comparator.comparingDouble(e -> e.getSalary() * 1.1))
                .orElse(null);
        System.out.println("\n2. Max by calculated value (salary + 10% bonus):");
        System.out.println("   " + maxTotalComp);

        // 3. Max using method reference chain
        Integer maxChain1 = numbersList1.stream()
                .max(Integer::compareTo)
                .orElse(0);
        System.out.println("\n3. max(Integer::compareTo): " + maxChain1);

        // 4. Conditional max - Max of even numbers only
        Integer maxEven = numbersList1.stream()
                .filter(n -> n % 2 == 0)
                .max(Comparator.naturalOrder())
                .orElse(0);
        System.out.println("\n4. Max of even numbers only: " + maxEven);

        // 5. Max index - Find position of max element
        int maxIndex = IntStream.range(0, numbersList1.size())
                .reduce((i, j) -> numbersList1.get(i) > numbersList1.get(j) ? i : j)
                .orElse(-1);
        System.out.println("\n5. Index of max element: " + maxIndex + " (value: " + numbersList1.get(maxIndex) + ")");

        // 6. Multiple max values - All employees with max salary
        double maxSal = employees.stream()
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0);
        System.out.println("\n6. All employees with max salary ($" + maxSal + "):");
        employees.stream()
                .filter(e -> e.getSalary() == maxSal)
                .forEach(e -> System.out.println("   " + e));


        System.out.println("\n\n========== PERFORMANCE COMPARISON ==========\n");

        // Compare performance of different methods
        List<Integer> largeList = IntStream.range(1, 100000).boxed().collect(Collectors.toList());

        long start1 = System.nanoTime();
        Collections.max(largeList);
        long time1 = System.nanoTime() - start1;

        long start2 = System.nanoTime();
        largeList.stream().max(Comparator.naturalOrder());
        long time2 = System.nanoTime() - start2;

        long start3 = System.nanoTime();
        largeList.stream().reduce(Integer::max);
        long time3 = System.nanoTime() - start3;

        System.out.println("Collections.max(): " + time1 + " ns");
        System.out.println("stream().max(): " + time2 + " ns");
        System.out.println("reduce(Integer::max): " + time3 + " ns");
        System.out.println("\n(Collections.max() is usually fastest for simple cases)");


        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment)).values().stream();
    }
}
