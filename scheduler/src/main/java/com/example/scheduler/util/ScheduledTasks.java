package com.example.scheduler.util;

import com.example.scheduler.entity.SchedulerJobEntity;
import com.example.scheduler.repository.SchedulerJobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final SchedulerJobRepository schedulerJobRepository;
    public ScheduledTasks(SchedulerJobRepository schedulerJobRepository) {

        this.schedulerJobRepository = schedulerJobRepository;
    }

    @Scheduled(fixedRate = 60000)
    public void scheduleTaskWithFixedRate() {
        logger.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()) );
        SchedulerJobEntity jobEntity = schedulerJobRepository.findByJobName("URL_DELETE_JOB");
        jobEntity.setUpdated(new Date());
        schedulerJobRepository.save(jobEntity);
    }
}
