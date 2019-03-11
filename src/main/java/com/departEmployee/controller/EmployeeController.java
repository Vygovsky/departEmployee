package com.departEmployee.controller;

import com.departEmployee.model.Department;
import com.departEmployee.model.Employee;
import com.departEmployee.repository.DepartRepository;
import com.departEmployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

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
        model.put("departmentId", id);
        return "employee_list";
    }

    @GetMapping(value = "/employee/delete/{id}")
    public String deleteEmployeeById(@PathVariable Long id) {
        Long departId = employeeRepository.findById(id).get().getDepartment().getId();
        employeeRepository.deleteById(id);
        return "redirect:/listEmployee/departmentId/" + departId;
    }

    @GetMapping(value = "/add/employee/{currentDepartId}")
    public String addEmployee(@PathVariable Long currentDepartId, Model model) {
        Iterable<Department> departments = departRepository.findAll();
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departments);
        model.addAttribute("currentDepartId", departRepository.findById(currentDepartId).map(Department::getId).get());
        return "employee_create";
    }

    @PostMapping(value = "/save/employee")
    public String saveEmployee(@Valid Employee employee,
                               BindingResult result,
                               Map<String, Object> model) {
        if (result.hasErrors()) {
            return "employee_create";
        }
        Employee persistedEmployee = employeeRepository.save(employee);
        model.put("departments", departRepository.findAll());
        return "redirect:/listEmployee/departmentId/" + persistedEmployee.getDepartment().getId();
    }

    @GetMapping(value = "/edit/employee/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        Employee employee = employeeRepository.findById(id).get();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departRepository.findAll());
        model.addAttribute("currentDepartId", employee.getDepartment().getId());
        return "employee_update";
    }

    @PostMapping(value = "/update/employee")
    public String updateEmployee(@Valid Employee employee,
                                 BindingResult result, Map<String, Object> model) {
        if (result.hasErrors()) {

            return "employee_update";
        }
        Employee persistedEmployee = employeeRepository.save(employee);
        model.put("employeeList", persistedEmployee);
        return "redirect:/listEmployee/departmentId/" + persistedEmployee.getDepartment().getId();
    }
}