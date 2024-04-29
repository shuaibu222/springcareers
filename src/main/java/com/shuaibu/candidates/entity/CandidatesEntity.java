package com.shuaibu.candidates.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CandidatesEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    private String name;

    private String email;
    private String phoneNumber;
    private String linkedInAddressString;
    private String bio;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<ExperienceRecord> experienceRecord;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<EducationRecord> educationRecord;
    
    private List<String> skills;
    private List<String> preferences;
    private List<String> savedJobs;
    private String profilePicture;
}
