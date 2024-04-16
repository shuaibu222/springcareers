package com.shuaibu.recruiters.controller;

import org.springframework.web.bind.annotation.RestController;

import com.shuaibu.recruiters.service.dto.RecruitersDto;
import com.shuaibu.recruiters.service.impl.RecruitersImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class RecruitersController {

    private RecruitersImpl recruitersImpl;

    public RecruitersController(RecruitersImpl recruitersImpl) {
        this.recruitersImpl = recruitersImpl;
    }


    @PostMapping("/api/v1/recruiters")
    public ResponseEntity<RecruitersDto> createNewCompany(@RequestBody RecruitersDto dto) {
        return new ResponseEntity<RecruitersDto>(recruitersImpl.create(dto), HttpStatus.CREATED);
    }
    
    
    @GetMapping("/api/v1/recruiters/{id}")
    public ResponseEntity<RecruitersDto> getCompanyById(@PathVariable int id) {
        return new ResponseEntity<RecruitersDto>(recruitersImpl.getById(id), HttpStatus.OK);
    }

    @PutMapping("/api/v1/recruiters/{id}")
    public ResponseEntity<RecruitersDto> updateCompany(@PathVariable int id, @RequestBody RecruitersDto dto) {
        return new ResponseEntity<RecruitersDto>(recruitersImpl.updateById(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/api/v1/recruiters/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable int id) {
        return new ResponseEntity<String>(recruitersImpl.deleteById(id), HttpStatus.NO_CONTENT);
    }
    
}
