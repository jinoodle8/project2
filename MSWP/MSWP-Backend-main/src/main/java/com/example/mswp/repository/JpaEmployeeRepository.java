package com.example.mswp.repository;

import com.example.mswp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaEmployeeRepository extends JpaRepository<Employee, String> {


}
