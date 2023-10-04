package com.example.demo.repository;
import com.example.demo.entity.LeaveTemp;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ILeaveRepository extends JpaRepository<LeaveTemp,Integer>{
}
