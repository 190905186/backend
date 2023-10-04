package com.example.demo.service;

import com.example.demo.entity.Leave;
import com.example.demo.entity.LeaveTemp;
import com.example.demo.exception.EmployeeFoundException;
import com.example.demo.exception.EmployeeIdNotFoundException;
import com.example.demo.exception.LeaveFoundException;
import com.example.demo.exception.LeaveNotFoundException;

import java.util.List;

public interface ILeaveService {

    List<LeaveTemp> getAllLeaveHistories();
    LeaveTemp addLeave(Leave leave,int empId) throws EmployeeIdNotFoundException, LeaveFoundException;
    LeaveTemp addLeaveTemp(LeaveTemp leave) throws EmployeeFoundException;
    LeaveTemp getLeaveTempByEmpId(int empId) throws EmployeeIdNotFoundException;
    LeaveTemp updateLeaveById(Leave leave,int empId) throws EmployeeIdNotFoundException, LeaveNotFoundException;
    LeaveTemp updateLeaveTemp(LeaveTemp leaveTemp) throws EmployeeIdNotFoundException;
    void deleteLeaveHistoryByEmpIdVoidReturn(int empId) throws EmployeeIdNotFoundException;
    LeaveTemp deleteLeaveHistoryByEmpId(int empId) throws EmployeeIdNotFoundException;

}
