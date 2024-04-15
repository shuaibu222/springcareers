package com.shuaibu.jobs.service;

import java.util.List;

import com.shuaibu.interfaces.CrudInterface;
import com.shuaibu.jobs.service.dto.JobsDto;

public interface JobsInterface extends CrudInterface<JobsDto> {
    List<JobsDto> getAll();
}
