package com.example.mswp.dto;


import com.example.mswp.entity.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DepartmentDto {
    private String depCode;
    private String compId;
    private String depName;
    private String depDetail;

    public Department toEntity() {
        return Department.builder()
                .depCode(depCode)
                .compId(compId)
                .depName(depName)
                .depDetail(depDetail)
                .build();
    }
}
