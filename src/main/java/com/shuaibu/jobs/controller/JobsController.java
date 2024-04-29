package com.shuaibu.jobs.controller;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shuaibu.jobs.entity.JobsResponse;
import com.shuaibu.jobs.service.JobsInterface;
import com.shuaibu.jobs.service.dto.JobsDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class JobsController {

    private JobsInterface jobsInterface;

    JobsController(JobsInterface jobsInterface) {
        this.jobsInterface = jobsInterface;
    }
    
    @PostMapping("/api/v1/jobs")
    public ResponseEntity<JobsDto> postJob(@RequestBody JobsDto jobDTo) {
        return new ResponseEntity<JobsDto>(jobsInterface.create(jobDTo), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/jobs")
    public ResponseEntity<JobsResponse> getAllJobs(
            @RequestParam(name = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size,
            @RequestParam(name = "sort", required = false, defaultValue = "jobTitle") String sort,
            @RequestParam(name = "direction", required = false, defaultValue = "ASC") String direction
    ) {
        var pageRequestData = PageRequest.of(pageNumber - 1, size, Sort.Direction.valueOf(direction), sort);
        return new ResponseEntity<>(jobsInterface.getAll(pageRequestData), HttpStatus.PARTIAL_CONTENT);
    }

    @GetMapping("/api/v1/jobs/{id}")
    public ResponseEntity<JobsDto> getSingleJob(@PathVariable Integer id) {
        return ResponseEntity.ok(jobsInterface.getById(id));
    }

    @PutMapping("/api/v1/jobs/{id}")
    public ResponseEntity<JobsDto> updateAJob(@PathVariable Integer id, @RequestBody JobsDto dto) {
        return ResponseEntity.ok(jobsInterface.updateById(id, dto));
    }

    @DeleteMapping("/api/v1/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Integer id){
        return new ResponseEntity<>(jobsInterface.deleteById(id), HttpStatus.NO_CONTENT);
    }
    
}
