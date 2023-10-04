package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ErrorResponse {
    private String message;
    private LocalDateTime timeStamp;
    private int status;
}
