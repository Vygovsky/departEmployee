package com.departEmployee.controller;

import com.departEmployee.model.Department;
import com.departEmployee.repository.DepartmentDAO;
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

    private DepartService departService;
    private EmployeeService employeeService;
    private DepartmentDAO departmentDAO;

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
       Map<Department, Long> countEmplInDepartments = departmentDAO.findCountEmplInDepartments();

       /* Map<Object, Long> countEmplInDepartments3=new HashMap<>();
        countEmplInDepartments3.put(allDepartments,countEmplInDepartments3);*/
/*
        List<Object[]> getAllQuire = (List<Object[]>) departRepository.findCountEmplInDepartments2();
        for (Object[] objects : getAllQuire) {
            Department department = (Department) objects[0];
            Long count = (Long) objects[1];
            allDepartments.put(department, count);
        }
*/

        // Map<Department, Long> getDepartByIdAndName = new HashMap<>();


        model.put("allListDepart", countEmplInDepartments);
        return "/";
    }

}
