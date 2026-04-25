//package TestingJpa.Entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@Entity
//@Table(name = "department")
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Department {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ✓ ADD THIS
//    @Column(name = "did")
//    private Integer did;  // ✓ Change: int → Integer
//
//    @Column(name = "dname")
//    private String dname;
//
//    @Column(name = "dcode")
//    private Integer dcode;  // ✓ Change: int → Integer
//
//    @OneToOne(mappedBy = "dep", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonIgnore
//    private Employee employee;
//
//    public Integer getDid() {
//        return did;
//    }
//
//    public void setDid(Integer did) {
//        this.did = did;
//    }
//
//    public String getDname() {
//        return dname;
//    }
//
//    public void setDname(String dname) {
//        this.dname = dname;
//    }
//
//    public Integer getDcode() {
//        return dcode;
//    }
//
//    public void setDcode(Integer dcode) {
//        this.dcode = dcode;
//    }
//
//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
//}
