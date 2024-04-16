package com.shuaibu.jobs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shuaibu.jobs.entity.JobsEntity;
import com.shuaibu.jobs.repository.JobsRepo;
import com.shuaibu.jobs.service.JobsInterface;
import com.shuaibu.jobs.service.dto.JobsDto;

@Service
public class JobsImpl implements JobsInterface {
    
    private JobsRepo jobsRepo;

    public JobsImpl(JobsRepo jobsRepo) {
        this.jobsRepo = jobsRepo;
    }

    @Override
    public JobsDto create(JobsDto jobsDto) {
        
        JobsEntity e = mapToEntity(jobsDto);
        return mapToDto(jobsRepo.save(e));
    }


    @Override
    public JobsDto getById(Integer id) {
        JobsEntity jobsEntity = jobsRepo.findById(id).orElseThrow();

        return mapToDto(jobsEntity);
    }


    @Override
    public JobsDto updateById(Integer id, JobsDto dto) {
        JobsEntity entity = jobsRepo.findById(id).orElseThrow();

        entity.setJobTitle(dto.getJobTitle());
        entity.setCompanyName(dto.getCompanyName());
        entity.setLocation(dto.getLocation());
        entity.setJobType(dto.getJobType());
        entity.setSalaryRange(dto.getSalaryRange());
        entity.setJobDesc(dto.getJobDesc());
        entity.setRequiredSkills(dto.getRequiredSkills());
        entity.setExperienceLevel(dto.getExperienceLevel());
        entity.setEmploymentStatus(dto.getEmploymentStatus());
        entity.setBenefits(dto.getBenefits());
        entity.setPostedAt(dto.getPostedAt());
        entity.setDeadline(dto.getDeadline());
        entity.setApplyContactInfo(dto.getApplyContactInfo());

        return mapToDto(jobsRepo.save(entity));

    }


    @Override
    public String deleteById(Integer id) {
        jobsRepo.deleteById(id);

        return "Job deleted successfully!";
    }


    @Override
    public List<JobsDto> getAll() {
        Iterable<JobsEntity> jobsEntity = jobsRepo.findAll();
        
        List<JobsDto> jDtos = new ArrayList<>();

        for(JobsEntity j : jobsEntity){
            jDtos.add(mapToDto(j));
        }

        return jDtos;
    }

    private JobsDto mapToDto(JobsEntity jobsEntity) {
        JobsDto dto = new JobsDto();

        dto.setJobTitle(jobsEntity.getJobTitle());
        dto.setCompanyName(jobsEntity.getCompanyName());
        dto.setLocation(jobsEntity.getLocation());
        dto.setJobType(jobsEntity.getJobType());
        dto.setSalaryRange(jobsEntity.getSalaryRange());
        dto.setJobDesc(jobsEntity.getJobDesc());
        dto.setRequiredSkills(jobsEntity.getRequiredSkills());
        dto.setExperienceLevel(jobsEntity.getExperienceLevel());
        dto.setEmploymentStatus(jobsEntity.getEmploymentStatus());
        dto.setBenefits(jobsEntity.getBenefits());
        dto.setPostedAt(jobsEntity.getPostedAt());
        dto.setDeadline(jobsEntity.getDeadline());
        dto.setApplyContactInfo(jobsEntity.getApplyContactInfo());

        return dto;
    }

    private JobsEntity mapToEntity(JobsDto jobsDto) {

        JobsEntity entity = new JobsEntity();

        entity.setJobTitle(jobsDto.getJobTitle());
        entity.setCompanyName(jobsDto.getCompanyName());
        entity.setLocation(jobsDto.getLocation());
        entity.setJobType(jobsDto.getJobType());
        entity.setSalaryRange(jobsDto.getSalaryRange());
        entity.setJobDesc(jobsDto.getJobDesc());
        entity.setRequiredSkills(jobsDto.getRequiredSkills());
        entity.setExperienceLevel(jobsDto.getExperienceLevel());
        entity.setEmploymentStatus(jobsDto.getEmploymentStatus());
        entity.setBenefits(jobsDto.getBenefits());
        entity.setPostedAt(jobsDto.getPostedAt());
        entity.setDeadline(jobsDto.getDeadline());
        entity.setApplyContactInfo(jobsDto.getApplyContactInfo());

        return entity;
    }
}
