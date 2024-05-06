package com.shuaibu;

import com.github.javafaker.Faker;
import com.shuaibu.jobs.entity.JobsEntity;
import com.shuaibu.jobs.repository.JobsRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class AppRunner implements CommandLineRunner {

    private static final int NUMBER_OF_JOBS = 20;
    private final JobsRepo repository;

    @Override
    public void run(String... args) {
        var faker = new Faker(new Locale("en-US"));
        var jobs = new ArrayList<JobsEntity>();

        for (int i = 0; i < NUMBER_OF_JOBS; i++) {
            List<String> requiredSkills = new ArrayList<>();
            requiredSkills.add(faker.job().keySkills());
            requiredSkills.add(faker.job().keySkills());
            requiredSkills.add(faker.job().keySkills());

            JobsEntity job = JobsEntity.builder()
                    .jobTitle(faker.job().title())
                    .companyName(faker.company().name())
                    .location(faker.address().cityName())
                    .jobType(faker.job().field())
                    .salaryRange((faker.job()).field())
                    .jobDesc(faker.lorem().paragraph())
                    .requiredSkills(requiredSkills)
                    .experienceLevel(faker.job().position())
                    .jobStatus(faker.options().option("Open", "Closed"))
                    .benefits(faker.lorem().paragraph())
                    .postedAt(faker.date().past(90, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toString())
                    .deadline(faker.date().future(30, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toString())
                    .applyContactInfo(faker.name().fullName() + " - " + faker.phoneNumber().phoneNumber())
                    .build();

            jobs.add(job);
        }

        repository.saveAll(jobs);
    }
}
