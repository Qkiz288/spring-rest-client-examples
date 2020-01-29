package com.kkukielka.springrestclient.services;

import com.kkukielka.api.domain.Employee;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ApiService {

    List<Employee> listEmployees();

    Mono<Employee> getEmployee(Mono<Integer> id);

}
