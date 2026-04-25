//package TestingJpa.Entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@Entity
//@Table(name = "employee")
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Employee {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ✓ Changed: AUTO → IDENTITY
//    @Column(name = "id")
//    private Integer id;  // ✓ Change: int → Integer
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @Column(name = "age")
//    private Integer age;  // ✓ Change: int → Integer
//
//    @OneToOne(
//            cascade = CascadeType.ALL,  // Keep PERSIST (not ALL)
//            fetch = FetchType.EAGER,
//            optional = false
//    )
//    @JoinColumn(
//            name = "D_id",
//            unique = true,
//            nullable = false,
//            referencedColumnName = "did"
//    )
//    private Department dep;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public Department getDep() {
//        return dep;
//    }
//
//    public void setDep(Department dep) {
//        this.dep = dep;
//    }
//}