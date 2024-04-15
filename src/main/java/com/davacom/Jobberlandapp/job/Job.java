package com.davacom.Jobberlandapp.job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    private Long id;
    private String tittle;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
}

//{
//        "id": 1,
//        "tittle": "Software Developer",
//        "minSalary": "12000",
//        "maxSalary": "30000",
//        "locatiuon": "Nigeria"
//        }