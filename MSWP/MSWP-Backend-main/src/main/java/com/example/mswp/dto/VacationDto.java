package com.example.mswp.dto;

import com.example.mswp.entity.Vacation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VacationDto {
    private String empId;
    private String vacName;
    private Integer vacTotal;
    private Integer vacRemind;

    public Vacation toEntity() {
        return Vacation.builder()
                .empId(empId)
                .vacName(vacName)
                .vacTotal(vacTotal)
                .vacRemind(vacRemind)
                .build();
    }
}
