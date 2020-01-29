package com.kkukielka.springrestclient.services;

import com.kkukielka.api.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceImplTest {

    @Autowired
    private ApiService apiService;

    @Test
    public void listUsers() {

        // when
        List<Employee> employees = apiService.listEmployees();

        // then
        assertNotNull(employees);
        assertFalse(employees.isEmpty());
    }

    @Test
    public void getEmployee() {

        Employee employeeMono = apiService.getEmployee(Mono.just(Integer.valueOf(1))).block();

        assertNotNull(employeeMono);
    }
}