package com.example.exercise.comon.aspects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Before("execution(* com.example.exercise.controller.*.*(..)) && @target(com.example.exercise.comon.annotation.LogExecution)")
    public void logExecutionMethodBefore(JoinPoint joinPoint) {
        log.info("Method {} is opened", joinPoint.getSignature().toShortString());

        Arrays.stream(joinPoint.getArgs()).forEach(arg -> {
            try {
                String json = objectMapper.writeValueAsString(arg);
                log.info("Argument type: {}, value: {}", arg.getClass().getName(), json);
            } catch (JsonProcessingException e) {
                log.error("Error converting argument to JSON: {}", e.getMessage());
            }
        });
    }

    @After("execution(* com.example.exercise.controller.*.*(..)) && @target(com.example.exercise.comon.annotation.LogExecution)")
    public void logExecutionMethodAfter(JoinPoint joinPoint) {
        log.info("Method {} is closed", joinPoint.getSignature().toShortString());
    }

}
