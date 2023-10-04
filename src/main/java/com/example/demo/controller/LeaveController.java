package com.example.demo.controller;


import com.example.demo.entity.Leave;
import com.example.demo.entity.LeaveTemp;
import com.example.demo.exception.EmployeeFoundException;
import com.example.demo.exception.EmployeeIdNotFoundException;
import com.example.demo.exception.LeaveFoundException;
import com.example.demo.exception.LeaveNotFoundException;
import com.example.demo.service.ILeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeaveController {
    @Autowired
    private ILeaveService leaveService;

    //get leave history of all employees
    @GetMapping("/leaveService")
    public List<LeaveTemp> getAllLeaveHistories() {
        return leaveService.getAllLeaveHistories();
    }

    //post a new entry of leave template for a new employee
    @PostMapping("/leaveService/leaveTemplate/add")
    public LeaveTemp addCustomer(@RequestBody LeaveTemp leaveTempObj) throws EmployeeFoundException {
        return leaveService.addLeaveTemp(leaveTempObj);
    }

    //post a new entry of leave for an existing employee
    @PostMapping("/leaveService/leave/add/{id}")
    public LeaveTemp addCustomer(@RequestBody Leave leaveObj, @PathVariable("id") int empId) throws EmployeeIdNotFoundException, LeaveFoundException {
        return leaveService.addLeave(leaveObj,empId);
    }

    //PUT - update more than one property of the leave template
    @PutMapping("/leaveService/update")
    public LeaveTemp updateCustomer(@RequestBody LeaveTemp leaveTempObj) throws EmployeeIdNotFoundException {
        return leaveService.updateLeaveTemp(leaveTempObj);
    }

    //Patch - update the leave property of the leave template
    @PutMapping("/leaveService/update/{id}")
    public LeaveTemp updateCustomer(@RequestBody Leave leaveObj,@PathVariable("id") int  empId) throws LeaveNotFoundException, EmployeeIdNotFoundException {
        return leaveService.updateLeaveById(leaveObj,empId);
    }

    //Delete- leaveHistory entry of an employee returns nothing
    @DeleteMapping("/leaveService/deleteVoid/{id}")
    public void deleteLeaveHistoryByEmpIdVoidReturn(@PathVariable("id") int empId) throws EmployeeIdNotFoundException {
        leaveService.deleteLeaveHistoryByEmpIdVoidReturn(empId);
    }

    //Delete- leaveHistory entry of an employee returns removed leave template
    @DeleteMapping("/leaveService/deleteReturn/{id}")
    public LeaveTemp deleteLeaveHistoryByEmpId(@PathVariable("id") int empId) throws EmployeeIdNotFoundException {
        return leaveService.deleteLeaveHistoryByEmpId((empId));
    }

}
