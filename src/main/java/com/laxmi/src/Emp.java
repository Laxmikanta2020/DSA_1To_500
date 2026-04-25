package com.laxmi.src;

public class Emp {
    String name ;

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dep='" + dep + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    int age ;
    String dep;
    String location;

    public Emp(String name, int age, String dep, String location) {
        this.name = name;
        this.age = age;
        this.dep = dep;
        this.location = location;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
