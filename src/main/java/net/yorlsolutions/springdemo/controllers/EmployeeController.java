package net.yorlsolutions.springdemo.controllers;

import net.yorlsolutions.springdemo.models.Employee;
import net.yorlsolutions.springdemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

//    private final EmployeeRepository repository;
      private final EmployeeService service;

    // Bean - dependency that is available to be injected
    //      - an instance (an object) that is created/managed by spring

//    @Autowired
////    tell Spring which list to look at doing that by using @Autowired
////    telling spring to use this constructor,& this constructor argument list as the dependency for the object(controller)
//    public Controller(EmployeeRepository repository){
//        this.repository = repository;
//    }
//    @PostMapping
//    void addNewEmployee(@RequestBody Employee employee){
//        repository.save(employee);
//    }

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    void addNewEmployee(@RequestBody Employee employee) {
        service.addNewEmployee(employee);
    }

    @PostMapping("/Array")
    void addNewEmployee(@RequestBody Employee[] employee) {
        service.addNewEmployeeArray(employee);
    }

    @GetMapping
    Iterable<Employee> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    Employee getById(@PathVariable Long id) {
        return service
                .getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    String deleteById(@PathVariable Long id) {
        return service.deleteById(id) ? "Success" : "Fail";
    }


}
