package test.array.java_8;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Optimize {

    public static void main(String[] args) {

        List<Emp> employees = List.of(

                new Emp("Akash", 28, "IT", "Bengaluru"),
                new Emp("Rohit", 30, "IT", "Bengaluru"),          // same dept & location

                new Emp("Suman", 28, "HR", "Hyderabad"),
                new Emp("Pooja", 28, "HR", "Hyderabad"),          // same age, dept, location

                new Emp("Namn", 35, "Finance", "Mumbai"),
                new Emp("Neha", 32, "Finance", "Mumbai"),         // same dept & location

                new Emp("Kiran", 26, "IT", "Chennai"),
                new Emp("Anjali", 26, "IT", "Chennai"),           // same age, dept, location

                new Emp("Vikas", 40, "Admin", "Delhi"),
                new Emp("Raj", 40, "Admin", "Delhi")
                // identical except name
        );

        // 1. Find all employees from IT department
        var itEmployees = employees.stream().filter(emp -> "IT".equals(emp.getDep())).toList();

// Alternative: Using method reference with predicate
        var itEmployees2 = employees.stream()
                .filter(emp -> emp.getDep().equals("IT")).toList();

// 2. Find employees whose age > 30
        var ageAbove30 = employees.stream()
                .filter(emp -> emp.getAge() > 30).toList();

// 3. Find employees from Bengaluru AND IT
        var bengaluruIT = employees.stream()
                .filter(emp -> "Bengaluru".equals(emp.getLocation())
                        && "IT".equals(emp.getDep())).toList();

// 4. Find employees not from HR
        var nonHREmployees = employees.stream()
                .filter(emp -> !"HR".equals(emp.getDep())).toList();

// 5. Find employees whose name starts with "A"
        List<Emp> nameStartsWithA = employees.stream()
                .filter(emp -> emp.getName().startsWith("A")).toList();
        // 1. Get only employee names
        List<String> names = employees.stream()
                .map(Emp::getName).toList();

// 2. Get list of all locations (unique)
        Set<String> uniqueLocations = employees.stream()
                .map(Emp::getLocation).collect(Collectors.toSet());

// 3. Convert all employee names to uppercase
        List<String> upperCaseNames = employees.stream()
                .map(emp -> emp.getName().toUpperCase()).toList();

// 4. Create a list of ages + 5
        List<Integer> agesPlus5 = employees.stream()
                .map(emp -> emp.getAge() + 5).toList();

// 5. Get department names in lowercase
        List<String> lowerCaseDepts = employees.stream()
                .map(emp -> emp.getDep().toLowerCase()).distinct().toList();

// 1. Find unique departments
        List<String> uniqueDepartments = employees.stream()
                .map(Emp::getDep).distinct().toList();

// 2. Find unique locations
        Set<String> uniqueLocationsSet = employees.stream()
                .map(Emp::getLocation).collect(Collectors.toSet());

// 3. Find unique ages
        List<Integer> uniqueAges = employees.stream()
                .map(Emp::getAge)
                .distinct().sorted().toList();

// 4. Find distinct employee names joined with space
        String distinctNames = employees.stream()
                .map(Emp::getName)
                .distinct()
                .collect(Collectors.joining(" "));

// 5. Find unique (department + location) combinations
        Set<String> deptLocationCombos = employees.stream()
                .map(emp -> emp.getDep() + "_" + emp.getLocation())
                .collect(Collectors.toSet());

        // 1. Sort employees by age ascending
        List<Emp> sortedByAgeAsc = employees.stream()
                .sorted(Comparator.comparingInt(Emp::getAge))
                .toList();

// 2. Sort employees by age descending
        List<Emp> sortedByAgeDesc = employees.stream()
                .sorted(Comparator.comparingInt(Emp::getAge).reversed())
                .toList();

// 3. Sort employees by name
        List<Emp> sortedByName = employees.stream()
                .sorted(Comparator.comparing(Emp::getName))
                .toList();

// 4. Sort employees by department then age
        List<Emp> sortedByDeptThenAge = employees.stream()
                .sorted(Comparator.comparing(Emp::getDep)
                        .thenComparingInt(Emp::getAge))
                .toList();

// 5. Sort employees by location then name
       var sortedByLocationThenName = employees.stream()
                .sorted(Comparator.comparing(Emp::getLocation)
                        .thenComparing(Emp::getName)).toList();
// 1. Get first 3 employees
        var firstThree = employees.stream()
                .limit(3).toList();

// 2. Skip first 2 employees
        var skipFirstTwo = employees.stream()
                .skip(2).toList();

// 3. Get 2 employees after skipping first 3
        List<Emp> skip3Take2 = employees.stream()
                .skip(3).limit(2).toList();

// 4. Get youngest 3 employees
        List<Emp> youngestThree = employees.stream()
                .sorted(Comparator.comparingInt(Emp::getAge))
                .limit(3).toList();

// 5. Skip top 2 oldest employees
        List<Emp> skipTopTwoOldest = employees.stream()
                .sorted(Comparator.comparingInt(Emp::getAge).reversed())
                .skip(2)
                .toList();

        // 1. Convert employees to Map<name, age>
        Map<String, Integer> nameToAgeMap = employees.stream()
                .collect(Collectors.toMap(Emp::getName, Emp::getAge));

// 2. Convert employees to Map<name, Emp>
        Map<String, Emp> nameToEmpMap = employees.stream()
                .collect(Collectors.toMap(
                        Emp::getName,
                        emp -> emp,
                        (existing, replacement) -> existing)); // handle duplicates

// 3. Convert to TreeMap (sorted by name)
        Map<String, Integer> sortedNameAgeMap = employees.stream()
                .collect(Collectors.toMap(
                        Emp::getName,
                        Emp::getAge,
                        (oldVal, newVal) -> oldVal,
                        TreeMap::new));

        // 1. Group employees by department
        Map<String, List<Emp>> employeesByDept = employees.stream()
                .collect(Collectors.groupingBy(Emp::getDep));

// 2. Group employees by location
        Map<String, List<Emp>> employeesByLocation = employees.stream()
                .collect(Collectors.groupingBy(Emp::getLocation));

// 3. Group employees by department and location
        Map<String, Map<String, List<Emp>>> deptAndLocation = employees.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDep,
                        Collectors.groupingBy(Emp::getLocation)
                ));

// 4. Count employees in each department
        Map<String, Long> countByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDep,
                        Collectors.counting()
                ));

// 5. Partition employees by age > 30
        Map<Boolean, List<Emp>> partitionedByAge = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getAge() > 30));

        //  ***********************************************************************************************************************
        // Complex Filtering & Mapping

        // 1. Find employees with same age and department
        Map<String, List<Emp>> sameAgeDept = employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.getAge() + "_" + emp.getDep()
                ))
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

// 2. Find employees working in same location but different departments
        Map<String, Map<String, List<Emp>>> locationDeptGroups = employees.stream()
                .collect(Collectors.groupingBy(
                        Emp::getLocation,
                        Collectors.groupingBy(Emp::getDep)
                ));

// 3. Find employees with duplicate names
        Map<String, Long> nameCounts = employees.stream()
                .collect(Collectors.groupingBy(Emp::getName, Collectors.counting()));

        List<String> duplicateNames = nameCounts.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

// 4. Find employees where name contains 'a' and age < 30
        List<Emp> complexFilter = employees.stream()
                .filter(emp -> emp.getName().toLowerCase().contains("a"))
                .filter(emp -> emp.getAge() < 30)
                .toList();

// 5. Find IT employees sorted by name descending
        List<Emp> itSortedDesc = employees.stream()
                .filter(emp -> "IT".equals(emp.getDep()))
                .sorted(Comparator.comparing(Emp::getName).reversed())
                .toList();

        // 1. Create comma-separated names by department
        Map<String, String> namesByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDep,
                        Collectors.mapping(Emp::getName, Collectors.joining(", "))
                ));

// 2. Get average age by department
        Map<String, Double> avgAgeByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDep,
                        Collectors.averagingInt(Emp::getAge)
                ));

// 3. Get department with maximum employees
        Optional<Map.Entry<String, Long>> maxDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDep,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

// 4. Get oldest employee in each department
        Map<String, Optional<Emp>> oldestByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDep,
                        Collectors.maxBy(Comparator.comparingInt(Emp::getAge))
                ));

// 5. Get total age by location
        Map<String, Integer> totalAgeByLocation = employees.stream()
                .collect(Collectors.groupingBy(
                        Emp::getLocation,
                        Collectors.summingInt(Emp::getAge)
                ));


        // Given nested list
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

// 1. Flatten nested list
        List<Integer> flattened = nestedList.stream()
                .flatMap(List::stream)
                .toList();

// 2. Get all unique characters from department names
        Set<Character> uniqueDeptChars = employees.stream()
                .map(Emp::getDep)
                .flatMap(dept -> dept.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toSet());

// 3. Get all vowels from employee names
        Set<Character> vowelsFromNames = employees.stream()
                .map(Emp::getName)
                .flatMap(name -> name.toLowerCase().chars()
                        .mapToObj(c -> (char) c)
                        .filter(c -> "aeiou".indexOf(c) != -1))
                .collect(Collectors.toSet());

// 4. Create pairs of employees from same department
        Map<String, List<List<Emp>>> employeePairsByDept = employees.stream()
                .collect(Collectors.groupingBy(Emp::getDep))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            List<Emp> deptEmployees = entry.getValue();
                            List<List<Emp>> pairs = new ArrayList<>();
                            for (int i = 0; i < deptEmployees.size(); i++) {
                                for (int j = i + 1; j < deptEmployees.size(); j++) {
                                    pairs.add(Arrays.asList(deptEmployees.get(i), deptEmployees.get(j)));
                                }
                            }
                            return pairs;
                        }
                ));


        // 1. Find total age of all employees
        int totalAge = employees.stream()
                .mapToInt(Emp::getAge)
                .sum();

// Alternative using reduce
        int totalAgeReduce = employees.stream()
                .map(Emp::getAge)
                .reduce(0, Integer::sum);

// 2. Find maximum age
        OptionalInt maxAge = employees.stream()
                .mapToInt(Emp::getAge)
                .max();

// 3. Find employee with longest name
        Optional<Emp> longestNameEmp = employees.stream()
                .max(Comparator.comparing(emp -> emp.getName().length()));

// 4. Concatenate all names with custom separator
        String allNames = employees.stream()
                .map(Emp::getName)
                .reduce((name1, name2) -> name1 + " | " + name2)
                .orElse("");

// Better approach
        String allNamesJoined = employees.stream()
                .map(Emp::getName)
                .collect(Collectors.joining(" | "));

// 5. Find second highest age
        Optional<Integer> secondHighestAge = employees.stream()
                .map(Emp::getAge)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();


        // 1. Parallel stream for heavy computations
        Map<String, Double> avgAgeByDeptParallel = employees.parallelStream()
                .collect(Collectors.groupingByConcurrent(
                        Emp::getDep,
                        Collectors.averagingInt(Emp::getAge)
                ));

// 2. Early termination with findFirst/findAny
        Optional<Emp> firstITEmployee = employees.stream()
                .filter(emp -> "IT".equals(emp.getDep()))
                .findFirst();

// 3. Using IntStream for primitive operations
        IntSummaryStatistics ageStats = employees.stream()
                .mapToInt(Emp::getAge)
                .summaryStatistics();

// 4. Optimized grouping with downstream collectors
        Map<String, IntSummaryStatistics> deptAgeStats = employees.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDep,
                        Collectors.summarizingInt(Emp::getAge)
                ));

//// 5. Using collectors.teeing() (Java 12+)
//        record AgeStats(double average, int max, int min) {}
//
//        Map<String, AgeStats> deptAgeStatistics = employees.stream()
//                .collect(Collectors.groupingBy(
//                        Emp::getDep,
//                        Collectors.teeing(
//                                Collectors.averagingInt(Emp::getAge),
//                                Collectors.maxBy(Comparator.comparingInt(Emp::getAge)),
//                                Collectors.minBy(Comparator.comparingInt(Emp::getAge)),
//                                (avg, maxOpt, minOpt) -> new AgeStats(
//                                        avg,
//                                        maxOpt.map(Emp::getAge).orElse(0),
//                                        minOpt.map(Emp::getAge).orElse(0)
//                                )
//                        )
//                ));


// 1. Find department with highest average age
        Optional<Map.Entry<String, Double>> deptHighestAvgAge = employees.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDep,
                        Collectors.averagingInt(Emp::getAge)
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

// 2. Find employees who are unique in their location
        List<Emp> uniqueInLocation = employees.stream()
                .collect(Collectors.groupingBy(Emp::getLocation))
                .values().stream()
                .filter(list -> list.size() == 1)
                .flatMap(List::stream)
                .toList();

// 3. Create a hierarchical structure
        record DepartmentSummary(String name, long employeeCount, double avgAge,
                                 List<String> employeeNames) {
        }

        List<DepartmentSummary> departmentSummaries = employees.stream()
                .collect(Collectors.groupingBy(Emp::getDep))
                .entrySet().stream()
                .map(entry -> {
                    List<Emp> deptEmployees = entry.getValue();
                    return new DepartmentSummary(
                            entry.getKey(),
                            deptEmployees.size(),
                            deptEmployees.stream().mapToInt(Emp::getAge).average().orElse(0),
                            deptEmployees.stream().map(Emp::getName).toList()
                    );
                })
                .toList();

// 4. Find most common age
        Optional<Map.Entry<Integer, Long>> mostCommonAge = employees.stream()
                .collect(Collectors.groupingBy(Emp::getAge, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());


        // 1. Using Stream.iterate for pagination
        int pageSize = 3;
        List<List<Emp>> pages = Stream.iterate(0, i -> i < employees.size(), i -> i + pageSize)
                .map(i -> employees.stream()
                        .skip(i)
                        .limit(pageSize)
                        .toList())
                .toList();

// 2. Creating a stream of sliding windows
        List<List<Emp>> slidingWindows = IntStream.range(0, employees.size() - 2)
                .mapToObj(i -> employees.subList(i, i + 3))
                .toList();

// 3. Using takeWhile/dropWhile (Java 9+)
        List<Emp> untilAge30 = employees.stream()
                .sorted(Comparator.comparingInt(Emp::getAge))
                .takeWhile(emp -> emp.getAge() <= 30)
                .toList();

        List<Emp> afterAge30 = employees.stream()
                .sorted(Comparator.comparingInt(Emp::getAge))
                .dropWhile(emp -> emp.getAge() <= 30)
                .toList();

// 4. Complex partitioning with multiple conditions
        enum AgeGroup {YOUNG, MID, SENIOR}

        Map<AgeGroup, List<Emp>> ageGroups = employees.stream()
                .collect(Collectors.groupingBy(emp -> {
                    if (emp.getAge() < 30) return AgeGroup.YOUNG;
                    else if (emp.getAge() < 40) return AgeGroup.MID;
                    else return AgeGroup.SENIOR;
                }));

        System.out.println("Age group " + ageGroups);

// 5. Stream of optional transformations
        List<String> transformedNames = employees.stream()
                .map(emp -> Optional.of(emp)
                        .filter(e -> e.getAge() > 25)
                        .map(Emp::getName)
                        .map(String::toUpperCase)
                        .orElse(null))
                .filter(Objects::nonNull)
                .toList();


        // 1. Employee roster generation by department and location
        Map<String, Map<String, List<String>>> roster = employees.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDep,
                        Collectors.groupingBy(
                                Emp::getLocation,
                                Collectors.mapping(Emp::getName, Collectors.toList())
                        )
                ));

// 2. Salary band calculation (assuming salary based on age and location)
        Map<String, Map<String, Double>> avgSalaryBand = employees.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDep,
                        Collectors.groupingBy(
                                emp -> {
                                    if (emp.getAge() < 30) return "Junior";
                                    else if (emp.getAge() < 40) return "Mid";
                                    else return "Senior";
                                },
                                Collectors.averagingDouble(emp ->
                                        emp.getAge() * 1000 *
                                                (emp.getLocation().equals("Mumbai") ? 1.2 :
                                                        emp.getLocation().equals("Bengaluru") ? 1.1 : 1.0)
                                )
                        )
                ));

// 3. Finding potential mentors (senior employees for junior ones)
        Map<Emp, List<Emp>> mentorSuggestions = employees.stream()
                .filter(emp -> emp.getAge() < 30)
                .collect(Collectors.toMap(
                        Function.identity(),
                        junior -> employees.stream()
                                .filter(senior ->
                                        !senior.equals(junior) &&
                                                senior.getDep().equals(junior.getDep()) &&
                                                senior.getAge() - junior.getAge() >= 5 &&
                                                senior.getLocation().equals(junior.getLocation())
                                )
                                .limit(3)
                                .toList()
                ));

// 4. Department health metrics
        record DepartmentHealth(String department, double avgAge,
                                double retentionRate, int diversityScore) {
        }

        List<DepartmentHealth> deptHealthMetrics = employees.stream()
                .collect(Collectors.groupingBy(Emp::getDep))
                .entrySet().stream()
                .map(entry -> {
                    List<Emp> deptEmployees = entry.getValue();
                    double avgAge = deptEmployees.stream()
                            .mapToInt(Emp::getAge).average().orElse(0);

                    long experienced = deptEmployees.stream()
                            .filter(emp -> emp.getAge() > 35).count();
                    double retentionRate = (double) experienced / deptEmployees.size();

                    int diversityScore = (int) deptEmployees.stream()
                            .map(Emp::getLocation)
                            .distinct()
                            .count();

                    return new DepartmentHealth(entry.getKey(), avgAge, retentionRate, diversityScore);
                })
                .toList();

        // 1. Debugging stream pipeline with peek()
        List<Emp> debugResult = employees.stream()
                .peek(emp -> System.out.println("Original: " + emp))
                .filter(emp -> emp.getAge() > 25)
                .peek(emp -> System.out.println("After age filter: " + emp))
                .sorted(Comparator.comparing(Emp::getName))
                .peek(emp -> System.out.println("After sorting: " + emp))
                .toList();

// 2. Logging intermediate results
        List<String> loggedResult = employees.stream()
                .map(emp -> {
                    String transformed = emp.getName().toUpperCase();
                    System.out.println("Transformed " + emp.getName() + " to " + transformed);
                    return transformed;
                })
                .toList();

// 3. Measuring stream performance
        long startTime = System.currentTimeMillis();
        List<Emp> result = employees.parallelStream()
                .filter(emp -> emp.getAge() > 30)
                .sorted(Comparator.comparing(Emp::getName))
                .toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + "ms");

// 4. Validating stream results
        Predicate<Emp> ageValidator = emp -> emp.getAge() >= 18 && emp.getAge() <= 65;
        boolean allValid = employees.stream()
                .allMatch(ageValidator);

        if (!allValid) {
            List<Emp> invalidEmployees = employees.stream()
                    .filter(ageValidator.negate())
                    .toList();
            System.out.println("Invalid employees: " + invalidEmployees);
        }

// 5. Generate employee similarity matrix
        Map<String, Map<String, Long>> similarityMatrix = employees.stream()
                .collect(Collectors.toMap(
                        Emp::getName,
                        emp -> employees.stream()
                                .filter(other -> !other.equals(emp))
                                .collect(Collectors.toMap(
                                        Emp::getName,
                                        other -> calculateSimilarity(emp, other)
                                ))
                ));


        // 1. Nested grouping with custom classifiers
        Map<String, Map<String, Map<Integer, List<Emp>>>> complexGrouping =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Emp::getDep,
                                Collectors.groupingBy(
                                        emp -> emp.getAge() < 30 ? "Young" :
                                                emp.getAge() < 40 ? "Mid" : "Senior",
                                        Collectors.groupingBy(
                                                emp -> Integer.valueOf(emp.getName().length() < 5 ? "Short" : "Long")
                                        )
                                )
                        ));

// 2. Group by calculated properties with caching
        Map<String, List<Emp>> groupingByPattern = employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> {
                            // Complex calculation with memoization
                            String key = emp.getName().charAt(0) +
                                    emp.getLocation().substring(0, 3) +
                                    (emp.getAge() / 10);
                            return "Pattern_" + key.hashCode() % 10;
                        }
                ));

// 3. Dynamic grouping based on runtime criteria
        List<Function<Emp, String>> groupingFunctions = Arrays.asList(
                Emp::getDep,
                emp -> String.valueOf(emp.getAge() / 10 * 10), // Age group by decade
                emp -> emp.getLocation().substring(0, 3)
        );

        Map<String, List<Emp>> dynamicGrouping = employees.stream()
                .collect(Collectors.groupingBy(emp ->
                        groupingFunctions.stream()
                                .map(fn -> fn.apply(emp))
                                .collect(Collectors.joining("_"))
                ));

        // 1. Group by multiple fields with composite key
        record CompositeKey(String dep, String location, int ageGroup) {
        }

        Map<CompositeKey, List<Emp>> compositeKeyGrouping = employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> new CompositeKey(
                                emp.getDep(),
                                emp.getLocation(),
                                (emp.getAge() / 10) * 10
                        )
                ));

// 2. Group by pattern matching in names
        Map<String, List<Emp>> namePatternGrouping = employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> {
                            String name = emp.getName().toLowerCase();
                            if (name.matches(".*[aeiou]{2,}.*")) return "DoubleVowel";
                            if (name.matches(".*[^aeiou]{3,}.*")) return "ConsonantCluster";
                            if (name.endsWith("a") || name.endsWith("i")) return "EndsWithVowel";
                            return "OtherPattern";
                        }
                ));

// 3. Group by location proximity (custom distance calculation)
        Map<String, List<Emp>> proximityGrouping = employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> {
                            // Group locations within 200km radius
                            Map<String, Integer> cityCoordinates = Map.of(
                                    "Bengaluru", 0, "Hyderabad", 500,
                                    "Mumbai", 800, "Chennai", 300, "Delhi", 1500
                            );
                            int baseCoord = cityCoordinates.getOrDefault(emp.getLocation(), 0);

                            return employees.stream()
                                    .filter(e -> Math.abs(cityCoordinates.getOrDefault(e.getLocation(), 0) - baseCoord) <= 200)
                                    .map(Emp::getLocation)
                                    .sorted()
                                    .findFirst()
                                    .orElse(emp.getLocation());
                        }
                ));

        // 1. Collecting to custom data structure with ordering
        TreeMap<String, TreeSet<Emp>> sortedGrouping = employees.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDep,
                        TreeMap::new,  // Sorted by department
                        Collectors.collectingAndThen(
                                Collectors.toCollection(
                                        () -> new TreeSet<>(Comparator.comparing(Emp::getName).reversed())
                                ),
                                set -> set
                        )
                ));

// 2. Grouping with statistical analysis
        record DeptStats(String dept, double avgAge, double stdDev,
                         int minAge, int maxAge, double median) {
        }

        Map<String, DeptStats> statisticalGrouping = employees.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDep,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    double avg = list.stream().mapToInt(Emp::getAge).average().orElse(0);
                                    double variance = list.stream()
                                            .mapToDouble(e -> Math.pow(e.getAge() - avg, 2))
                                            .average().orElse(0);
                                    List<Integer> sortedAges = list.stream()
                                            .map(Emp::getAge)
                                            .sorted()
                                            .toList();

                                    return new DeptStats(
                                            list.get(0).getDep(),
                                            avg,
                                            Math.sqrt(variance),
                                            sortedAges.get(0),
                                            sortedAges.get(sortedAges.size() - 1),
                                            sortedAges.size() % 2 == 0 ?
                                                    (sortedAges.get(sortedAges.size() / 2) + sortedAges.get(sortedAges.size() / 2 - 1)) / 2.0 :
                                                    sortedAges.get(sortedAges.size() / 2)
                                    );
                                }
                        )
                ));

// 3. Grouping with transitive closure (find connected components)
        Map<String, Set<Emp>> transitiveGrouping = employees.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDep,
                        Collectors.collectingAndThen(
                                Collectors.toSet(),
                                deptEmployees -> {
                                    // Find employees who share age group and location
                                    Set<Emp> connected = new HashSet<>();
                                    deptEmployees.forEach(emp1 -> {
                                        deptEmployees.forEach(emp2 -> {
                                            if (Math.abs(emp1.getAge() - emp2.getAge()) <= 5 &&
                                                    emp1.getLocation().equals(emp2.getLocation())) {
                                                connected.add(emp1);
                                                connected.add(emp2);
                                            }
                                        });
                                    });
                                    return connected;
                                }
                        )
                ));

        // 1. Tumbling windows (non-overlapping)
        int windowSize = 3;
        List<List<Emp>> tumblingWindows = IntStream.range(0, (employees.size() + windowSize - 1) / windowSize)
                .mapToObj(i -> employees.stream()
                        .skip((long) i * windowSize)
                        .limit(windowSize)
                        .collect(Collectors.toList()))
                .filter(list -> !list.isEmpty())
                .collect(Collectors.toList());

// 2. Sliding windows with overlap
        int slide = 2;
        List<List<Emp>> slidingWindowss = IntStream.range(0, employees.size() - windowSize + 1)
                .filter(i -> i % slide == 0)
                .mapToObj(i -> employees.subList(i, i + windowSize))
                .collect(Collectors.toList());

// 3. Session windows (group by continuous conditions)
        List<List<Emp>> sessionWindows = new ArrayList<>();
        List<Emp> currentSession = new ArrayList<>();

        for (Emp emp : employees) {
            if (currentSession.isEmpty() ||
                    (emp.getAge() - currentSession.get(currentSession.size() - 1).getAge() <= 2 &&
                            emp.getDep().equals(currentSession.get(0).getDep()))) {
                currentSession.add(emp);
            } else {
                sessionWindows.add(new ArrayList<>(currentSession));
                currentSession.clear();
                currentSession.add(emp);
            }
        }
        if (!currentSession.isEmpty()) {
            sessionWindows.add(currentSession);
        }

        // 1. Concurrent grouping with merge function
        ConcurrentMap<String, ConcurrentMap<String, Long>> concurrentGrouping =
                employees.parallelStream()
                        .collect(Collectors.groupingByConcurrent(
                                Emp::getDep,
                                Collectors.groupingByConcurrent(
                                        Emp::getLocation,
                                        ConcurrentHashMap::new,
                                        Collectors.counting()
                                )
                        ));

// 2. Parallel reduction with custom combiner
        class ComplexAccumulator {
            private double sumAge;
            private double sumAgeSquared;
            private int count;

            public void accept(Emp emp) {
                sumAge += emp.getAge();
                sumAgeSquared += emp.getAge() * emp.getAge();
                count++;
            }

            public ComplexAccumulator combine(ComplexAccumulator other) {
                this.sumAge += other.sumAge;
                this.sumAgeSquared += other.sumAgeSquared;
                this.count += other.count;
                return this;
            }

            public double getMean() {
                return sumAge / count;
            }

            public double getVariance() {
                return (sumAgeSquared / count) - Math.pow(getMean(), 2);
            }
        }

        ComplexAccumulator stats = employees.parallelStream()
                .collect(
                        ComplexAccumulator::new,
                        ComplexAccumulator::accept,
                        ComplexAccumulator::combine
                );

// 3. ForkJoinPool custom parallel processing
        ForkJoinPool customPool = new ForkJoinPool(8);
        Map<String, Double> customParallelResult = customPool.submit(() ->
                employees.parallelStream()
                        .collect(Collectors.groupingByConcurrent(
                                Emp::getDep,
                                Collectors.averagingInt(Emp::getAge)
                        ))
        ).join();
    }

    private static long calculateSimilarity(Emp emp1, Emp emp2) {
        long similarity = 0;
        if (emp1.getDep().equals(emp2.getDep())) similarity++;
        if (emp1.getLocation().equals(emp2.getLocation())) similarity++;
        if (Math.abs(emp1.getAge() - emp2.getAge()) <= 2) similarity++;
        return similarity;
    }
}