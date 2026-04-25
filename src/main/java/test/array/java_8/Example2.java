package test.array.java_8;

import java.util.*;
import java.util.stream.Collectors;

public class Example2 {

    public static void main(String[] args) {


        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        List<Integer> list = Arrays.asList(7, 8, 9, 20);
        String collect19 = list.stream().sorted((a, b) -> b - a).map(String::valueOf).collect(Collectors.joining(" "));
        //System.out.println(collect19);

        List<Emp> ems = List.of(

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

//A. filter()
//Find employees whose age > 30
        ems.stream().filter(e -> e.getAge() > 30).map(Emp::getName).forEach(System.out::println);

//Find employees from Bengaluru AND IT
        ems.stream().filter(x -> x.getLocation().equals("Bengaluru") && Objects.equals(x.getDep(), "IT")).forEach(System.out::println);

//Find employees not from HR

        LinkedHashMap<String, String> collect = ems.stream().filter(x -> x.getDep() != "HR").collect(Collectors.toMap(Emp::getName, Emp::getDep, (a, b) -> a, LinkedHashMap::new));
        System.out.println(collect);

        //Find employees whose name starts with "A"
        ems.stream().filter(x -> x.getName().startsWith("A")).forEach(System.out::println);
//B. map()
//Get only employee names

        String collect1 = ems.stream().map(Emp::getName).collect(Collectors.joining(" "));
        System.out.println(collect1);

//Get list of all locations

//Convert all employee names to uppercase

        ems.stream().map(Emp::getName).map(String::toUpperCase).forEach(System.out::println);
//Create a list of ages + 5

//Get department names in lowercase

//Distinct()
//Find unique departments
        ems.stream().map(Emp::getDep).distinct().forEach(System.out::println);
//Find unique locations

//Find unique ages

//Find distinct employee names print with space

//Find unique (department + location) combinations

        ems.stream().map(x -> x.getDep() + " " + x.getLocation()).distinct().forEach(System.out::println);
//🔹 D. sorted()
//Sort employees by age ascending

        ems.stream().map(Emp::getAge).sorted(Comparator.naturalOrder()).forEach(System.out::print);
        System.out.println("hi ");
        System.out.println();
        ems.stream().sorted(Comparator.comparingInt(Emp::getAge)).map(Emp::getName).forEach(System.out::print);
//Sort employees by age descending

//Sort employees by name
ems.stream().map(Emp::getName).sorted().forEach(System.out::println);

        ems.stream().sorted(Comparator.comparing(Emp::getName)).forEach(System.out::println);
        System.out.println(" Laxmikanat");
//Sort employees by department then age
ems.stream().sorted(Comparator.comparing(Emp::getDep).thenComparingInt(Emp::getAge)).forEach(System.out::println);
//Sort employees by location then name

//🔹 E. limit() & skip()
//Get first 3 employees

//Skip first 2 employees

//Get 2 employees after skipping first 3

//Get youngest 3 employees

//Skip top 2 oldest employees

//🔹 F. collect()
//Convert employees to Map<name, age>

//Convert employees to Map<name, Emp>

//🔹 G. groupingBy()
//Group employees by department

        ems.stream().collect(Collectors.groupingBy(Emp::getDep));
//Group employees by location

//Group employees by department and location

//Count employees in each department

//Find employees grouped by age > 30 or <= 30

//🔹 H. count()
//Count total employees

//Count employees from IT

//Count employees from Mumbai

//🔹 I. findFirst() & findAny()
//Find first employee from IT

//Find any employee from HR

//Find first employee older than 35

//Find any employee from Bengaluru

//Find first employee whose name starts with "R"

//🔹 J. anyMatch(), allMatch(), noneMatch()
//Check if any employee is from Delhi

//Check if all employees are above age 20

//Check if none are from USA

//Check if any employee belongs to Finance

//Check if all employees are from India locations

//🔹 K. reduce()
//Find sum of all ages

//Find maximum age

//Find minimum age

//Concatenate all employee names

//Find total age of IT employees

//🔹 L. min() & max()
//Find youngest employee

//Find oldest employee

//Find employee with lexicographically smallest name

//Find employee with longest name

//Find department with max employees

//🔹 M. Collectors Advanced
//Average age of employees

//Average age per department

//Employee count per location

//Max age per department

//Min age per department

//🔹 N. partitioningBy()
//Partition employees by age > 30

//Partition employees by IT vs Non-IT

//🔹 O. flatMap()
//Convert list of departments to unique characters

//Extract all characters from employee names

//Get unique vowels from all names

//🔹 R. Real Interview Combination Questions
//Second highest age employee

//Employees with duplicate ages

//Department having maximum employees

//Location with least employees

//Sort employees and pick top 3 by age

//🔹 S. Performance & Parallel Stream

//🔹 T. Bonus (Real-world)
//Map department → average age

//Find employees working in same location

//Remove duplicate employees

//Create CSV string of employee names

//Group and sort employees by age

//Find employee names by department

//Find youngest employee per location

//Find oldest employee per department

//Combine filter + map + reduce in one pipeline
    }
}
