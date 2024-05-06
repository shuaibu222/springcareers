package com.shuaibu.recruiters.service.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecruitersDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String companyName;
    private String description;
    private String yearFounded;
    private String website;
    private String logoUrl;
    private String address;
    private String state;
    private String country;
    private String[] employees;
    private String[] socialMedia;
    private String contactEmail;
}
