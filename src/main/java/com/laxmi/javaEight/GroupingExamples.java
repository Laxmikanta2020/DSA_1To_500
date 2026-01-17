package com.laxmi.javaEight;

import java.util.*;
import java.util.stream.Collectors;


//import static java.util.stream.Collectors.groupingBy;

public class GroupingExamples {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("John", "New York", 25, 50000, "IT"),
                new Person("Jane", "London", 30, 60000, "HR"),
                new Person("Bob", "New York", 35, 70000, "IT"),
                new Person("Alice", "London", 28, 55000, "Finance"),
                new Person("Charlie", "Paris", 24, 80000, "IT"),
                new Person("Diana", "New York", 32, 65000, "HR")
        );

        //Grouping by dept
        Map<String, List<Person>> collectByDept = people.stream().collect(Collectors.groupingBy(Person::getDepartment));
        System.out.println(collectByDept);
        collectByDept.forEach((dept, name) -> System.out.println(dept + " " + name.stream().map(Person::getName).toList()));

        Map<String, List<String>> namesByDept = people.stream()
                .collect(Collectors.groupingBy(Person::getDepartment,
                        Collectors.mapping(Person::getName, Collectors.toList())));
        System.out.println(namesByDept);

        //grouping by condition

        Map<String, List<String>> groupByAgeRange = people.stream().collect(Collectors.groupingBy(p -> p.getAge() < 18 ? "Minor" :
                p.getAge() < 30 ? "Young" : p.getAge() < 40 ? "Senior" : "Old", Collectors.mapping(Person::getName, Collectors.toList())));

        System.out.println(groupByAgeRange);

        Map<String, List<Person>> peopleByAgeRange = people.stream()
                .collect(Collectors.groupingBy(person -> {
                    int age = person.getAge();
                    if (age < 30) return "Young";
                    else if (age < 40) return "Middle";
                    else return "Senior";
                }));
        System.out.println(peopleByAgeRange);
        Map<String, Long> countingByDept = people.stream().collect(Collectors.groupingBy(Person::getDepartment, Collectors.counting()));

        System.out.println("Count by City: " + countingByDept);
        //Max salary
        Map<String, Optional<Person>> highestPaidByDept = people.stream()
                .collect(Collectors.groupingBy(Person::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Person::getSalary))));
        System.out.println("By max salary " + highestPaidByDept);


        // 1. Simple partitioning by age
        Map<Boolean, List<Person>> partitionedByAge = people.stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() > 30));

        System.out.println("Partition by Age > 30:");
        System.out.println("Young (<=30): " + partitionedByAge.get(false));
        System.out.println("Old (>30): " + partitionedByAge.get(true));

        // counting each department

        Map<String, Long> countBydepartmenrt = people.stream().collect(Collectors.groupingBy(Person::getDepartment, Collectors.counting()));
        countBydepartmenrt.forEach((dep,id)->System.out.println(dep+" "+id));

        // get only name per department
        Map<String, List<String>> getNameBydept = people.stream().collect(Collectors.groupingBy(Person::getDepartment, Collectors.mapping(Person::getName, Collectors.toList())));

        getNameBydept.forEach((dep,name)->{System.out.println(dep+" "+name);});

        //Sum of salary of each department
        people.stream().collect(Collectors.groupingBy(Person::getDepartment,Collectors.summingDouble(Person::getSalary))).forEach((dep,sum)->System.out.println(dep+" "+sum));
        //Average salary of each dept
        people.stream().collect(Collectors.groupingBy(Person::getDepartment,Collectors.averagingDouble(Person::getSalary))).forEach((dep,avg)->System.out.println(dep+" "+avg));
    // min salary of each dept
        people.stream().collect(Collectors.groupingBy(Person::getDepartment,Collectors.minBy(Comparator.comparing(Person::getSalary))))
                .forEach((dep, person) ->
                System.out.println(dep + " " + person.map(Person::getName).orElse("N/A"))
        );
        // multiple grouping
        Map<String, Map<String, List<Person>>> multiGroping = people.stream().collect(Collectors.groupingBy(Person::getDepartment, Collectors.groupingBy(Person::getCity)));
        System.out.println(multiGroping);

    }
}