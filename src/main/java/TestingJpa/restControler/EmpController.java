//package TestingJpa.restControler;
//
//import com.laxmi.TestingJpa.Entity.Employee;
//import com.laxmi.TestingJpa.dto.EmployeeRequest;
//import com.laxmi.TestingJpa.repo.DeptRepo;
//import com.laxmi.TestingJpa.service.EmpService;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.concurrent.CompletableFuture;
//
//import static org.springframework.http.HttpStatus.CREATED;
//import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
//
//@Tag(name = "Employee", description = "Employee Management APIs")
//@RestController("Emp")
//public class EmpController {
//
//
//    @Autowired
//    private EmpService empService;
//    @Autowired
//    DeptRepo departmentRepository;
//
////    @PostMapping("/save")
////    public ResponseEntity<Employee> saveEmploye(@RequestBody Employee employee) {
////
////        System.out.println(employee);
////        // System.out.println(employee.getId());
////        Employee employee1 = empService.saveEmploye(employee);
////        return ResponseEntity.ok(employee1);
////    }
//
//    @PostMapping("/supplyAsync/save")
//    public CompletableFuture<ResponseEntity<Employee>> saveEmployeeBySupplyAsync(
//            @RequestBody Employee employee) {
//        return empService.saveEmployeeBySupplyAsync(employee)
//                .thenApply(saved -> ResponseEntity.status(CREATED).body(saved))
//                .exceptionally(ex -> ResponseEntity.status(INTERNAL_SERVER_ERROR).build());
//    }
//
//    @PostMapping("/Async/save")
//    public CompletableFuture<ResponseEntity<Employee>> saveEmployeeByAsync(
//            @RequestBody Employee employee) {
//        return empService.saveEmployeeAsync(employee)
//                .thenApply(ResponseEntity::ok);
//    }
//
//    @PostMapping("/employees")
//    public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequest request) {
//        Employee employee = empService.saveEmployeeWithDept(request);
//        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
//
//    }
//
//}
//
