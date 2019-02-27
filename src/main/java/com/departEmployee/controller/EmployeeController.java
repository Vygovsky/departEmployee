package com.departEmployee.controller;

import com.departEmployee.model.Department;
import com.departEmployee.model.Employee;
import com.departEmployee.repository.DepartRepository;
import com.departEmployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    private DepartRepository departRepository;

    @Autowired
    public void setDepartRepository(DepartRepository departRepository) {
        this.departRepository = departRepository;
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping(value = "/listEmployee/departmentId/{id}", method = RequestMethod.GET)
    public String getAllListDepart(@PathVariable Long id, Map<String, Object> model) {
        model.put("employeeList", employeeRepository.getEmployeeByDepartment_Id(id));
        return "employee_list";
    }

    @GetMapping(value = "/employee/delete/{id}")
    public String deleteEmployeeById(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "redirect:/listEmployee/departmentId/" + id;
    }

    @GetMapping(value = "/add/employee")
    public String addEmployee( @PathVariable Long currentDepartId, Map<String, Object> model) {
        model.put("employee", new Employee());
        model.put("departments", departRepository.findAll());
        model.put("currentDepartId", departRepository.findById(currentDepartId));
        return "employee_create";
    }

    @PostMapping(value = "/save/employee")
    public String saveEmployee(@PathVariable Long id,
                               Employee employee,
                               BindingResult result,
                               Map<String, Object> model) {
        if (result.hasErrors()) {
            return "employee_create";
        }
        employeeRepository.save(employee);
        model.put("employeeList", employeeRepository.getEmployeeByDepartment_Id(id));
        return "redirect:/listEmployee/departmentId/" + id;
    }
}