package com.shuaibu.recruiters.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shuaibu.recruiters.entity.FileData;

@Repository
public interface ImageRepository extends CrudRepository<FileData, Integer> {

    Optional<FileData> findByCompanyId(Integer cId);}
