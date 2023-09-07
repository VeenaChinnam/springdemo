package net.yorlsolutions.springdemo.services;

import net.yorlsolutions.springdemo.models.Employee;
import net.yorlsolutions.springdemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository){
        this.repository = repository;

    }

    public void addNewEmployee(Employee employee) {
        repository.save(employee);
    }
    public void addNewEmployeeArray(Employee[] employee) {
//        for ( int i=0; i< employee.length; i++) {
//            repository.save(employee[i]);
//        }

        for (Employee emp : employee) {
            repository.save(emp);
        }
    }



    public Iterable<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<Employee> getById(Long id) {
        // null - references no object
        // null Reference Exception
        // Optional - to make it easy to write null safe code
        return repository.findById(id);
    }

    /**
     *
     * @param id
     * @return - true if the id was found and deleted, false otherwise
     */
    public boolean deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }



}
