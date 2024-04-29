package com.shuaibu.candidates.service.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidatesDto {

    private Integer id;

    private String name;
    private String email;
    private String phoneNumber;
    private String linkedInAddressString;
    private String bio;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<ExperienceRecordDto> experienceRecord;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<EducationRecordDto> educationRecord;
    
    private List<String> skills;
    private List<String> preferences;
    private List<String> savedJobs;
    private String profilePicture;
}

