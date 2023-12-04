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

public class Vacation {

    @Id
    @Column(name = "emp_id", length = 20, nullable = false) // 사원코드
    private String empId;

    @Column(name = "vac_name", length = 50) // 휴가명
    private String vacName;

    @Column(name = "vac_total", nullable = false) // 총 휴가
    private Integer vacTotal;

    @Column(name = "vac_remind", nullable = false) // 잔여 휴가
    private Integer vacRemind;

}
