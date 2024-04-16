package com.shuaibu.recruiters.service.impl;

import org.springframework.stereotype.Service;

import com.shuaibu.recruiters.entity.RecruitersEntity;
import com.shuaibu.recruiters.repository.RecruitersRepo;
import com.shuaibu.recruiters.service.RecruitersInterface;
import com.shuaibu.recruiters.service.dto.RecruitersDto;

@Service
public class RecruitersImpl implements RecruitersInterface {
    
    private RecruitersRepo recruitersRepo;

    public RecruitersImpl(RecruitersRepo recruitersRepo) {
        this.recruitersRepo = recruitersRepo;
    }

    @Override
    public RecruitersDto create(RecruitersDto dto) {
        RecruitersEntity entity = mapToEntity(dto);
        return mapToDto(recruitersRepo.save(entity));
    }

    @Override
    public RecruitersDto getById(Integer id) {
        return mapToDto(recruitersRepo.findById(id).orElseThrow());
    }

    @Override
    public RecruitersDto updateById(Integer id, RecruitersDto dto) {
        RecruitersEntity entity = recruitersRepo.findById(id).orElseThrow();

        entity.setCompanyName(dto.getCompanyName());
        entity.setDescription(dto.getDescription());
        entity.setYearFounded(dto.getYearFounded());
        entity.setWebsite(dto.getWebsite());
        entity.setLogoUrl(dto.getLogoUrl());
        entity.setAddress(dto.getAddress());
        entity.setState(dto.getState());
        entity.setCountry(dto.getCountry());
        entity.setEmployees(dto.getEmployees());
        entity.setSocialMedia(dto.getSocialMedia());
        entity.setContactEmail(dto.getContactEmail());

        return mapToDto(recruitersRepo.save(entity));
    }

    @Override
    public String deleteById(Integer id) {

        recruitersRepo.deleteById(id);

        return "Deleted successfully!";
    }

    /*
     * Utils classes for conversion
     */

    private RecruitersEntity mapToEntity(RecruitersDto dto) {
        RecruitersEntity entity = new RecruitersEntity();
    
        entity.setCompanyName(dto.getCompanyName());
        entity.setDescription(dto.getDescription());
        entity.setYearFounded(dto.getYearFounded());
        entity.setWebsite(dto.getWebsite());
        entity.setLogoUrl(dto.getLogoUrl());
        entity.setAddress(dto.getAddress());
        entity.setState(dto.getState());
        entity.setCountry(dto.getCountry());
        entity.setEmployees(dto.getEmployees());
        entity.setSocialMedia(dto.getSocialMedia());
        entity.setContactEmail(dto.getContactEmail());
    
        return entity;
    }

    private RecruitersDto mapToDto(RecruitersEntity entity) {
        RecruitersDto dto = new RecruitersDto();
    
        dto.setCompanyName(entity.getCompanyName());
        dto.setDescription(entity.getDescription());
        dto.setYearFounded(entity.getYearFounded());
        dto.setWebsite(entity.getWebsite());
        dto.setLogoUrl(entity.getLogoUrl());
        dto.setAddress(entity.getAddress());
        dto.setState(entity.getState());
        dto.setCountry(entity.getCountry());
        dto.setEmployees(entity.getEmployees());
        dto.setSocialMedia(entity.getSocialMedia());
        dto.setContactEmail(entity.getContactEmail());
    
        return dto;
    }
    

}
