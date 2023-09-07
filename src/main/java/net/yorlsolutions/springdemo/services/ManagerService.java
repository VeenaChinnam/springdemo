package net.yorlsolutions.springdemo.services;

import net.yorlsolutions.springdemo.models.Manager;
import net.yorlsolutions.springdemo.repositories.EmployeeRepository;
import net.yorlsolutions.springdemo.repositories.ManageRepository;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    private final ManageRepository repository;
    private final EmployeeRepository employeeRepository;

    public ManagerService(ManageRepository repository, EmployeeRepository employeeRepository){
        this.repository = repository;
        this. employeeRepository=  employeeRepository;
    }

    //adding new manager
    public void addNewManager(String managersName){
        repository.save(new Manager(managersName));
    }
    public void addDirectReport(Long employee_id, Long manager_id){
        final var employee = employeeRepository. findById(employee_id).orElseThrow();
        final var manager = repository. findById(manager_id).orElseThrow();
        manager.reports.add(employee);
        repository.save(manager);
    }


    public Iterable<Manager>getAll(){
        return repository.findAll();
    }



}
