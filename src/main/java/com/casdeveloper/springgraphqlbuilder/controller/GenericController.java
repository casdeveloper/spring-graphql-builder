package com.casdeveloper.springgraphqlbuilder.controller;

import com.casdeveloper.springgraphqlbuilder.model.Department;
import com.casdeveloper.springgraphqlbuilder.model.Employee;
import com.casdeveloper.springgraphqlbuilder.repository.EmployeeRepository;
import com.casdeveloper.springgraphqlbuilder.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenericController {

    @Autowired
    GenericService genericService;

    @PostMapping("/addDepartment")
    ResponseEntity<Department> addDepartment(@RequestBody Department department){
        return ResponseEntity.ok(genericService.addDepartment(department));
    }


    @PostMapping("/addEmployee")
    ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(genericService.addEmployee(employee));
    }

    @GetMapping("/getAllDepartment")
    ResponseEntity<List<Department>> getAllDepartment(){
        return ResponseEntity.ok(genericService.getAllDepartment());
    }

    @GetMapping("/getAllEmployee")
    ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(genericService.getAllEmployee());
    }
}
