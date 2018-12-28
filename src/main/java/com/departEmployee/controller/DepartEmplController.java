package com.departEmployee.controller;

import com.departEmployee.model.Department;
import com.departEmployee.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/")
public class DepartEmplController {

    private DepartService departService;

    @Autowired
    public void setDepartService(DepartService departService) {
        this.departService = departService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllListDepart(Map<String, Object> model
                                   /*@RequestParam(value = "id", required = false) Long id,
                                   @RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "count", required = false) Long idCount*/) {
        Map<Department, Long> getDepartByIdAndName = new HashMap<>();
        Iterator<Map.Entry<Department, Long>> iterator = getDepartByIdAndName.entrySet().iterator();



        model.put("allListDepart", getDepartByIdAndName);
        return "depart_list";
    }

}
