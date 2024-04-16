package com.shuaibu.candidates.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shuaibu.candidates.entity.CandidatesEntity;
import com.shuaibu.candidates.entity.EducationRecord;
import com.shuaibu.candidates.entity.ExperienceRecord;
import com.shuaibu.candidates.repository.CandidatesRepo;
import com.shuaibu.candidates.service.CandidatesInterface;
import com.shuaibu.candidates.service.dto.CandidatesDto;
import com.shuaibu.candidates.service.dto.EducationRecordDto;
import com.shuaibu.candidates.service.dto.ExperienceRecordDto;

@Service
public class CandidatesImpl implements CandidatesInterface {

    private CandidatesRepo candidatesRepo;
    
    CandidatesImpl(CandidatesRepo candidatesRepo) {
        this.candidatesRepo = candidatesRepo;
    }

    public CandidatesDto create(CandidatesDto dto) {

        CandidatesEntity candidatesEntity = mapToEntity(dto);

        CandidatesDto candidatesDto = mapToDto(candidatesRepo.save(candidatesEntity));

        return candidatesDto;

    }

    public CandidatesDto getById(Integer id) {

        return mapToDto(candidatesRepo.findById(id).orElseThrow());
    }

    public CandidatesDto updateById(Integer id, CandidatesDto dto) {

        CandidatesEntity entity = candidatesRepo.findById(id).orElseThrow();

        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setLinkedInAddressString(dto.getLinkedInAddressString());
        entity.setBio(dto.getBio());

        /*
         * Loop through it since it's a standalone object,
         * and mapped it internally whith the recieved dto object,
         * lastly setting it to the entity object
         */

        if (dto.getExperienceRecord() != null) {
            List<ExperienceRecord> experienceRecords = new ArrayList<>();
            
            for (ExperienceRecordDto experienceRecordDto : dto.getExperienceRecord()) {
                ExperienceRecord experienceRecord = new ExperienceRecord();
                // map individual fields
                experienceRecord.setCompany(experienceRecordDto.getCompany());
                experienceRecord.setPosition(experienceRecordDto.getPosition());
                experienceRecord.setStartDate(experienceRecordDto.getStartDate());
                experienceRecord.setEndDate(experienceRecordDto.getEndDate());
                // Set candidate for bidirectional relationship
                experienceRecord.setCandidate(entity);
                experienceRecords.add(experienceRecord);
            }
            entity.setExperienceRecord(experienceRecords);
        }
        
        if (dto.getEducationRecord() != null) {
            List<EducationRecord> educationRecords = new ArrayList<>();
            for (EducationRecordDto educationRecordDto : dto.getEducationRecord()) {
                EducationRecord educationRecord = new EducationRecord();
                // Map individual fields
                educationRecord.setInstitution(educationRecordDto.getInstitution());
                educationRecord.setDegree(educationRecordDto.getDegree());
                educationRecord.setFieldOfStudy(educationRecordDto.getFieldOfStudy());
                educationRecord.setStartDate(educationRecordDto.getStartDate());
                educationRecord.setEndDate(educationRecordDto.getEndDate());
                // Set candidate for bidirectional relationship
                educationRecord.setCandidate(entity);
                educationRecords.add(educationRecord);
            }
            entity.setEducationRecord(educationRecords);
        }
        entity.setSkills(dto.getSkills());
        entity.setPreferences(dto.getPreferences());
        entity.setSavedJobs(dto.getSavedJobs());

        return mapToDto(candidatesRepo.save(entity));

    }

    public String deleteById(Integer id) {
        candidatesRepo.deleteById(id);

        return "Deleted successfully";
    }

    // -----------  UTILS FUNCTIONS ---------- //


    // Easy the task of mapping dto to entity and entity to dto objects.
    
    private CandidatesEntity mapToEntity(CandidatesDto dto) {

        CandidatesEntity candidatesEntity = new CandidatesEntity();

        candidatesEntity.setName(dto.getName());
        candidatesEntity.setEmail(dto.getEmail());
        candidatesEntity.setPhoneNumber(dto.getPhoneNumber());
        candidatesEntity.setLinkedInAddressString(dto.getLinkedInAddressString());
        candidatesEntity.setBio(dto.getBio());
        /*
         * Loop through it since it's a standalone object,
         * and mapped it internally whith the recieved dto object,
         * lastly setting it to the entity object
         */
    if (dto.getExperienceRecord() != null) {
        List<ExperienceRecord> experienceRecords = new ArrayList<>();
        for (ExperienceRecordDto experienceRecordDto : dto.getExperienceRecord()) {
            ExperienceRecord experienceRecord = new ExperienceRecord();
            // map individual fields
            experienceRecord.setCompany(experienceRecordDto.getCompany());
            experienceRecord.setPosition(experienceRecordDto.getPosition());
            experienceRecord.setStartDate(experienceRecordDto.getStartDate());
            experienceRecord.setEndDate(experienceRecordDto.getEndDate());
            // Set candidate for bidirectional relationship
            experienceRecord.setCandidate(candidatesEntity);
            experienceRecords.add(experienceRecord);
        }
        candidatesEntity.setExperienceRecord(experienceRecords);
    }

    if (dto.getEducationRecord() != null) {
        List<EducationRecord> educationRecords = new ArrayList<>();
        for (EducationRecordDto educationRecordDto : dto.getEducationRecord()) {
            EducationRecord educationRecord = new EducationRecord();
            // Map individual fields
            educationRecord.setInstitution(educationRecordDto.getInstitution());
            educationRecord.setDegree(educationRecordDto.getDegree());
            educationRecord.setFieldOfStudy(educationRecordDto.getFieldOfStudy());
            educationRecord.setStartDate(educationRecordDto.getStartDate());
            educationRecord.setEndDate(educationRecordDto.getEndDate());
            // Set candidate for bidirectional relationship
            educationRecord.setCandidate(candidatesEntity);
            educationRecords.add(educationRecord);
        }
        candidatesEntity.setEducationRecord(educationRecords);
    }

        candidatesEntity.setSkills(dto.getSkills());
        candidatesEntity.setPreferences(dto.getPreferences());
        candidatesEntity.setSavedJobs(dto.getSavedJobs());

        return candidatesEntity;
    }

    private CandidatesDto mapToDto(CandidatesEntity candidatesEntity) {

        CandidatesDto candidatesDto = new CandidatesDto();
        
        candidatesDto.setName(candidatesEntity.getName());
        candidatesDto.setEmail(candidatesEntity.getEmail());
        candidatesDto.setPhoneNumber(candidatesEntity.getPhoneNumber());
        candidatesDto.setLinkedInAddressString(candidatesEntity.getLinkedInAddressString());
        candidatesDto.setBio(candidatesEntity.getBio());
        /*
         * Loop through it since it's a standalone object,
         * and mapped it internally whith the recieved entity object,
         * lastly setting it to the dto object
         */
        if (candidatesEntity.getExperienceRecord() != null) {
            List<ExperienceRecordDto> experienceRecordDtos = new ArrayList<>();
            for (ExperienceRecord experienceRecord : candidatesEntity.getExperienceRecord()) {
                ExperienceRecordDto experienceRecordDto = new ExperienceRecordDto();
                // map individual fields
                experienceRecordDto.setCompany(experienceRecord.getCompany());
                experienceRecordDto.setPosition(experienceRecord.getPosition());
                experienceRecordDto.setStartDate(experienceRecord.getStartDate());
                experienceRecordDto.setEndDate(experienceRecord.getEndDate());
                experienceRecordDtos.add(experienceRecordDto);
            }
            candidatesDto.setExperienceRecord(experienceRecordDtos);
        }

        // Map education records
        if (candidatesEntity.getEducationRecord() != null) {
            List<EducationRecordDto> educationRecordDtos = new ArrayList<>();
            for (EducationRecord educationRecord : candidatesEntity.getEducationRecord()) {
                EducationRecordDto educationRecordDto = new EducationRecordDto();
                // Map individual fields
                educationRecordDto.setInstitution(educationRecord.getInstitution());
                educationRecordDto.setDegree(educationRecord.getDegree());
                educationRecordDto.setFieldOfStudy(educationRecord.getFieldOfStudy());
                educationRecordDto.setStartDate(educationRecord.getStartDate());
                educationRecordDto.setEndDate(educationRecord.getEndDate());
                educationRecordDtos.add(educationRecordDto);
            }
            candidatesDto.setEducationRecord(educationRecordDtos);
        }        
        
        candidatesDto.setSkills(candidatesEntity.getSkills());
        candidatesDto.setPreferences(candidatesEntity.getPreferences());
        candidatesDto.setSavedJobs(candidatesEntity.getSavedJobs());

        return candidatesDto;
    }
}
