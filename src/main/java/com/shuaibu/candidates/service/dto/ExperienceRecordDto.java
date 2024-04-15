package com.shuaibu.candidates.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceRecordDto {
    private Integer id;
    
    private String position;
    private String company;
    private String startDate;
    private String endDate;
}
