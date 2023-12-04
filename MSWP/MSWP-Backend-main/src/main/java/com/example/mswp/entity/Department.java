package com.example.mswp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Department {

    @Id
    @Column(name = "dep_code", length = 20, nullable = false)
    private String depCode;

    @Column(name = "comp_id", length = 10, nullable = false)
    private String compId;

    @Column(name = "dep_name", length = 30, nullable = false)
    private String depName;

    @Column(name = "dep_detail", length = 100)
    private String depDetail;

}