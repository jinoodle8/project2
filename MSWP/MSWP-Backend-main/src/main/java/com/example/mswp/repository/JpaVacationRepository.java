package com.example.mswp.repository;

import com.example.mswp.entity.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaVacationRepository extends JpaRepository<Vacation, String> {
}
