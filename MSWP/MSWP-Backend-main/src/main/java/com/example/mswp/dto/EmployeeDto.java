package com.example.mswp.dto;

import com.example.mswp.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDto {

    private String empId;
    private String empPw;
    private String empName;
    private Integer empSalary;
    private String empPhone;
    private String empEmail;
    private String empResident;
    private LocalDate empStart;
    private LocalDate empEnd;
    private String empEndReason;
    private String empRank;
    private String empPhoto;
    private String empResume;
    private String empAddress;
    private String compId;
    private String bankNum;
    private String depName;

    public Employee toEntity() {
        return Employee.builder()
                .empId(empId)
                .empPw(empPw)
                .empName(empName)
                .empSalary(empSalary)
                .empPhone(empPhone)
                .empEmail(empEmail)
                .empResident(empResident)
                .empStart(empStart)
                .empEnd(empEnd)
                .empEndReason(empEndReason)
                .empRank(empRank)
                .empPhoto(empPhoto)
                .empResume(empResume)
                .empAddress(empAddress)
                .compId(compId)
                .bankNum(bankNum)
                .depName(depName)
                .build();
    }

}
