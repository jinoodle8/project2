package com.example.mswp.dto;

import com.example.mswp.entity.Bank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BankDto {
    private String empId;
    private String bankNum;
    private String bankName;
    private String bankOwner;
    private Integer payIncentive;
    private LocalDate payDay;
    private String payNote;
    private Integer empSalary;

    public Bank toEntity() {
        return Bank.builder()
                .empId(empId)
                .bankNum(bankNum)
                .bankName(bankName)
                .bankOwner(bankOwner)
                .payIncentive(payIncentive)
                .payDay(payDay)
                .payNote(payNote)
                .empSalary(empSalary)
                .build();
    }
}
