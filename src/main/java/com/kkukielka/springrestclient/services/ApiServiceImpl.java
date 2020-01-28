package com.kkukielka.springrestclient.services;

import com.kkukielka.api.domain.Employee;
import com.kkukielka.api.domain.EmployeesData;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ApiServiceImpl implements ApiService {

    private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Employee> listEmployees() {

        EmployeesData employeeData = restTemplate.getForObject(
                "http://dummy.restapiexample.com/api/v1/employees", EmployeesData.class);

        return employeeData.getData();
    }
}
