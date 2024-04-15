package com.shuaibu.candidates.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ExperienceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String position;
    private String company;
    private String startDate;
    private String endDate;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private CandidatesEntity candidate;
}
