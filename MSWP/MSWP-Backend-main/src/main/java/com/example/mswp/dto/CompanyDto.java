package com.example.mswp.dto;

import com.example.mswp.entity.Company;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CompanyDto {
    private String compId;
    private String compPw;
    private String compName;
    private String compCeo;
    private String compManager;
    private String compEmail;
    private String compAddress;

    public Company toEntity() {
        return Company.builder()
                .compId(compId)
                .compPw(compPw)
                .compName(compName)
                .compCeo(compCeo)
                .compManager(compManager)
                .compEmail(compEmail)
                .compAddress(compAddress)
                .build();
    }
}
