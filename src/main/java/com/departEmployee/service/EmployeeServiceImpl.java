package com.departEmployee.service;

import com.departEmployee.model.Employee;
import com.departEmployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Iterable<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee getEmployeeById(long id) {
        return null;
    }

    @Override
    public void saveOrUpdateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(long id) {

    }

    @Override
    public Employee findByEmail(String email) {
        return null;
    }

    @Override
    public void deleteAllEmplForDepart(Long departID) {

    }

    @Override
    public List<Employee> employeeByDepartmentId(Long departmentId) {
        return null;
    }
}
