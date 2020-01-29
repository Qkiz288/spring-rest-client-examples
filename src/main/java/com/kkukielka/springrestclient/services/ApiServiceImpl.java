package com.kkukielka.springrestclient.services;

import com.kkukielka.api.domain.Employee;
import com.kkukielka.api.domain.EmployeesData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    @Value("${api.url.employees}")
    private String employees_url;

    @Value("${api.url.employee}")
    private String employee_url;

    private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Employee> listEmployees() {

        EmployeesData employeeData = restTemplate
                .getForObject(employees_url, EmployeesData.class);

        return employeeData.getData();
    }

    @Override
    public Mono<Employee> getEmployee(Mono<Integer> id) {


        return WebClient.create(employee_url)
                .get()
                .uri(uriBuilder -> uriBuilder.path("").build(id.block()))
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .block()
                .bodyToMono(Employee.class);
    }


}
