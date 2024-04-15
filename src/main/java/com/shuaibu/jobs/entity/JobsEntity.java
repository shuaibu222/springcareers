package com.shuaibu.jobs.entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
