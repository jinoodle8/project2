package com.example.mswp.repository;

import com.example.mswp.entity.Commute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommuteRepository extends JpaRepository<Commute, String> {
}
