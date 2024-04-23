package com.example.exercise.service;

import com.example.exercise.dto.CustomerDto;
import com.example.exercise.entity.Customer;
import com.example.exercise.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class IndexService {

//    private final CustomerRepository customerRepository;
//
//    public CustomerDto.Response createCustomer(CustomerDto.Request request) {
//        Customer newCustomer = Customer.createOf(request);
//        Customer savedCustomer = customerRepository.save(newCustomer);
//        return CustomerDto.Response.of(savedCustomer);
//    }
//
//    public CustomerDto.Response me(Long id) {
//        Customer customer = customerRepository.getFirstCustomerById(id);
//        return CustomerDto.Response.of(customer);
//    }

}
