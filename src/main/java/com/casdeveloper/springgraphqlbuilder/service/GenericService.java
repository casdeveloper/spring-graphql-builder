package com.casdeveloper.springgraphqlbuilder.service;

import com.casdeveloper.springgraphqlbuilder.model.Department;
import com.casdeveloper.springgraphqlbuilder.model.Employee;

import java.util.List;

public interface GenericService {

    Department addDepartment(Department department);
    Employee addEmployee(Employee employee);

    List<Department> getAllDepartment();
    List<Employee> getAllEmployee();
}
