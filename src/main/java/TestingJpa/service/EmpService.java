//package TestingJpa.service;
//
//import com.laxmi.TestingJpa.Entity.Department;
//import com.laxmi.TestingJpa.Entity.Employee;
//import com.laxmi.TestingJpa.dto.EmployeeRequest;
//import com.laxmi.TestingJpa.repo.DeptRepo;
//import com.laxmi.TestingJpa.repo.EmplyeeRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.Executor;
//@Slf4j
//@Service
//public class EmpService {
//
//    @Autowired
//    EmplyeeRepository emplyeeRepository;
//    @Autowired
//    DeptRepo departmentRepository;
//
//    @Autowired
//    @Qualifier("LAXMI")
//    private Executor laxmiExecutor;
//
//    public Employee saveEmployeeWithDept(EmployeeRequest employeeRequest) {
//
//        // Step 1: Create and save department
//        Department dept = new Department();
//        dept .setDname(employeeRequest.getDeptName());
//        dept .setDcode(employeeRequest.getDeptCode());
//
//        Department savedDept = departmentRepository.save(dept);
//        // Now: dept.did is auto-generated (e.g., 1, 2, 3...)
//
//        // Step 2: Create employee with saved department
//        Employee emp =  new Employee();
//                emp.setName(employeeRequest.getName());
//                emp.setAge(employeeRequest.getAge());
//                emp.setDep(savedDept);
//
//        // Now: emp.dep references valid department
//
//        // Step 3: Save employee
//        return emplyeeRepository.save(emp);
//        // No FK constraint violation!
//    }
//
//    @Async("LAXMI")  // Use the executor named "LAXMI"
//    public CompletableFuture<Employee> saveEmployeeAsync(Employee employee) {
//        Employee saved = emplyeeRepository.save(employee);
//        return CompletableFuture.completedFuture(saved);
//    }
//    public CompletableFuture<Employee> saveEmployeeBySupplyAsync(Employee employee){
//
//        //CompletableFuture.supplyAsync(()->  emplyeeRepository.save(employee)); it work but we do not have any control
//   return CompletableFuture.supplyAsync(()->  emplyeeRepository.save(employee),laxmiExecutor)
//            .exceptionally(ex -> {
//              //  log.error("Save failed: {}", ex.getMessage());
//                throw new RuntimeException("Failed to save", ex);
//            });
//    }
//}
