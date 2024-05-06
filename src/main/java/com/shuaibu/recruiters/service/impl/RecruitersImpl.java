package com.shuaibu.recruiters.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shuaibu.recruiters.entity.FileData;
import com.shuaibu.recruiters.entity.RecruitersEntity;
import com.shuaibu.recruiters.repository.ImageRepository;
import com.shuaibu.recruiters.repository.RecruitersRepo;
import com.shuaibu.recruiters.service.RecruitersInterface;
import com.shuaibu.recruiters.service.dto.RecruitersDto;

@Service
public class RecruitersImpl implements RecruitersInterface {
    
    private RecruitersRepo recruitersRepo;

    @Autowired
    private ImageRepository imageRepository;

    private static final String DIRECTORY_NAME = "springimages";

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

    // ------- Logo upload methods --------- //

    @SuppressWarnings("unused")
    public String uploadImage(MultipartFile file, Integer companyId) throws IOException {
        // Get the user's home directory
        String userHome = System.getProperty("user.home");

        // Create the directory path using the file separator
        String directoryPath = userHome + File.separator + DIRECTORY_NAME;
        
        String filePath = directoryPath + "/" + file.getOriginalFilename();

        FileData fileData = imageRepository.save(FileData.builder()
        .companyId(companyId)
        .name(file.getOriginalFilename())
        .type(file.getContentType())
        .filePath(filePath)
        .build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "Image Uploaded Successfully: " + filePath;
        }

        return null;
    }

    public byte[] downloadImageFromFileSystem(Integer cId) throws IOException {

        Optional<FileData> fileData = imageRepository.findByCompanyId(cId);
        String filePath = fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
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
