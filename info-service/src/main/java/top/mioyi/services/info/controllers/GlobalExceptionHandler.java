package top.mioyi.services.info.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.mioyi.responses.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionResponse> handle(Exception e) {
        return ResponseEntity.internalServerError().body(new ExceptionResponse(e));
    }
}