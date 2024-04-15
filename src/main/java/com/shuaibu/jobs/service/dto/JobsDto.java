package com.shuaibu.jobs.service.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobsDto {

    private int id;

    private String jobTitle;
    private String companyName;
    private String companyLogo;
    private String location;
    private String jobType;
    private String salaryRange;
    private String jobDesc;
    private List<String> requiredSkills;
    private String experienceLevel;
    private String employmentStatus;
    private String benefits;
    private String postedAt;
    private String deadline;
    private List<String> applyContactInfo;

}