package com.example.mswp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DynamicUpdate
public class Employee {

    @Id
    @Column(name = "emp_id", length = 20, nullable = false)
    private String empId;

    @Column(name = "emp_pw", length = 20, nullable = false)
    private String empPw;

    @Column(name = "emp_name", length = 25, nullable = false)
    private String empName;

    @Column(name = "emp_salary", nullable = false)
    private int empSalary;

    @Column(name = "emp_phone", length = 15, nullable = false)
    private String empPhone;

    @Column(name = "emp_email", length = 150, nullable = false)
    private String empEmail;

    @Column(name = "emp_resident", length = 15, nullable = false)
    private String empResident;

    @Column(name = "emp_start", nullable = false)
    private LocalDate empStart;

    @Column(name = "emp_end")
    private LocalDate empEnd;

    @Column(name = "emp_end_reason", length = 20)
    private String empEndReason;

    @Column(name = "emp_rank", length = 20, nullable = false)
    private String empRank;

    @Column(name = "emp_photo", length = 100)
    private String empPhoto;

    @Column(name = "emp_resume", length = 100)
    private String empResume;

    @Column(name = "emp_address", length = 150, nullable = false)
    private String empAddress;

    @Column(name = "comp_id", length = 10, nullable = false)
    private String compId;

    @Column(name = "bank_num", length = 16, nullable = false)
    private String bankNum;

    @Column(name = "dep_name", length = 30, nullable = false)
    private String depName;
}
