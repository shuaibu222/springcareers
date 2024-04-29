package com.shuaibu.jobs.entity;


import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JobsResponse {

    private final List<JobsEntity> jobsEntity;
    private final int pageNumber;
    private final int pageSize;
    private final long totalElements;
    private final int totalPages;
    private final boolean isLastPage;

}
