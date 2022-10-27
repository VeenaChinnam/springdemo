package net.yorlsolutions.springdemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//by using Entity tells JPA to create a Table with the same name as this class
//and columns matching each field
//Class represents a table
//An object of this type represents a row in that table
public class Employee {
    public String name;
    public String role;

    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

//        (OR)
//    private Long id;
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @Id
//    public Long getId() {
//        return id;
//    }
}
