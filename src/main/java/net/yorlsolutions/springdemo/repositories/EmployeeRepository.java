package net.yorlsolutions.springdemo.repositories;

import net.yorlsolutions.springdemo.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

//    CrudRepository is a parent child relationship
//     extends CrudRepository<Employee, Long> - manages Employee table ,
//
//     extends - access to  all the functions in the EmployeeRepository using interface
//

}
