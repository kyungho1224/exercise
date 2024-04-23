package com.example.exercise.service;

import com.example.exercise.dto.CustomerDto;
import com.example.exercise.entity.Customer;
import com.example.exercise.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Transactional
@SpringBootTest
class IndexServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private IndexService indexService;

    @Test
    public void create_member_success() {
        CustomerDto.Request request = CustomerDto.Request.builder()
          .username("user1")
          .password("raw-password")
          .build();
        Customer customer = new Customer(1L, "user1", "raw-password");

        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        CustomerDto.Response response = indexService.createCustomer(request);

        verify(customerRepository, times(1)).save(any(Customer.class));
        assertEquals(customer.getId(), response.getId());
        assertEquals(customer.getUsername(), response.getUsername());
    }

}