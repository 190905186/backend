package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class LeaveHistoryExceptionHandler {

    @ExceptionHandler(EmployeeIdNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeIdNotFoundException exception){
        ErrorResponse error=new ErrorResponse();
        error.setMessage(exception.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LeaveNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleLeaveNotFoundException(LeaveNotFoundException exception){
        ErrorResponse error=new ErrorResponse();
        error.setMessage(exception.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeFoundException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeFoundException(EmployeeFoundException exception){
        ErrorResponse error=new ErrorResponse();
        error.setMessage(exception.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LeaveFoundException.class)
    public ResponseEntity<ErrorResponse> handleLeaveFoundException(LeaveFoundException exception){
        ErrorResponse error=new ErrorResponse();
        error.setMessage(exception.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
