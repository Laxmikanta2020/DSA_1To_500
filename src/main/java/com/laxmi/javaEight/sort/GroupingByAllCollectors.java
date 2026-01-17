package com.laxmi.javaEight.sort;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingByAllCollectors {

    public static void main(String[] args) {
        List<Employee> employees = Employee.getSampleEmployees();

        System.out.println("========== GROUPING BY WITH ALL COLLECTORS ==========\n");

        System.out.println("Sample Employees:");
        employees.forEach(System.out::println);


        // ==================== 1. BASIC GROUPING (DEFAULT - toList) ====================
        System.out.println("\n\n===== 1. BASIC GROUPING - groupingBy(classifier) =====\n");

        Map<Employee.Department, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("Group by Department:");
        byDept.forEach((dept, emps) -> {
            System.out.println(dept + " (" + emps.size() + "):");
            emps.forEach(e -> System.out.println("  " + e));
        });


        // ==================== 2. COUNTING ====================
        System.out.println("\n\n===== 2. COUNTING - Count employees per group =====\n");

        Map<Employee.Department, Long> countByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(countByDept);
        // ==================== 3. SUMMING ====================
        System.out.println("\n\n===== 3. SUMMING - Sum salaries per group =====\n");

        // summingDouble
        Map<Employee.Department, Double> salaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)));

        System.out.println("Total Salary by Department:");
        salaryByDept.forEach((dept, total) ->
                System.out.println(dept + ": $" + String.format("%.0f", total)));

        // summingInt - Total skills count per department
        Map<Employee.Department, Integer> skillsCountByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summingInt(e -> e.getSkills().size())));

        System.out.println("\nTotal Skills by Department:");
        skillsCountByDept.forEach((dept, count) ->
                System.out.println(dept + ": " + count + " skills"));


        // ==================== 4. AVERAGING ====================
        System.out.println("\n\n===== 4. AVERAGING - Average values per group =====\n");

        // averagingDouble
        Map<Employee.Department, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("Average Salary by Department:");
        avgSalaryByDept.forEach((dept, avg) ->
                System.out.println(dept + ": $" + String.format("%.2f", avg)));

        // ==================== 5. MAX BY / MIN BY ====================
        System.out.println("\n\n===== 5. MAX BY / MIN BY - Highest/Lowest paid per group =====\n");

        // maxBy - Highest paid in each department
        Map<Employee.Department, Optional<Employee>> highestPaidByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

        Map<Employee.Department, String> deptWithHighestPaidName = highestPaidByDept.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,                                                // department
                        e -> e.getValue().map(Employee::getName).orElse("No Employee")   // name or default text
                ));
        System.out.print(deptWithHighestPaidName);
        System.out.println("Highest Paid by Department:");
        highestPaidByDept.forEach((dept, emp) ->
                System.out.println(dept + ": " + emp.map(Employee::getName).orElse("N/A")));

        // minBy - Youngest in each city
        Map<String, Optional<Employee>> youngestByCity = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getCity,
                        Collectors.minBy(Comparator.comparingInt(Employee::getAge))));

        System.out.println("\nYoungest by City:");
        youngestByCity.forEach((city, emp) ->
                System.out.println(city + ": " + emp.map(e -> e.getName() + " (Age: " + e.getAge() + ")").orElse("N/A")));


        // ==================== 6. MAPPING ====================
        System.out.println("\n\n===== 6. MAPPING - Transform before collecting =====\n");

        // Get only names grouped by department
        Map<Employee.Department, List<String>> namesByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())));

        System.out.println("Employee Names by Department:");
        namesByDept.forEach((dept, names) ->
                System.out.println(dept + ": " + names));

        // Get salaries grouped by city
        Map<String, List<Double>> salariesByCity = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getCity,
                        Collectors.mapping(Employee::getSalary, Collectors.toList())));

        System.out.println("\nSalaries by City:");
        salariesByCity.forEach((city, salaries) ->
                System.out.println(city + ": " + salaries));


        // ==================== 7. FLAT MAPPING ====================
        System.out.println("\n\n===== 7. FLAT MAPPING - Flatten collections =====\n");

        // Distinct skills by department
        Map<Employee.Department, Set<String>> uniqueSkillsByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.flatMapping(
                                e -> e.getSkills().stream(),
                                Collectors.toSet())));

        System.out.println("\nUnique Skills by Department:");
        uniqueSkillsByDept.forEach((dept, skills) ->
                System.out.println(dept + ": " + skills));


        // ==================== 8. FILTERING ====================
        System.out.println("\n\n===== 8. FILTERING - Filter within groups =====\n");

        // Group by department, but only employees with salary > 80k
        Map<Employee.Department, List<Employee>> highEarnersByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.filtering(
                                e -> e.getSalary() > 80000,
                                Collectors.toList())));

        System.out.println("High Earners (>$80k) by Department:");
        highEarnersByDept.forEach((dept, emps) -> {
            System.out.println(dept + " (" + emps.size() + "):");
            emps.forEach(e -> System.out.println("  " + e.getName() + " - $" + e.getSalary()));
        });


        // ==================== 9. JOINING ====================
        System.out.println("\n\n===== 9. JOINING - Concatenate strings =====\n");

        // Join with prefix and suffix
        Map<String, String> namesJoinedByCity = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getCity,
                        Collectors.mapping(
                                Employee::getName,
                                Collectors.joining(", ", "[", "]"))));

        System.out.println("\nNames Joined by City (with brackets):");
        namesJoinedByCity.forEach((city, names) ->
                System.out.println(city + ": " + names));

        // ==================== 11. TO COLLECTION ====================
        System.out.println("\n\n===== 11. TO COLLECTION - Custom collection type =====\n");

        // Group into TreeSet (sorted)
        Map<Employee.Department, TreeSet<String>> sortedNamesByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(
                                Employee::getName,
                                Collectors.toCollection(TreeSet::new))));

        System.out.println("Sorted Names by Department:");
        sortedNamesByDept.forEach((dept, names) ->
                System.out.println(dept + ": " + names));


        // ==================== 12. SUMMARIZING ====================
        System.out.println("\n\n===== 12. SUMMARIZING - Get all statistics at once =====\n");

        // DoubleSummaryStatistics for salary
        Map<Employee.Department, DoubleSummaryStatistics> salaryStatsByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summarizingDouble(Employee::getSalary)));

        System.out.println("Salary Statistics by Department:");
        salaryStatsByDept.forEach((dept, stats) -> {
            System.out.println(dept + ":");
            System.out.println("  Count: " + stats.getCount());
            System.out.println("  Sum: $" + String.format("%.0f", stats.getSum()));
            System.out.println("  Min: $" + String.format("%.0f", stats.getMin()));
            System.out.println("  Max: $" + String.format("%.0f", stats.getMax()));
            System.out.println("  Avg: $" + String.format("%.2f", stats.getAverage()));
        });

        // IntSummaryStatistics for age
        Map<String, IntSummaryStatistics> ageStatsByCity = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getCity,
                        Collectors.summarizingInt(Employee::getAge)));

        System.out.println("\nAge Statistics by City:");
        ageStatsByCity.forEach((city, stats) -> {
            System.out.println(city + ": Avg=" + String.format("%.1f", stats.getAverage()) +
                    ", Min=" + stats.getMin() + ", Max=" + stats.getMax());
        });


        // ==================== 13. REDUCING ====================
        System.out.println("\n\n===== 13. REDUCING - Custom reduction =====\n");

        // Total compensation (salary + bonus) by department
        Map<Employee.Department, Double> totalCompByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.reducing(
                                0.0,
                                e -> e.getSalary() + e.getBonus(),
                                Double::sum)));

        System.out.println("Total Compensation (Salary+Bonus) by Department:");
        totalCompByDept.forEach((dept, total) ->
                System.out.println(dept + ": $" + total));

        // Concatenate all names in department
        Map<Employee.Department, String> concatenatedNames = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.reducing(
                                "",
                                Employee::getName,
                                (s1, s2) -> s1.isEmpty() ? s2 : s1 + ", " + s2)));

        System.out.println("\nConcatenated Names by Department:");
        concatenatedNames.forEach((dept, names) ->
                System.out.println(dept + ": " + names));


        // ==================== 14. COLLECTING AND THEN ====================
        System.out.println("\n\n===== 14. COLLECTING AND THEN - Post-process results =====\n");

        // Group by department and get unmodifiable list
        Map<Employee.Department, List<Employee>> unmodifiableByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                Collections::unmodifiableList)));

        System.out.println("Unmodifiable Lists by Department:");
        unmodifiableByDept.forEach((dept, emps) ->
                System.out.println(dept + ": " + emps.size() + " employees (unmodifiable)"));

        // Get size of each group
        Map<Employee.Department, Integer> sizeByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                List::size)));

        System.out.println("\nGroup Sizes:");
        sizeByDept.forEach((dept, size) ->
                System.out.println(dept + ": " + size));


        // ==================== 15. MULTI-LEVEL GROUPING ====================
        System.out.println("\n\n===== 15. MULTI-LEVEL GROUPING - Nested groups =====\n");

        // Group by Department, then by City
        Map<Employee.Department, Map<String, List<Employee>>> byDeptThenCity = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.groupingBy(Employee::getCity)));

        System.out.println("Group by Department → City:");
        byDeptThenCity.forEach((dept, cityMap) -> {
            System.out.println(dept + ":");
            cityMap.forEach((city, emps) ->
                    System.out.println("  " + city + ": " + emps.size() + " employees"));
        });

        // Group by City, then count by Department
        Map<String, Map<Employee.Department, Long>> byCityThenDeptCount = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getCity,
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting())));

        System.out.println("\nGroup by City → Department Count:");
        byCityThenDeptCount.forEach((city, deptMap) -> {
            System.out.println(city + ":");
            deptMap.forEach((dept, count) ->
                    System.out.println("  " + dept + ": " + count));
        });

        // Group by Department → Gender → Average Salary
        Map<Employee.Department, Map<String, Double>> byDeptGenderAvgSalary = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.groupingBy(
                                Employee::getGender,
                                Collectors.averagingDouble(Employee::getSalary))));

        System.out.println("\nAverage Salary by Department → Gender:");
        byDeptGenderAvgSalary.forEach((dept, genderMap) -> {
            System.out.println(dept + ":");
            genderMap.forEach((gender, avg) ->
                    System.out.println("  " + gender + ": $" + String.format("%.2f", avg)));
        });


        // ==================== 16. PARTITION BY (SPECIAL CASE) ====================
        System.out.println("\n\n===== 16. PARTITION BY - Split into two groups (true/false) =====\n");

        // Partition by salary > 80k
        Map<Boolean, List<Employee>> partitionedBySalary = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 80000));

        System.out.println("Partition by Salary > $80k:");
        System.out.println("High earners (true): " + partitionedBySalary.get(true).size());
        System.out.println("Others (false): " + partitionedBySalary.get(false).size());

        // Partition by age with counting
        Map<Boolean, Long> partitionedByAgeCount = employees.stream()
                .collect(Collectors.partitioningBy(
                        e -> e.getAge() >= 30,
                        Collectors.counting()));

        System.out.println("\nPartition by Age >= 30:");
        System.out.println("Age >= 30: " + partitionedByAgeCount.get(true));
        System.out.println("Age < 30: " + partitionedByAgeCount.get(false));


        // ==================== 17. COMPLEX COMBINATIONS ====================
        System.out.println("\n\n===== 17. COMPLEX COMBINATIONS =====\n");

        // Department → Names of employees earning > 80k
        Map<Employee.Department, List<String>> highEarnerNamesByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.filtering(
                                e -> e.getSalary() > 80000,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toList()))));

        System.out.println("High Earner Names by Department:");
        highEarnerNamesByDept.forEach((dept, names) ->
                System.out.println(dept + ": " + names));

        // City → Average bonus % (bonus/salary * 100)
        Map<String, Double> avgBonusPctByCity = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getCity,
                        Collectors.averagingDouble(e -> (e.getBonus() / e.getSalary()) * 100)));

        System.out.println("\nAverage Bonus % by City:");
        avgBonusPctByCity.forEach((city, avg) ->
                System.out.println(city + ": " + String.format("%.1f%%", avg)));


        // ==================== SUMMARY TABLE ====================
        System.out.println("\n\n===== 📋 ALL COLLECTORS METHODS SUMMARY =====\n");

        System.out.println("Collector Method              | What It Does");
        System.out.println("------------------------------|------------------------------------");
        System.out.println("toList()                      | Collect to List (default)");

        Map<Employee.Department, Long> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        String name = "Laxmikanat";
        Map<Character, Long> collect1 = name.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.print(collect);
        System.out.print(collect1);
        System.out.println("toSet()                       | Collect to Set (unique)");
        System.out.println("toCollection(Supplier)        | Custom collection type");
        System.out.println("counting()                    | Count elements");
        System.out.println("summingInt/Long/Double()      | Sum values");
        System.out.println("averagingInt/Long/Double()    | Average values");
        System.out.println("summarizingInt/Long/Double()  | All stats at once");
        System.out.println("maxBy(Comparator)             | Find maximum");
        System.out.println("minBy(Comparator)             | Find minimum");
        System.out.println("mapping(Function, Collector)  | Transform then collect");
        System.out.println("flatMapping(Function, Coll.)  | Flatten then collect");
        System.out.println("filtering(Predicate, Coll.)   | Filter then collect");
        System.out.println("joining()                     | Concatenate strings");
        System.out.println("reducing()                    | Custom reduction");
        System.out.println("collectingAndThen()           | Post-process result");
        System.out.println("groupingBy()                  | Group into map");
        System.out.println("partitioningBy()              | Split into true/false");
    }
}
