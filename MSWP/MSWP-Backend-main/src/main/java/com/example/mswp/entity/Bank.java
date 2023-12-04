package com.example.mswp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Bank {


    @Id
    @Column(name = "emp_id", length = 16, nullable = false) // 사원코드(FK)
    private String empId;

    @Column(name = "bank_num", length = 16, nullable = false) // 계좌번호
    private String bankNum;

    @Column(name = "bank_name", length = 30, nullable = false) // 은행명
    private String bankName;

    @Column(name = "bank_owner", length = 50, nullable = false) // 예금주
    private String bankOwner;

    @Column(name = "pay_incentive") // 인센티브
    private Integer payIncentive;

    @Column(name = "pay_day") // 입금일
    private LocalDate payDay;

    @Column(name = "pay_note", columnDefinition = "TEXT", nullable = true) // 비고(급여)
    private String payNote;

    @Column(name = "emp_salary", nullable = false) // 월급
    private Integer empSalary;


}
