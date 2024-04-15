package com.shuaibu.candidates.controller;

import org.springframework.web.bind.annotation.RestController;

import com.shuaibu.candidates.service.CandidatesInterface;
import com.shuaibu.candidates.service.dto.CandidatesDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class CandidatesController {

    private CandidatesInterface candidatesInterface;

    CandidatesController(CandidatesInterface candidatesInterface) {
        this.candidatesInterface = candidatesInterface;
    }

    
    @PostMapping("/api/v1/candidates")
    public ResponseEntity<CandidatesDto> addCandidate(@RequestBody CandidatesDto candidatesDto) {
        return new ResponseEntity<CandidatesDto>(candidatesInterface.create(candidatesDto), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/candidates/{id}")
    public ResponseEntity<CandidatesDto> getCandidateByHisId(@PathVariable int id) {
        return new ResponseEntity<CandidatesDto>(candidatesInterface.getById(id), HttpStatus.OK);
    }

    @PutMapping("/api/v1/candidates/{id}")
    public ResponseEntity<CandidatesDto> updateCandidateById(@PathVariable int id, @RequestBody CandidatesDto entity) {
        return new ResponseEntity<CandidatesDto>(candidatesInterface.updateById(id, entity), HttpStatus.OK);
    }

    @DeleteMapping("/api/v1/candidates/{id}")
    public ResponseEntity<String> deleteCandidateById(@PathVariable int id) {
        return new ResponseEntity<String>(candidatesInterface.deleteById(id), HttpStatus.NO_CONTENT);
    }
    
    
}
