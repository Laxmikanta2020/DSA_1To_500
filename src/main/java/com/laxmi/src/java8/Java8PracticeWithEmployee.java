package com.laxmi.src.java8;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.function.*;
import java.util.stream.Collectors;

public class Java8PracticeWithEmployee {

    public static void main(String[] args) {
        Java8PracticeWithEmployee practice = new Java8PracticeWithEmployee();
        List<Employee> employees = Employee.getSampleEmployees();

        System.out.println("=== COMPREHENSIVE JAVA 8 PRACTICE WITH EMPLOYEE DATA ===\n");

        practice.practiceLambdaWithEmployees(employees);
        practice.practiceMethodReferences(employees);
        practice.practiceStreamsFiltering(employees);
        practice.practiceStreamsMapping(employees);
        practice.practiceStreamsAggregation(employees);
        practice.practiceOptionalWithEmployees(employees);
        practice.practiceDateTimeAPI(employees);
        practice.practiceFunctionalInterfaces(employees);
        practice.practiceCollectorsAdvanced(employees);
        practice.practiceParallelStreams(employees);
        practice.practiceCustomFunctionalInterfaces(employees);
        practice.practiceCompletableFutureExample(employees);
        practice.practiceStringJoinerAndCollectors();
    }

    // 1. Lambda Expressions with Employees
    private void practiceLambdaWithEmployees(List<Employee> employees) {
        System.out.println("1. LAMBDA EXPRESSIONS WITH EMPLOYEES");
        System.out.println("-".repeat(50));

        // Comparator with lambda
        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        System.out.println("Employees sorted by salary (descending):");
        employees.forEach(e -> System.out.println("  " + e.getName() + ": $" + e.getSalary()));

        // Predicate with lambda
        Predicate<Employee> highSalary = e -> e.getSalary() > 80000;
        Predicate<Employee> itDepartment = e -> e.getDepartment() == Employee.Department.IT;

        System.out.println("\nHigh-paid IT employees:");
        employees.stream()
                .filter(highSalary.and(itDepartment))
                .forEach(e -> System.out.println("  " + e.getName()));

        System.out.println();
    }

    // 2. Method References
    private void practiceMethodReferences(List<Employee> employees) {
        System.out.println("2. METHOD REFERENCES");
        System.out.println("-".repeat(50));

        // Static method reference
        employees.forEach(System.out::println);

        // Instance method reference
        List<String> names = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("\nAll employee names: " + names);

        // Constructor reference
        Supplier<List<String>> listSupplier = ArrayList::new;
        List<String> skillsList = listSupplier.get();

        // Arbitrary object method reference
        employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);

        System.out.println();
    }

    // 3. Streams - Filtering Operations
    private void practiceStreamsFiltering(List<Employee> employees) {
        System.out.println("3. STREAMS - FILTERING OPERATIONS");
        System.out.println("-".repeat(50));

        // Filter
        System.out.println("Active employees in IT department:");
        employees.stream()
                .filter(Employee::isActive)
                .filter(e -> e.getDepartment() == Employee.Department.IT)
                .forEach(e -> System.out.println("  " + e.getName()));

        // Distinct
        List<String> cities = employees.stream()
                .map(Employee::getCity)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("\nUnique cities: " + cities);

        // Limit and Skip
        System.out.println("\nTop 3 highest paid employees:");
        employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .limit(3)
                .forEach(e -> System.out.println("  " + e.getName() + ": $" + e.getSalary()));

        // Find operations
        Optional<Employee> firstNYEmployee = employees.stream()
                .filter(e -> e.getCity().equals("New York"))
                .findFirst();
        firstNYEmployee.ifPresent(e ->
                System.out.println("\nFirst NY employee: " + e.getName()));

        // AnyMatch, AllMatch, NoneMatch
        boolean anySenior = employees.stream()
                .anyMatch(Employee::isSenior);
        System.out.println("\nAny senior employees? " + anySenior);

        boolean allActive = employees.stream()
                .allMatch(Employee::isActive);
        System.out.println("All employees active? " + allActive);

        System.out.println();
    }

    // 4. Streams - Mapping Operations
    private void practiceStreamsMapping(List<Employee> employees) {
        System.out.println("4. STREAMS - MAPPING OPERATIONS");
        System.out.println("-".repeat(50));

        // Map
        List<Double> salaries = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.toList());
        System.out.println("All salaries: " + salaries);

        // FlatMap - Get all unique skills
        Set<String> allSkills = employees.stream()
                .flatMap(e -> e.getSkills().stream())
                .collect(Collectors.toSet());
        System.out.println("\nAll unique skills: " + allSkills);

        // Map with transformation
        Map<String, Double> nameSalaryMap = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        Employee::getSalary,
                        (e1, e2) -> e1  // handle duplicates
                ));
        System.out.println("\nName-Salary Map: " + nameSalaryMap);

        // Peek for debugging
        System.out.println("\nEmployees with bonus > 5000:");
        List<Employee> highBonusEmployees = employees.stream()
                .filter(e -> e.getBonus() > 5000)
                .peek(e -> System.out.println("  Processing: " + e.getName()))
                .collect(Collectors.toList());

        System.out.println();
    }

    // 5. Streams - Aggregation Operations
    private void practiceStreamsAggregation(List<Employee> employees) {
        System.out.println("5. STREAMS - AGGREGATION OPERATIONS");
        System.out.println("-".repeat(50));

        // Reduce - Total salary
        double totalSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
        System.out.println("Total salary: $" + totalSalary);

        // Max/Min
        Optional<Employee> highestPaid = employees.stream()
                .max(Comparator.comparing(Employee::getSalary));
        highestPaid.ifPresent(e ->
                System.out.println("Highest paid: " + e.getName() + " - $" + e.getSalary()));

        // Count
        long itCount = employees.stream()
                .filter(e -> e.getDepartment() == Employee.Department.IT)
                .count();
        System.out.println("IT employees count: " + itCount);

        // Summary statistics
        DoubleSummaryStatistics salaryStats = employees.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();
        System.out.println("\nSalary Statistics:");
        System.out.println("  Average: $" + salaryStats.getAverage());
        System.out.println("  Max: $" + salaryStats.getMax());
        System.out.println("  Min: $" + salaryStats.getMin());
        System.out.println("  Count: " + salaryStats.getCount());
        System.out.println("  Sum: $" + salaryStats.getSum());

        System.out.println();
    }

    // 6. Optional with Employees
    private void practiceOptionalWithEmployees(List<Employee> employees) {
        System.out.println("6. OPTIONAL CLASS WITH EMPLOYEES");
        System.out.println("-".repeat(50));

        // Find employee by ID
        Optional<Employee> employeeOpt = findEmployeeById(employees, 5);

        // IfPresent
        employeeOpt.ifPresent(e ->
                System.out.println("Employee found: " + e.getName()));

        // OrElse
        Employee employee = findEmployeeById(employees, 99)
                .orElse(new Employee(0, "Default", 0, Employee.Department.IT,
                        LocalDate.now(), Arrays.asList(), 0, "N/A", "N/A", false, 0));
        System.out.println("\nEmployee or default: " + employee.getName());

        // Map and FlatMap
        String departmentName = findEmployeeById(employees, 1)
                .map(Employee::getDepartment)
                .map(Enum::name)
                .orElse("UNKNOWN");
        System.out.println("\nDepartment for ID 1: " + departmentName);

        // Filter
        Optional<Employee> seniorEmployee = findEmployeeById(employees, 4)
                .filter(Employee::isSenior);
        seniorEmployee.ifPresent(e ->
                System.out.println("Employee 4 is senior: " + e.getName()));

        System.out.println();
    }

    private Optional<Employee> findEmployeeById(List<Employee> employees, int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    // 7. Date/Time API
    private void practiceDateTimeAPI(List<Employee> employees) {
        System.out.println("7. DATE/TIME API WITH EMPLOYEES");
        System.out.println("-".repeat(50));

        // Filter employees who joined in last 3 years
        LocalDate threeYearsAgo = LocalDate.now().minusYears(3);
        List<Employee> recentEmployees = employees.stream()
                .filter(e -> e.getJoiningDate().isAfter(threeYearsAgo))
                .collect(Collectors.toList());
        System.out.println("Employees joined in last 3 years: " + recentEmployees.size());

        // Format joining dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        System.out.println("\nFormatted joining dates:");
        employees.stream()
                .limit(3)
                .forEach(e -> System.out.println("  " + e.getName() + ": " +
                        e.getJoiningDate().format(formatter)));

        // Calculate experience in months
        System.out.println("\nExperience in months:");
        employees.stream()
                .limit(3)
                .forEach(e -> {
                    Period period = Period.between(e.getJoiningDate(), LocalDate.now());
                    int months = period.getYears() * 12 + period.getMonths();
                    System.out.println("  " + e.getName() + ": " + months + " months");
                });

        System.out.println();
    }

    // 8. Functional Interfaces
    private void practiceFunctionalInterfaces(List<Employee> employees) {
        System.out.println("8. BUILT-IN FUNCTIONAL INTERFACES");
        System.out.println("-".repeat(50));

        // Predicate - Senior employees
        Predicate<Employee> isSenior = Employee::isSenior;
        System.out.println("Senior employees:");
        employees.stream()
                .filter(isSenior)
                .forEach(e -> System.out.println("  " + e.getName()));

        // Function - Name and salary string
        Function<Employee, String> nameSalary =
                e -> e.getName() + " earns $" + e.getSalary();
        System.out.println("\nName and salary:");
        employees.stream()
                .limit(3)
                .map(nameSalary)
                .forEach(System.out::println);

        // Consumer - Give raise
        Consumer<Employee> give10PercentRaise = e -> e.setSalary(e.getSalary() * 1.10);
        System.out.println("\nAfter 10% raise (first 3):");
        employees.stream()
                .limit(3)
                .peek(give10PercentRaise)
                .forEach(e -> System.out.println("  " + e.getName() + ": $" + e.getSalary()));

        // Supplier - Create random employee
        Supplier<Employee> randomEmployeeSupplier = () ->
                new Employee(999, "Random", 50000, Employee.Department.IT,
                        LocalDate.now(), Arrays.asList("Java"), 25, "Male", "Random City", true, 0);
        System.out.println("\nRandom employee: " + randomEmployeeSupplier.get().getName());

        // BiFunction - Calculate bonus percentage
        BiFunction<Employee, Double, Double> calculateBonus =
                (e, percentage) -> e.getSalary() * percentage / 100;
        System.out.println("\nBonus calculations:");
        employees.stream()
                .limit(2)
                .forEach(e -> {
                    double bonus = calculateBonus.apply(e, 10.0);
                    System.out.println("  " + e.getName() + ": $" + bonus);
                });

        System.out.println();
    }

    // 9. Advanced Collectors
    private void practiceCollectorsAdvanced(List<Employee> employees) {
        System.out.println("9. ADVANCED COLLECTORS");
        System.out.println("-".repeat(50));

        // Grouping by department
        Map<Employee.Department, List<Employee>> byDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Employees by department:");
        byDepartment.forEach((dept, empList) ->
                System.out.println("  " + dept + ": " + empList.size() + " employees"));

        // Grouping by department with average salary
        Map<Employee.Department, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
        System.out.println("\nAverage salary by department:");
        avgSalaryByDept.forEach((dept, avg) ->
                System.out.println("  " + dept + ": $" + String.format("%.2f", avg)));

        // Partitioning
        Map<Boolean, List<Employee>> partitionedBySalary = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 80000));
        System.out.println("\nPartitioned by salary > 80k:");
        System.out.println("  High earners: " + partitionedBySalary.get(true).size());
        System.out.println("  Others: " + partitionedBySalary.get(false).size());

        // Joining
        String allNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("\nAll employee names: " + allNames);

        // Summarizing
        Map<Employee.Department, DoubleSummaryStatistics> salaryStatsByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summarizingDouble(Employee::getSalary)
                ));
        System.out.println("\nSalary statistics by department:");
        salaryStatsByDept.forEach((dept, stats) ->
                System.out.println("  " + dept + ": Avg=$" +
                        String.format("%.2f", stats.getAverage()) +
                        ", Max=$" + stats.getMax()));

        System.out.println();
    }

    // 10. Parallel Streams
    private void practiceParallelStreams(List<Employee> employees) {
        System.out.println("10. PARALLEL STREAMS");
        System.out.println("-".repeat(50));

        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());

        // Sequential processing
        long start = System.currentTimeMillis();
        double sequentialTotal = employees.stream()
                .mapToDouble(this::processEmployee)
                .sum();
        long sequentialTime = System.currentTimeMillis() - start;

        // Parallel processing
        start = System.currentTimeMillis();
        double parallelTotal = employees.parallelStream()
                .mapToDouble(this::processEmployee)
                .sum();
        long parallelTime = System.currentTimeMillis() - start;

        System.out.println("\nSequential processing:");
        System.out.println("  Total: " + sequentialTotal);
        System.out.println("  Time: " + sequentialTime + "ms");

        System.out.println("\nParallel processing:");
        System.out.println("  Total: " + parallelTotal);
        System.out.println("  Time: " + parallelTime + "ms");

        System.out.println("\nThread used: " + ForkJoinPool.commonPool().getParallelism());

        System.out.println();
    }

    private double processEmployee(Employee e) {
        // Simulate some processing
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return e.getSalary() * 1.05; // 5% increase simulation
    }

    // 11. Custom Functional Interfaces
    private void practiceCustomFunctionalInterfaces(List<Employee> employees) {
        System.out.println("11. CUSTOM FUNCTIONAL INTERFACES");
        System.out.println("-".repeat(50));

        // Custom functional interface
        @FunctionalInterface
        interface EmployeeFilter {
            boolean test(Employee e);

            default EmployeeFilter and(EmployeeFilter other) {
                return e -> this.test(e) && other.test(e);
            }

            default EmployeeFilter or(EmployeeFilter other) {
                return e -> this.test(e) || other.test(e);
            }
        }

        EmployeeFilter highSalaryFilter = e -> e.getSalary() > 80000;
        EmployeeFilter itFilter = e -> e.getDepartment() == Employee.Department.IT;
        EmployeeFilter seniorFilter = Employee::isSenior;

        // Combine filters
        EmployeeFilter complexFilter = highSalaryFilter.and(itFilter).and(seniorFilter);

        System.out.println("Employees matching complex filter:");
//        employees.stream()
//                .filter(complexFilter)
//                .forEach(e -> System.out.println("  " + e.getName()));

        System.out.println();
    }

    // 12. CompletableFuture
    private void practiceCompletableFutureExample(List<Employee> employees) {
        System.out.println("12. COMPLETABLEFUTURE - ASYNC PROCESSING");
        System.out.println("-".repeat(50));

        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
                    System.out.println("Fetching employee data asynchronously...");
                    return employees.stream()
                            .filter(e -> e.getCity().equals("New York"))
                            .collect(Collectors.toList());
                })
                .thenApplyAsync(nyEmployees -> {
                    System.out.println("Calculating average salary for NY employees...");
                    return nyEmployees.stream()
                            .mapToDouble(Employee::getSalary)
                            .average()
                            .orElse(0.0);
                })
                .thenAcceptAsync(avgSalary -> {
                    System.out.println("NY Employees Average Salary: $" +
                            String.format("%.2f", avgSalary));
                });

        future.join(); // Wait for completion
        System.out.println("Async processing completed!");

        System.out.println();
    }

    // 13. StringJoiner and Additional Collectors
    private void practiceStringJoinerAndCollectors() {
        System.out.println("13. STRINGJOINER AND ADDITIONAL FEATURES");
        System.out.println("-".repeat(50));

        // StringJoiner
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        joiner.add("Java").add("Streams").add("Lambda").add("Optional");
        System.out.println("StringJoiner result: " + joiner);

        // Collectors.mapping
        List<Employee> employees = Employee.getSampleEmployees();
        List<String> itEmployeeNames = employees.stream()
                .filter(e -> e.getDepartment() == Employee.Department.IT).map(Employee::getName).toList();
        System.out.println("\nIT Employee names: " + itEmployeeNames);

        // Collectors.collectingAndThen
        List<Employee> unmodifiableList = employees.stream()
                .filter(Employee::isActive)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));
        System.out.println("\nActive employees (unmodifiable list): " + unmodifiableList.size());

        // Collectors.toConcurrentMap
        ConcurrentHashMap<String, Double> concurrentMap = employees.stream()
                .collect(Collectors.toConcurrentMap(
                        Employee::getName,
                        Employee::getSalary,
                        (v1, v2) -> v1,
                        ConcurrentHashMap::new
                ));
        System.out.println("\nConcurrent map size: " + concurrentMap.size());

        System.out.println();
    }
}