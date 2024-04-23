package com.example.exercise.controller;

import com.example.exercise.comon.annotation.LogExecution;
import com.example.exercise.dto.CustomerDto;
import com.example.exercise.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@LogExecution
@RequiredArgsConstructor
@RestController
public class IndexController {

    @Value("${index.string}")
    private String serverInfo;

    @Value("${index.version}")
    private String serverVersion;

    private final IndexService indexService;

    @GetMapping("/index")
    public ResponseEntity<String> index() {
        String format = String.format("info : %s, version : %s", serverInfo, serverVersion);
        return ResponseEntity.ok().body(format);
    }

//    @PostMapping("/register")
//    public ResponseEntity<CustomerDto.Response> register(
//      @RequestBody CustomerDto.Request request
//    ) {
//        var response = indexService.createCustomer(request);
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/customers/{id}")
//    public ResponseEntity<CustomerDto.Response> me(
//      @PathVariable Long id
//    ) {
//        var response = indexService.me(id);
//        return ResponseEntity.ok(response);
//    }

}
