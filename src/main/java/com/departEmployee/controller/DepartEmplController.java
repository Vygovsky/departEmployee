package com.departEmployee.controller;

import com.departEmployee.model.Department;
import com.departEmployee.repository.DepartRepository;
import com.departEmployee.service.DepartService;
import com.departEmployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/")
public class DepartEmplController {

    private DepartRepository departRepository;

    private EmployeeService employeeService;

    @Autowired
    public void setDepartRepository(DepartRepository departRepository) {
        this.departRepository = departRepository;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllListDepart(Map<String, Object> model) {
        model.put("allListDepart", departRepository.findEmployeeCountByDepartment());
        return "depart_list";
    }

}
