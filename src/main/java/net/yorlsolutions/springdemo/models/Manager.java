package net.yorlsolutions.springdemo.models;

import javax.persistence.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Manager {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public String name;

//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @Id
//    public Long getId() {
//        return id;
//    }


    @OneToMany
    public Set<Employee> reports;

    public Manager(String name){
        this.name = name;
    }
    public Manager(){

    }
//    set-just like a list, except
//    [1,2,3] is a set
//    [1,2,1] is not a set
}
