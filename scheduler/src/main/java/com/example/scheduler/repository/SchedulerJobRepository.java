package com.example.scheduler.repository;

import com.example.scheduler.entity.SchedulerJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulerJobRepository extends JpaRepository<SchedulerJobEntity, String> {

    SchedulerJobEntity findByJobName(String jobName);
}
