package com.shuaibu.jobs.service;

import org.springframework.data.domain.Pageable;

import com.shuaibu.interfaces.CrudInterface;
import com.shuaibu.jobs.entity.JobsResponse;
import com.shuaibu.jobs.service.dto.JobsDto;

public interface JobsInterface extends CrudInterface<JobsDto> {
    JobsResponse getAll(Pageable pageable);
}
