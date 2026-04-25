package com.laxmi.src.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestJava8 {
    public static void main(String[] args) {
        List<Employee> employees = Employee.getSampleEmployees();

//Basic Operations:
//
//Get all active employees
        Set<String> collect = employees.stream().filter(Employee::isActive).map(Employee::getName).collect(Collectors.toSet());
        System.out.println(collect);
//Find employees whose salary is greater than 50000
        List<Employee> collect1 = employees.stream().filter(emp -> emp.getSalary() > 5000).collect(Collectors.toList());
        System.out.println(collect1);
//Get names of all employees in IT department
        employees.stream().filter(employee -> employee.getDepartment().equals(Employee.Department.IT)).map(Employee::getName).forEach(System.out::println);
//Find employees from 'New York' city
        employees.stream().filter(employee -> Objects.equals(employee.getCity(), "New York")).map(Employee::getName).forEach(System.out::println);

//Get distinct department names from all employees
        employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
//Intermediate Operations:
//6. Get first 5 employees sorted by salary (descending)
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(5).forEach(System.out::println);
//7. Skip first 3 employees and get next 5
        employees.stream().sorted(Comparator.comparing(Employee::getSalary)).skip(3).limit(5).forEach(System.out::println);
//8. Find if any employee has salary > 100000
        Optional<Employee> any = employees.stream().filter(e -> e.getSalary() > 100000).findAny();
        System.out.println(any.get());
//9. Check if all employees are active
        boolean bb = employees.stream().allMatch(Employee::isActive);
        System.out.println(bb);
//10. Find employee with name "John"
        employees.stream().filter(e -> e.getName().equals("John")).forEach(System.out::println);
//Mapping Operations:
//11. Create a list of employee names in uppercase
        employees.stream().map(Employee::getName).map(String::toUpperCase).forEach(System.out::println);
//12. Get all unique skills from all employees
        employees.stream().map(Employee::getSkills).flatMap(List::stream).distinct().forEach(System.out::println);
        employees.stream().flatMap(e -> e.getSkills().stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((key, value) -> System.out.println(key + " " + value));
//13. Create map of employee id to employee name

        employees.stream().collect(Collectors.toMap(Employee::getId, Employee::getName, (a, b) -> a));
//14. Get total salary of all employees
        var sum = employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(sum);
//15. Get average age of employees
        employees.stream().mapToLong(Employee::getAge).average();
//Aggregation Operations:
//16. Find highest paid employee
//17. Find employee with minimum experience
//18. Count number of employees in each department
//19. Get sum of bonus for active employees
//20. Find average salary of male vs female employees
//
//Complex Operations:
//21. Group employees by department
//22. Group employees by city
//23. Partition employees by salary > 75000
//24. Get department-wise average salary
//25. Get city-wise employee count
//
//SECTION 2: OPTIONAL
//Safely get employee name by ID (return "Not Found" if not exists)
//
//Find employee by name and if found, convert name to uppercase
//
//Chain multiple Optional operations: find employee, get department, convert to uppercase
//
//Create method that returns Optional<Employee> for given ID
//
//Handle null employee list gracefully using Optional
//
//SECTION 3: LAMBDA EXPRESSIONS
//Sort employees by name using lambda
//
//Sort employees by salary then by age using lambda
//
//Create Runnable using lambda to print all employee names
//
//Create Comparator using lambda for reverse salary sorting
//
//Use lambda with forEach to print employee details
//
//SECTION 4: METHOD REFERENCES
//Sort employees by name using method reference
//
//Print all employee names using method reference
//
//Convert list of employees to list of names using method reference
//
//Create supplier for new ArrayList using method reference
//
//Use method reference in map to get employee ages
//
//SECTION 5: FUNCTIONAL INTERFACES
//Use Predicate to filter employees older than 30
//
//Use Function to create email from employee name
//
//Use Consumer to give 10% raise to all employees
//
//Use Supplier to create new Employee object
//
//Use BiFunction to calculate tax based on salary and age
//
//SECTION 6: DATE/TIME API
//Find employees who joined in last 2 years
//
//Calculate experience of each employee in years
//
//Find employees who joined in 2023
//
//Sort employees by joining date (newest first)
//
//Group employees by joining year
//
//SECTION 7: COLLECTORS ADVANCED
//Create comma-separated string of all employee names
//
//Get department with maximum employees
//
//Get highest paid employee from each department
//
//Get average salary by gender
//
//Create map of department to list of employee names
//
//SECTION 8: PARALLEL STREAMS
//Calculate total salary using parallel stream
//
//Find any employee from IT department using parallel stream
//
//Process employee data (simulate heavy operation) using parallel stream
//
//Compare performance of sequential vs parallel stream
//
//Use parallel stream to group employees by city
//
//SECTION 9: CUSTOM OPERATIONS
//Create custom collector to concatenate all employee names
//
//Create custom functional interface for employee validation
//
//Implement a method that uses reduce to concatenate all names
//
//Create stream pipeline that filters, maps, and collects in one line
//
//Chain multiple predicates using and/or
//
//SECTION 10: REAL-WORLD SCENARIOS
//Salary Increment: Give 15% raise to all IT department employees
//
//Promotion Criteria: Find employees eligible for promotion (salary > 70000 and experience > 3 years)
//
//Department Budget: Calculate total budget (salary + bonus) for each department
//
//Skill Analysis: Find most common skill among employees
//
//Location Analysis: Find city with highest average salary
//
//Gender Diversity: Calculate gender ratio in each department
//
//Experience Analysis: Group employees by experience brackets (0-2, 3-5, 5+ years)
//
//Salary Bands: Categorize employees by salary ranges (<50k, 50k-80k, >80k)
//
//Top Performers: Get top 3 employees by total compensation (salary + bonus)
//
//Team Formation: Create cross-functional teams with at least one person from each skill set
//
//SECTION 11: COMPLEX CHALLENGES
//Find employee with second highest salary
//
//Get employees who have all given skills (Java, Spring)
//
//Find department where average salary is greater than company average
//
//Get employees who share same skills
//
//Find youngest employee in each department
//
//Calculate salary increment percentage year-over-year
//
//Find employees who are due for appraisal (joined more than 1 year ago)
//
//Create a summary report with department statistics
//
//Find employees with unique skills (skills no one else has)
//
//Implement pagination: get page 2 with 5 employees sorted by name
//
//SECTION 12: ERROR HANDLING & EDGE CASES
//Handle null values in employee list
//
//Handle empty department names
//
//Process stream with potential division by zero
//
//Handle duplicate employee IDs
//
//Handle concurrent modification while streaming
//
//SECTION 13: PERFORMANCE OPTIMIZATION
//When to use parallel streams vs sequential
//
//Optimize stream pipeline for large datasets
//
//Use primitive streams (IntStream) for better performance
//
//Avoid side-effects in stream operations
//
//Choose right collection for stream source
//
//SECTION 14: COMPARATIVE QUESTIONS
//Difference between map() and flatMap()
//
//Difference between findFirst() and findAny()
//
//When to use reduce() vs collect()
//
//Difference between Stream.of() and Arrays.stream()
//
//Compare Optional.orElse() vs orElseGet()
    }
}
