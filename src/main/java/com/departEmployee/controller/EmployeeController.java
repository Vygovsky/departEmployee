package com.departEmployee.controller;

import com.departEmployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping(value = "/listEmployee/departmentId/{id}", method = RequestMethod.GET)
    public String getAllListDepart(@PathVariable Long id, Map<String, Object> model) {
        model.put("employeeList", employeeRepository.getEmployeeByDepartment_Id(id));
        return "employee_list";
    }

}