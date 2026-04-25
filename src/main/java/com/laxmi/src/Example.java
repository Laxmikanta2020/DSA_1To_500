package com.laxmi.src;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {

    public static void main(String[] args) {


        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        List<Integer> list = Arrays.asList(7, 8, 9,20);
        String collect19 = list.stream().sorted((a, b) -> b - a).map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(collect19);

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

//Find all employees from IT department
        employees.stream().filter(dep -> dep.getDep().equals("IT")).collect(Collectors.toList());

        //A. filter()
//Find employees whose age > 30
        System.out.println("AA");
        employees.stream().filter(age -> age.getAge() > 30).map(Emp::getName).forEach(System.out::println);
        System.out.println("AA");
//Find employees from Bengaluru AND IT
        employees.stream().filter(emp -> emp.getLocation().equals("Bengaluru") && emp.getDep().equals("It")).forEach(System.out::print);
//Find employees not from HR
        employees.stream().filter(dep -> !Objects.equals(dep.getDep(), "HR")).forEach(System.out::print);
        employees.stream().filter(emp -> emp.getDep() != "HR").forEach(System.out::print);
//Find employees whose name starts with "A"
        employees.stream().filter(name -> name.getName().startsWith("A")).forEach(System.out::print);
        //B. map()
        //Get only employee names
        employees.stream().map(Emp::getName).forEach(System.out::print);
        //Get list of all locations
        List<String> collect = employees.stream().map(Emp::getLocation).toList();
        //Convert all employee names to uppercase
        employees.stream().map(name -> name.getName().toUpperCase()).collect(Collectors.toList());
        //Create a list of ages + 5
        employees.stream().map(age -> age.getAge() + 5).collect(Collectors.toList());
        //Get department names in lowercase
        employees.stream().map(dep -> dep.getDep().toLowerCase()).forEach(System.out::print);
        //Distinct()
        //Find unique departments
        employees.stream().map(Emp::getDep).distinct().forEach(System.out::print);
        //Find unique locations
        employees.stream().map(Emp::getLocation).collect(Collectors.toSet());
        //Find unique ages
        employees.stream().map(Emp::getAge).filter(Objects::nonNull).distinct().forEach(System.out::print);
        //Find distinct employee names print with space
        String collect1 = employees.stream().map(Emp::getName).distinct().collect(Collectors.joining(" "));
        System.out.println(collect1);
        //Find unique (department + location) combinations
        employees.stream().map(emp -> emp.getDep() + "_" + emp.getLocation()).distinct();
        employees.stream().map(emp -> Map.entry(emp.getDep(), emp.getLocation())).forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
        //🔹 D. sorted()
        //Sort employees by age ascending

        //Collections.sort(list);
        //Comparator.comparing();
        //**(a, b) -> b - a)**
        //**  String collect19 = list.stream().sorted((a, b) -> b - a).map(String::valueOf).collect(Collectors.joining(" "));
        employees.stream().sorted(Comparator.comparing(Emp::getAge)).forEach(System.out::println);
        System.out.println("***Sorterd");
        employees.stream().sorted(Comparator.comparing(Emp::getAge, Comparator.nullsLast(Integer::compareTo))).forEach(System.out::println);
        employees.stream().sorted(Comparator.comparing(Emp::getDep, Comparator.nullsLast(String::compareTo))).forEach(System.out::println);
        //Sort employees by age descending
        employees.stream().sorted(Comparator.comparingInt(Emp::getAge).reversed()).forEach(System.out::println);
        //Sort employees by name
        employees.stream().sorted(Comparator.comparing(Emp::getName)).forEach(System.out::println);
        //Sort employees by department then age
        employees.stream().sorted(Comparator.comparing(Emp::getDep).thenComparingInt(Emp::getAge)).forEach(System.out::println);
        //Sort employees by location then name
        employees.stream().sorted(Comparator.comparing(Emp::getLocation).thenComparing(Emp::getName)).collect(Collectors.toList());
//🔹 E. limit() & skip()
//Get first 3 employees
        List<Emp> collect2 = employees.stream().limit(3).collect(Collectors.toList());
//Skip first 2 employees
        employees.stream().skip(2).collect(Collectors.toList());
//Get 2 employees after skipping first 3
        employees.stream().skip(3).limit(2).collect(Collectors.toList());
//Get youngest 3 employees
        List<Emp> collect3 = employees.stream().sorted(Comparator.comparingInt(Emp::getAge)).limit(3).collect(Collectors.toList());
//Skip top 2 oldest employees
        List<Emp> collect4 = employees.stream().sorted(Comparator.comparingInt(Emp::getAge).reversed()).skip(2).collect(Collectors.toList());
//🔹 F. collect()

//Convert employees to Map<name, age>
        Map<String, Integer> collect5 = employees.stream().collect(Collectors.toMap(Emp::getName, Emp::getAge));
        Map<String, Integer> collect6 = employees.stream().collect(Collectors.toMap(Emp::getName, Emp::getAge, (age1, age2) -> age1));//Keeps the first age when names repeat.
        Map<String, List<String>> collect7 = employees.stream().collect(Collectors.groupingBy(Emp::getName, Collectors.mapping(Emp::getLocation, Collectors.toList())));//If you want multiple ages per name

        System.out.println(" COLLECT7");
        System.out.println(collect7);

        //Convert employees to Map<name, Emp>
        employees.stream().limit(1).collect(Collectors.toMap(Emp::getName, emp -> emp)).keySet().forEach(System.out::println);
        //System.out.println(collect8.entrySet().stream().map(Map.Entry::getKey));
//🔹 G. groupingBy()
        //Group employees by department
        Map<String, List<Emp>> collect9 = employees.stream().collect(Collectors.groupingBy(Emp::getDep));
//Group employees by location
        Map<String, List<Emp>> collect10 = employees.stream().collect(Collectors.groupingBy(Emp::getLocation));

//Group employees by department and location
        Map<String, Map<String, List<Emp>>> collect11 = employees.stream().collect(Collectors.groupingBy(Emp::getDep, Collectors.groupingBy(Emp::getLocation)));
//Count employees in each department
        Map<String, Long> collect12 = employees.stream().collect(Collectors.groupingBy(Emp::getDep, Collectors.counting()));
//Find employees grouped by age > 30 or <= 30
        Map<Boolean, List<Emp>> collect13 = employees.stream().collect(Collectors.partitioningBy(emp -> emp.age > 30));
        System.out.println(collect13.get(false));
//🔹 H. count()
//
//Count total employees
        Long collect14 = (long) employees.size();
//Count employees from IT
        Long it = employees.stream().filter(x->x.getDep().equals("IT")).count();
        System.out.println(it);
//Count employees from Mumbai
        long mumbai = employees.stream().filter(e -> Objects.equals(e.getLocation(), "Mumbai")).count();

//🔹 I. findFirst() & findAny()

//Find first employee from IT
        Optional<Emp> it1 = employees.stream().filter(emp -> emp.getDep().equals("IT")).findFirst();
//Find any employee from HR
        employees.stream().filter(emp -> Objects.equals(emp.getDep(), "HR")).findAny();
//Find first employee older than 35
        employees.stream().filter(x -> x.getAge() > 35).findFirst();
//Find any employee from Bengaluru
        employees.stream().filter(emp -> emp.getLocation().equals("Bengalure")).findAny();
//Find first employee whose name starts with "R"
        Optional<Emp> r = employees.stream().filter(x -> x.getName().startsWith("R")).findFirst();

//🔹 J. anyMatch(), allMatch(), noneMatch()
//
//Check if any employee is from Delhi
        boolean delhi = employees.stream().anyMatch(emp -> emp.getLocation().equals("Delhi"));
        boolean delhi1 = employees.stream().anyMatch(emp -> Objects.equals(emp.location,"Delhi"));
//Check if all employees are above age 20
        boolean b = employees.stream().allMatch(x -> x.getAge() > 25);
//Check if none are from USA
        boolean usa = employees.stream().noneMatch(x -> x.getLocation().equals("USA"));
//Check if any employee belongs to Finance
        boolean finance = employees.stream().anyMatch(x -> x.getDep().equals("Finance"));
//Check if all employees are from India locations
        boolean india = employees.stream().allMatch(loc -> loc.getLocation().equals("India"));
//🔹 K. reduce()
//
//Find sum of all ages
        Integer reduce = employees.stream().mapToInt(Emp::getAge).reduce(0, Integer::sum);
        employees.stream().mapToInt(Emp::getAge).sum();
//Find maximum age
        OptionalInt max = employees.stream().mapToInt(Emp::getAge).max();
        Optional<Emp> max3 = employees.stream().max(Comparator.comparing(Emp::getAge));
        employees.stream().max(Comparator.comparing(Emp::getAge).reversed());


//Find minimum age
        Optional<Integer> reduce1 = employees.stream().map(x -> x.getAge()).reduce(Integer::min);
//Concatenate all employee names
        employees.stream().map(Emp::getName).reduce("", (x, y) -> x + y);
        employees.stream().map(Emp::getName).collect(Collectors.joining(","));
//Find total age of IT employees
        employees.stream().filter(x -> x.getDep().equals("IT")).mapToInt(Emp::getAge).sum();
        employees.stream().filter(x -> x.getDep().equals("IT")).mapToInt(Emp::getAge).reduce(0, Integer::sum);
//🔹 L. min() & max()
//
//Find youngest employee
        Stream<Emp> limit1 = employees.stream().sorted(Comparator.comparing(Emp::getAge)).limit(1);
        Optional<Emp> min = employees.stream().min(Comparator.comparing(Emp::getAge));
        Stream<Integer> limit = employees.stream().map(Emp::getAge).sorted().limit(1);
        Optional<Integer> reduce2 = employees.stream().map(Emp::getAge).reduce(Integer::min);
//Find oldest employee
        employees.stream().max(Comparator.comparing(Emp::getAge).reversed());
//Find employee with lexicographically smallest name
        employees.stream().min(Comparator.comparing(Emp::getName));
        employees.stream().map(Emp::getName).min(String::compareTo);
//Find employee with longest name
        employees.stream().map(Emp::getName).max(String::compareTo);
        employees.stream().max(Comparator.comparing(e -> e.getName().length()));
        int maxLen = 0;
        List<Emp> longestNames = employees.stream()
                .filter(e -> e.getName().length() == maxLen)
                .toList(); //

        employees.stream().mapToInt(emp -> emp.getName().length()).max();
        Optional<Emp> collect15 = employees.stream().collect(Collectors.maxBy(Comparator.comparing(emp -> emp.getName().length())));
        employees.stream().reduce((x, y) -> x.getName().length() > y.getName().length() ? x : y);
        employees.stream().sorted(Comparator.comparing(emp -> emp.getName().length())).findFirst();
        employees.stream().map(Emp::getName).max(Comparator.comparing(String::length));
//Find department with max employees

        Optional<Map.Entry<String, Long>> max1 = employees.stream().collect(Collectors.groupingBy(Emp::getDep, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue());
        Optional<Map.Entry<String, Long>> max2 = employees.stream().collect(Collectors.groupingBy(Emp::getDep, Collectors.counting())).entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue));
//🔹 M. Collectors Advanced
//
//Average age of employees
        employees.stream().collect(Collectors.averagingInt(Emp::getAge));
        employees.stream().collect(Collectors.groupingBy(Emp::getDep, Collectors.averagingInt(Emp::getAge)));
//Average age per department
//
//Employee count per location
        employees.stream().collect(Collectors.groupingBy(Emp::getLocation, Collectors.counting()));
//Max age per department
        employees.stream().collect(Collectors.groupingBy(Emp::getDep, Collectors.maxBy(Comparator.comparing(Emp::getAge))));
//Min age per department
        Map<String, Integer> collect16 = employees.stream().collect(Collectors.toMap(Emp::getDep, Emp::getAge, Integer::max));
//🔹 N. partitioningBy()
//
//Partition employees by age > 30
        employees.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 30));
//Partition employees by IT vs Non-IT
        Map<Boolean, List<Emp>> it2 = employees.stream().collect(Collectors.partitioningBy(e -> e.getDep().equals("IT")));

        it2.get(true);
        it2.get(false);
//
//🔹 O. flatMap()
//
//Convert list of departments to unique characters

        employees.stream().map(Emp::getDep).flatMap(dep -> dep.chars().mapToObj(c -> (char) c)).distinct();
        employees.stream().flatMap(emp -> emp.getDep().chars().mapToObj(c -> (char) c)).distinct();

//Extract all characters from employee names
        List<Character> collect17 = employees.stream().flatMap(emp -> emp.getName().chars().mapToObj(name -> (char) name)).collect(Collectors.toList());
        employees.stream().map(Emp::getName).flatMap(e -> e.chars().mapToObj(c -> (char) c)).collect(Collectors.toList());
//Get unique vowels from all names
        employees.stream().map(emp -> emp.getName()).flatMap(e -> e.chars().mapToObj(c -> (char) c)).filter(ch -> "aeiou".contains(ch.toString()))
                .distinct()
                .sorted()
                .toList();


//🔹 R. Real Interview Combination Questions
//
//Second highest age employee
        employees.stream().sorted(Comparator.comparing(Emp::getAge).reversed()).skip(1).limit(1);
//Employees with duplicate ages

        Map<String, Long> collect18 = employees.stream().collect(Collectors.groupingBy(Emp::getDep, Collectors.counting()));

        collect18.entrySet().stream().filter(x -> x.getValue() > 1).collect(Collectors.toSet());
        collect18.entrySet().stream().max(Map.Entry.comparingByValue());

//Department having maximum employees
        employees.stream().collect(Collectors.groupingBy(Emp::getDep, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue());
//Location with least employees
        employees.stream().collect(Collectors.groupingBy(Emp::getLocation, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue());
//Sort employees and pick top 3 by age
        employees.stream().sorted(Comparator.comparing(Emp::getAge).reversed()).limit(3);
//🔹 S. Performance & Parallel Stream
        employees.parallelStream().collect(Collectors.toSet());

//🔹 T. Bonus (Real-world)
//
//Map department → average age
        employees.stream().collect(Collectors.groupingBy(Emp::getDep, Collectors.averagingInt(Emp::getAge)));
//Find employees working in same location
        employees.stream().collect(Collectors.groupingBy(Emp::getLocation, Collectors.counting()));

//Remove duplicate employees
        employees.stream().collect(Collectors.toSet());
//Create CSV string of employee names
        employees.stream().collect(Collectors.mapping(Emp::getName, Collectors.joining(" ")));
//Group and sort employees by age
        employees.stream().collect(Collectors.groupingBy(Emp::getAge)).entrySet().stream().sorted();


//Find employee names by department
        Map<String, String> collect8 = employees.stream().collect(Collectors.groupingBy(Emp::getDep, Collectors.mapping(Emp::getName, Collectors.joining(" "))));
//Find youngest employee per location
//
//Find oldest employee per department
        employees.stream().collect(Collectors.groupingBy(Emp::getDep, Collectors.maxBy(Comparator.comparing(Emp::getAge))));
//Combine filter + map + reduce in one pipeline
    }
}
