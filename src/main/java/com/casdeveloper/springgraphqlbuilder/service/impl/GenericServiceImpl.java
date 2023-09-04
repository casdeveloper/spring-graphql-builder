package com.casdeveloper.springgraphqlbuilder.service.impl;

import com.casdeveloper.springgraphqlbuilder.model.Department;
import com.casdeveloper.springgraphqlbuilder.model.Employee;
import com.casdeveloper.springgraphqlbuilder.repository.DepartmentRepository;
import com.casdeveloper.springgraphqlbuilder.repository.EmployeeRepository;
import com.casdeveloper.springgraphqlbuilder.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericServiceImpl implements GenericService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
