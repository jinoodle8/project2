package com.example.mswp.repository;

import com.example.mswp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDepartmentRepository extends JpaRepository<Department, String> {
}
