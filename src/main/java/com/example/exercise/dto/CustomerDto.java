package com.example.exercise.dto;

import com.example.exercise.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CustomerDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    public static class Request {
        private String username;
        private String password;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    public static class Response {
        private Long id;
        private String username;

        public static Response of(Customer customer) {
            return Response.builder()
              .id(customer.getId())
              .username(customer.getUsername())
              .build();
        }
    }

}
