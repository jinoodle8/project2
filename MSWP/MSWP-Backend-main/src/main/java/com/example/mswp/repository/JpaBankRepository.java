package com.example.mswp.repository;

import com.example.mswp.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBankRepository extends JpaRepository<Bank, String> {
}
