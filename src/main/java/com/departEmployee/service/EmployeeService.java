package com.departEmployee.service;

import com.departEmployee.model.Employee;

import java.util.List;

public interface EmployeeService {

    Iterable <Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    void saveOrUpdateEmployee(Employee employee);

    void deleteEmployee(long id);

    Employee findByEmail(String email);

    void deleteAllEmplForDepart(Long departID);

    List<Employee> employeeByDepartmentId(Long departmentId);
}
