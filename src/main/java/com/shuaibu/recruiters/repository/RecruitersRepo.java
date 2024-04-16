package com.shuaibu.recruiters.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shuaibu.recruiters.entity.RecruitersEntity;

@Repository
public interface RecruitersRepo extends CrudRepository<RecruitersEntity, Integer> {}
