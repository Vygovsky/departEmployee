package com.departEmployee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class AppController {
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String indexPage(Map<String, Object> model) {
        String message = "Hello World";
        model.put("massage", message);
        return "welcome";
    }
}
