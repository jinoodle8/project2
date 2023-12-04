package com.example.mswp.repository;

import com.example.mswp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCompanyRepository extends JpaRepository<Company, String> {
}
