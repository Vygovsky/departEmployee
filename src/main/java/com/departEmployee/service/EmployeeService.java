package com.departEmployee.service;

import com.departEmployee.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Iterable<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long id);

    void saveOrUpdateEmployee(Employee employee);

    void deleteEmployee(Long id);

    Employee findByEmail(String email);

    void deleteAllEmplForDepart(Long departID);

    List<Employee> employeeByDepartmentId(Long departmentId);


}
