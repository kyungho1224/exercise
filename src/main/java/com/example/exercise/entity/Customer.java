package com.example.exercise.entity;

import com.example.exercise.dto.CustomerDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "customers")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    public static Customer createOf(CustomerDto.Request request) {
        return Customer.builder()
          .username(request.getUsername())
          .password(request.getPassword())
          .build();
    }

}
