package com.laxmi.javaEight.sort;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private Department department;
    private LocalDate joiningDate;
    private List<String> skills;
    private int age;
    private String gender;
    private String city;
    private boolean active;
    private double bonus;
    private int experienceYears;

    public enum Department {
        IT, HR, FINANCE, MARKETING, SALES, OPERATIONS
    }

    // Constructor
    public Employee(int id, String name, double salary, Department department,
                    LocalDate joiningDate, List<String> skills, int age,
                    String gender, String city, boolean active, double bonus) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.joiningDate = joiningDate;
        this.skills = skills;
        this.age = age;
        this.gender = gender;
        this.city = city;
        this.active = active;
        this.bonus = bonus;
        this.experienceYears = Period.between(joiningDate, LocalDate.now()).getYears();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public List<String> getSkills() {
        return skills;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public boolean isActive() {
        return active;
    }

    public double getBonus() {
        return bonus;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    // Utility methods
    public double getTotalCompensation() {
        return salary + bonus;
    }

    public boolean hasSkill(String skill) {
        return skills.stream().anyMatch(s -> s.equalsIgnoreCase(skill));
    }

    public boolean isSenior() {
        return experienceYears >= 5;
    }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', salary=%.2f, dept=%s, age=%d, " +
                        "city='%s', skills=%s, experience=%d years}",
                id, name, salary, department, age, city, skills, experienceYears);
    }

    // Factory method to create sample employees
    public static List<Employee> getSampleEmployees() {
        return Arrays.asList(
                new Employee(1, "John Doe", 75000, Department.IT,
                        LocalDate.of(2020, 6, 15),
                        Arrays.asList("Java", "Spring", "SQL"), 28, "Male", "New York", true, 5000),

                new Employee(2, "Jane Smith", 82000, Department.HR,
                        LocalDate.of(2018, 3, 10),
                        Arrays.asList("Recruitment", "Communication", "HRMS"), 32, "Female", "Chicago", true, 6000),

                new Employee(3, "Bob Johnson", 68000, Department.FINANCE,
                        LocalDate.of(2021, 1, 20),
                        Arrays.asList("Excel", "Accounting", "Tax"), 25, "Male", "Boston", true, 4000),

                new Employee(4, "Alice Williams", 95000, Department.IT,
                        LocalDate.of(2015, 8, 5),
                        Arrays.asList("Java", "Microservices", "AWS", "Docker"), 35, "Female", "San Francisco", true, 10000),

                new Employee(5, "Charlie Brown", 55000, Department.SALES,
                        LocalDate.of(2022, 11, 30),
                        Arrays.asList("Negotiation", "CRM", "Communication"), 23, "Male", "Austin", true, 3000),

                new Employee(6, "Diana Prince", 88000, Department.MARKETING,
                        LocalDate.of(2019, 4, 22),
                        Arrays.asList("SEO", "Social Media", "Analytics"), 30, "Female", "Los Angeles", true, 7000),

                new Employee(7, "Ethan Hunt", 72000, Department.IT,
                        LocalDate.of(2020, 9, 12),
                        Arrays.asList("Python", "ML", "Data Analysis"), 29, "Male", "Seattle", false, 4500),

                new Employee(8, "Fiona Gallagher", 78000, Department.OPERATIONS,
                        LocalDate.of(2017, 7, 18),
                        Arrays.asList("Project Management", "Lean", "Six Sigma"), 34, "Female", "Denver", true, 5500),

                new Employee(9, "George Miller", 105000, Department.IT,
                        LocalDate.of(2014, 2, 28),
                        Arrays.asList("Java", "Kubernetes", "React", "Node.js"), 40, "Male", "New York", true, 12000),

                new Employee(10, "Hannah Baker", 92000, Department.HR,
                        LocalDate.of(2016, 12, 1),
                        Arrays.asList("Training", "Compensation", "Employee Relations"), 37, "Female", "Chicago", false, 8000),

                new Employee(11, "Ian Curtis", 65000, Department.SALES,
                        LocalDate.of(2023, 2, 14),
                        Arrays.asList("Salesforce", "Presentation"), 22, "Male", "Miami", true, 3500),

                new Employee(12, "Julia Roberts", 89000, Department.MARKETING,
                        LocalDate.of(2018, 10, 8),
                        Arrays.asList("Content Marketing", "Branding"), 31, "Female", "New York", true, 6500)
        );
    }
}