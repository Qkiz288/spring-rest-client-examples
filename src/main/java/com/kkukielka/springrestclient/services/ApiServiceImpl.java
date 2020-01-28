package com.kkukielka.springrestclient.services;

import com.kkukielka.api.domain.Employee;
import com.kkukielka.api.domain.EmployeesData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private final String employees_url;

    private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate,
                          @Value("${api.url.employees}") String employees_url) {
        this.restTemplate = restTemplate;
        this.employees_url = employees_url;
    }

    @Override
    public List<Employee> listEmployees() {

        EmployeesData employeeData = restTemplate
                .getForObject(employees_url, EmployeesData.class);

        return employeeData.getData();
    }
}
