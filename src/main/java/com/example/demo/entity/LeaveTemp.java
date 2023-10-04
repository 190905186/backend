package com.example.demo.entity;

import jakarta.persistence.*;

import lombok.Data;
import java.util.List;

@Data
@Entity
public class LeaveTemp {
    @Id
    private int empId;
    @Transient
    private List<Leave> leaveList;
}
