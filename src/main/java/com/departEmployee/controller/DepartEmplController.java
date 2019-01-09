package com.departEmployee.controller;

import com.departEmployee.model.Department;
import com.departEmployee.service.DepartService;
import com.departEmployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/")
public class DepartEmplController {

    private DepartService departService;
    private EmployeeService employeeService;

    @Autowired
    public void setDepartService(DepartService departService) {
        this.departService = departService;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllListDepart(Map<String, Object> model) {
        Iterable<Department> allDepartments = departService.getAllDepartments();
        Map<Long, Long> countEmplInDepartments = departService.findCountEmplInDepartments();

        Map<Department, Long> getDepartByIdAndName = new HashMap<>();


        model.put("allListDepart", allDepartments);
        return "depart_list";
    }

}
