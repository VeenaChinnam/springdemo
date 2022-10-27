package net.yorlsolutions.springdemo;

import net.yorlsolutions.springdemo.models.Employee;
import net.yorlsolutions.springdemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class Controller {

    private final EmployeeRepository repository;

    @Autowired
//    tell Spring which list to look at doing that by using @Autowired
//    telling spring to use this constructor,& this constructor argument list as the dependency for the object(controller)
    public Controller(EmployeeRepository repository){
        this.repository = repository;
    }
    @PostMapping
    void addNewEmployee(@RequestBody Employee employee){
        repository.save(employee);
    }


}
