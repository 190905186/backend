package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;
@Data
public class Leave {
    @Id
    private int leaveId;
    private String type;
    private Date startingDate;
    private Date endingDate;
}