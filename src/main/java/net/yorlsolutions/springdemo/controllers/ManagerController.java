package net.yorlsolutions.springdemo.controllers;

import net.yorlsolutions.springdemo.models.Manager;
import net.yorlsolutions.springdemo.services.ManagerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {

    private final ManagerService service;

    public ManagerController(ManagerService service){
        this.service = service;
    }
    @PostMapping
    public void addNewManager(@RequestParam String managersName){
        service.addNewManager(managersName);
    }

    @PutMapping
    public void addDirectReport(@RequestParam Long manager_id, @RequestParam Long employee_id ){
        service.addDirectReport(employee_id, manager_id);
    }

    @GetMapping
    public Iterable<Manager>getAll(){
        return service.getAll();
    }
}
