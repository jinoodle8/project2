package com.example.mswp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class Company {

    @Id
    @Column(name = "comp_id", length = 10, nullable = false)
    private String compId;

    @Column(name = "comp_pw", length = 40, nullable = false)
    private String compPw;

    @Column(name = "comp_name", length = 30, nullable = false)
    private String compName;

    @Column(name = "comp_ceo", length = 10, nullable = false)
    private String compCeo;

    @Column(name = "comp_manager", length = 20, nullable = false)
    private String compManager;

    @Column(name = "comp_email", length = 100, nullable = false)
    private String compEmail;

    @Column(name = "comp_address", length = 150, nullable = false)
    private String compAddress;
}
