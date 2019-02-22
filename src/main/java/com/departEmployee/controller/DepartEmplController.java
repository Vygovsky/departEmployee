package com.departEmployee.controller;

import com.departEmployee.model.Department;
import com.departEmployee.repository.DepartRepository;
import com.departEmployee.service.DepartService;
import com.departEmployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/")
public class DepartEmplController {

    private DepartRepository departRepository;

    @Autowired
    public void setDepartRepository(DepartRepository departRepository) {
        this.departRepository = departRepository;
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllListDepart(Map<String, Object> model) {
        model.put("allListDepart", departRepository.findEmployeeCountByDepartment());
        return "depart_list";
    }

    @PostMapping(value = "/save")
    public String saveDepartment(Department department, BindingResult result, Map<String, Object> model) {
        if (result.hasErrors()) {
            return "create_depart";
        }
        departRepository.save(department);
        model.put("allListDepart", departRepository.findEmployeeCountByDepartment());
        return "redirect:/";
    }

    @GetMapping(value = "/add")
    public String addDepartment(Map<String, Object> model) {
        model.put("depart", new Department());
        return "create_depart";
    }

    @RequestMapping(value = "/departments/delete/{id}", method = RequestMethod.GET)
    public String deleteDepart(@PathVariable Long id) {
        departRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping(value = "/departments/edit/{id}")
    public String editDepart(@PathVariable("id") Long id, Map<String, Object> model) {
        Optional<Department> byIdDepart = departRepository.findById(id);
        model.put("editDepart", byIdDepart);
        return "edit_depart";
    }

    @PostMapping(value = "/departments/update/{id}")
    public String updateDepart(@PathVariable("id") Long id, @Valid Department department, BindingResult result, Map<String, Object> model) {
        if (result.hasErrors()) {
            department.setId(id);
            return "edit_depart";
        }
        departRepository.save(department);
        model.put("allListDepart", departRepository.findEmployeeCountByDepartment());
        return "depart_list";
    }
}
