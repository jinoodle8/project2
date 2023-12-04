package com.example.mswp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Commute")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Commute {

    @Id
    @Column(name = "emp_id", length =16, nullable = false)
    private String empId;

    @Column(name = "comm_start", nullable = false)
    private LocalDateTime commStart;

    @Column(name = "comm_end", nullable = false)
    private LocalDateTime commEnd;

    @Column(name = "comm_note", length = 100)
    private String commNote;
}