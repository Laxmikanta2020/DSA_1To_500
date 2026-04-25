//package TestingJpa.service;
//
//import com.laxmi.TestingJpa.Entity.Department;
//import com.laxmi.TestingJpa.Entity.Employee;
//import com.laxmi.TestingJpa.dto.EmployeeRequest;
//import com.laxmi.TestingJpa.repo.DeptRepo;
//import com.laxmi.TestingJpa.repo.EmplyeeRepository;
//import jakarta.transaction.Transactional;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//public class TestingTransaction {
//    @Autowired
//    EmplyeeRepository emplyeeRepository;
//    @Autowired
//    DeptRepo departmentRepository;
//
//
//    @Transactional
//    public Employee saveEmployeeWithDeptT(EmployeeRequest employeeRequest) {
//
//        // Step 1: Create and save department
//        Department dept = new Department();
//        dept .setDname(employeeRequest.getDeptName());
//        dept .setDcode(employeeRequest.getDeptCode());
//
//        Department savedDept = departmentRepository.save(dept);
//        // Now: dept.did is auto-generated (e.g., 1, 2, 3...)
//        // Step 2: Create employee with saved department
//
//        Employee emp =  new Employee();
//        emp.setName(employeeRequest.getName());
//        emp.setAge(employeeRequest.getAge());
//        emp.setDep(savedDept);
//
//        // Now: emp.dep references valid department
//        // Step 3: Save employee
//        return emplyeeRepository.save(emp);
//        // No FK constraint violation!
//    }
//
//
//
//}
