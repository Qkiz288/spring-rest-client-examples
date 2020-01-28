package com.kkukielka.springrestclient.controllers;


import com.kkukielka.springrestclient.services.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class EmployeeController {

    private ApiService apiService;

    public EmployeeController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"", "/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        log.debug("Entered listEmployees");

        model.addAttribute("employees", apiService.listEmployees());

        return "employeelist";
    }
}
