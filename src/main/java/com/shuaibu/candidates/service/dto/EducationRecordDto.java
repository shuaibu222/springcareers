package com.shuaibu.candidates.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationRecordDto {
    private Integer id;

    private String institution;
    private String degree;
    private String fieldOfStudy;
    private String startDate;
    private String endDate;

}
