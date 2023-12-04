package com.example.mswp.dto;

import com.example.mswp.entity.Commute;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommuteDto {
    private String empId;
    private LocalDateTime commStart;
    private LocalDateTime commEnd;
    private String commNote;

    public Commute toEntity() {
        return Commute.builder()
                .empId(empId)
                .commStart(commStart)
                .commEnd(commEnd)
                .commNote(commNote)
                .build();
    }
}
