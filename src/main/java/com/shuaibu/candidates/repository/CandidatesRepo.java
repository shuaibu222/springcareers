package com.shuaibu.candidates.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shuaibu.candidates.entity.CandidatesEntity;

@Repository
public interface CandidatesRepo extends CrudRepository<CandidatesEntity, Integer> {}
