package com.shuaibu.jobs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.shuaibu.jobs.entity.JobsEntity;

public interface JobsRepo extends CrudRepository<JobsEntity, Integer>, PagingAndSortingRepository<JobsEntity, Integer>  {}
