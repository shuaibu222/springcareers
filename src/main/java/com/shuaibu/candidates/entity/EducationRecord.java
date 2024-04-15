package com.shuaibu.candidates.entity;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@Entity
public class EducationRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String institution;
    private String degree;
    private String fieldOfStudy;
    private String startDate;
    private String endDate;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private CandidatesEntity candidate;
}
