package com.davacom.Jobberlandapp.job;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "job_tbl")
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    private Long id;
    private String tittle;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
}