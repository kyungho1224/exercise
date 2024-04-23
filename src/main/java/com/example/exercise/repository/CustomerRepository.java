package com.example.exercise.repository;

import com.example.exercise.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findFirstById(Long id);

    default Customer getFirstCustomerById(Long id) {
        return findFirstById(id)
          .orElseThrow(() -> new RuntimeException("Not Found Customer id: " + id));
    }

}
